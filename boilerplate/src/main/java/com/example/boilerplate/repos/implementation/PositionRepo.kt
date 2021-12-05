package com.example.boilerplate.repos.implementation

import com.example.boilerplate.http.implementation.BaseHttpProvider
import com.example.boilerplate.models.PositionRes
import com.example.boilerplate.repos.interfaces.IPositionRepo


class PositionRepo: IPositionRepo {
    private val http = BaseHttpProvider()
    override suspend fun getAll(): List<PositionRes> {
        TODO()
    }
    override suspend fun get(): PositionRes? {
        return http.get("https://api.open-elevation.com/api/v1/lookup?locations=41.161758,-8.583933")
    }
}