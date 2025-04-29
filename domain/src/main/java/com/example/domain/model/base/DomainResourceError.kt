package com.example.domain.model.base

data class DomainResourceError (
    val message: String?,
    val errorType: DomainResourceErrorType? = null
)