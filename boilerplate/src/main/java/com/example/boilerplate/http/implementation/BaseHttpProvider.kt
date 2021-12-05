package com.example.boilerplate.http.implementation
import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.lang.reflect.Type

class BaseHttpProvider {
    private val client = OkHttpClient()
    val mediaType = "application/json; charset=utf-8".toMediaType()
    suspend inline fun <reified TResult> get(url: String): TResult? = withContext(Dispatchers.IO) {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        val resp = makeRequest(request)
        return@withContext parse(resp)
    }
    suspend inline fun <reified T, reified TResult> post(url: String, data: T): TResult?  = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(url)
        if (data is FormBody){
          request.post(data)
        }
        else {
            val encoded = encode(data).toRequestBody(mediaType)
            request.post(encoded)
        }
        val resp = makeRequest(request.build())
        return@withContext parse(resp)

    }
    suspend inline fun <reified T, reified TResult> put(url: String, data: T): TResult?  = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(url)
        if (data is FormBody){
            request.put(data)
        }
        else {
            val encoded = encode(data).toRequestBody(mediaType)
            request.put(encoded)
        }
        val resp = makeRequest(request.build())
        return@withContext parse(resp)

    }
    suspend inline fun <reified T, reified TResult> delete(url: String, data: T?): TResult?  = withContext(Dispatchers.IO) {
        val request = Request.Builder().url(url)
        if (data != null) {
            if (data is FormBody){
                request.delete(data)
            }
            else {
                val encoded = encode(data).toRequestBody(mediaType)
                request.delete(encoded)
            }
        }
        else {
            request.delete()
        }
        val resp = makeRequest(request.build())
        return@withContext parse(resp)
    }
    fun makeRequest(request: Request): String? {
        Log.d("http", request.toString())
        client.newCall(request).execute().use { response ->
            Log.d("http", response.toString())
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            return response.body?.string()
        }
    }
    companion object {
        inline fun <reified T> parse(res: String?): T? {
            val type: Type = object : TypeToken<T?>() {}.type
            return GsonBuilder().create().fromJson(res, type)
        }

        inline fun <reified T> encode(obj: T): String {
            val type: Type = object : TypeToken<T>() {}.type
            return GsonBuilder().create().toJson(obj)
        }
    }

}