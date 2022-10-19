package com.puyo.kapas.feature_kapas.data.source.remote.api

enum class HttpStatusCode(val value: String) {
    OK("200"),
    BadRequest("400"),
    NotFound("404"),
    Conflict("409")
}