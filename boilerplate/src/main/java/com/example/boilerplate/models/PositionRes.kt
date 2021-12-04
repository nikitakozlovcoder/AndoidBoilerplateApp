package com.example.boilerplate.models

data class PositionRes(val results: Array<Position>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PositionRes

        if (!results.contentEquals(other.results)) return false

        return true
    }

    override fun hashCode(): Int {
        return results.contentHashCode()
    }
}