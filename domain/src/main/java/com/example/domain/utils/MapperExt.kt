package com.example.domain.utils

import com.example.domain.mapper.base.Mapper

fun <A, B> A.mapTo(mapper: Mapper<A, B>) : B{
    return mapper.to(this)
}