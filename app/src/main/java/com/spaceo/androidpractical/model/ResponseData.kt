package com.spaceo.androidpractical.model

data class ResponseData(
    val Message: String,
    val RecordCount: String,
    val Result: List<Result>,
    val Status: Int
)