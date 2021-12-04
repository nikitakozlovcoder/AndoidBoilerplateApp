package com.example.boilerplate.repos.implementation

import com.example.boilerplate.http.implementation.BaseHttpProvider
import com.example.boilerplate.models.PositionRes
import com.example.boilerplate.repos.interfaces.IPositionRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PositionRepo: IPositionRepo {
    val http = BaseHttpProvider()
    override suspend fun getAll(): List<PositionRes> {
        TODO()
    }
    override suspend fun get(): PositionRes?{
        return http.get("https://api.open-elevation.com/api/v1/lookup?locations=41.161758,-8.583933")
    }
}