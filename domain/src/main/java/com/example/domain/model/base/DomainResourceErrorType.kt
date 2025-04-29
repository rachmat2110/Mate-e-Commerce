package com.example.domain.model.base

enum class DomainResourceErrorType(
    val value: String
) {
    ERROR_SYSTEM("System Error"),
    MAINTENANCE("System is being maintenance"),
    UNAUTHORIZED("Unauthorized"),
    NOT_FOUND("Not Found"),
    BAD_REQUEST("Bad Request"),
    NETWORK("Something went wrong with your network"),
    UNKNOWN("Unknown error happened!"),
    CONFLICT("Conflict")
}