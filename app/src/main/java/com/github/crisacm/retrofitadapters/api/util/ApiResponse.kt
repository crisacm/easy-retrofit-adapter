package com.github.crisacm.easyretrofitadapter.api.util

data class ApiResponse<T>(
    var success: Boolean,
    var error: ApiError?,
    var data: T?
)

data class ApiError(
    var code: String,
    var message: String
)
