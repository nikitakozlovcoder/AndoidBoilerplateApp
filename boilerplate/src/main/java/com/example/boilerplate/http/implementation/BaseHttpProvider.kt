package com.example.boilerplate.http.implementation
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.lang.reflect.Type
import kotlin.coroutines.CoroutineContext

class BaseHttpProvider {
    private val client = OkHttpClient()

    suspend inline fun <reified TResult> get(url: String): TResult? = withContext(Dispatchers.IO) {
        val resp = makeRequest(url)
        return@withContext parse(resp)
    }

   suspend inline fun <reified TResult> getAll(url: String): Collection<TResult> = withContext(Dispatchers.IO) {
        val resp = makeRequest(url)
       return@withContext parseAll(resp)

    }

    suspend inline fun <reified T, reified TResult> post(url: String, data: T): TResult?  = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")/* val resp = makeRequest(url, data)
        return responseParser.parse(resp)*/

    }

    suspend inline fun <reified T, reified TResult> postAll(url: String, data: T): Collection<TResult>  = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }

    fun makeRequest(url: String): String? {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            return response.body?.string()
        }
    }

    companion object {
        inline fun <reified T> parse(res: String?): T? {
            val type: Type = object : TypeToken<T?>() {}.type
            return GsonBuilder().create().fromJson(res, type)
        }

        inline fun <reified T> parseAll(res: String?): Collection<T> {
            val type: Type = object : TypeToken<Array<T>?>() {}.type
            return GsonBuilder().create().fromJson(res, type)
        }
    }

}