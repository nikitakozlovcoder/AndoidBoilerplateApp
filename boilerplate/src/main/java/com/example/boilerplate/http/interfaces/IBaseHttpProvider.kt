package com.example.boilerplate.http.interfaces

interface IBaseHttpProvider<TResult> {
    suspend fun<T> get(url: String): TResult?
    suspend fun<T> getAll(url: String): Collection<TResult>
    suspend fun<T> post(url: String, data: T): TResult?
    suspend fun<T> postAll(url: String, data: T): Collection<TResult>
}