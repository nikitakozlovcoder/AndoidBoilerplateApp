package com.example.boilerplate.repos.interfaces

import com.example.boilerplate.models.PositionRes

interface IPositionRepo {
    suspend fun getAll(): List<PositionRes>
    suspend fun get(): PositionRes?
}