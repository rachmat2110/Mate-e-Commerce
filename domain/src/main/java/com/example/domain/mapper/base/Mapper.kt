package com.example.domain.mapper.base

interface Mapper<T, E> {
    fun to (t: T) : E
}