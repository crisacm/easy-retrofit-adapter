package com.github.crisacm.module.easyretrofit.model

sealed interface ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>
    data class Failed(val message: String) : ApiResult<Nothing>
    data class Error(val t: Throwable) : ApiResult<Nothing>
}

fun <T> ApiResult<T>.onSuccess(
    block: ApiResult.Success<T>.() -> Unit
): ApiResult<T> {
    if (this is ApiResult.Success) block()
    return this
}

fun <T> ApiResult<T>.onFailed(
    block: ApiResult.Failed.() -> Unit
): ApiResult<T> {
    if (this is ApiResult.Failed) block()
    return this
}

fun <T> ApiResult<T>.onError(
    block: ApiResult.Error.() -> Unit
): ApiResult<T> {
    if (this is ApiResult.Error) block()
    return this
}

suspend fun <T> ApiResult<T>.onSuspendSuccess(
    block: suspend ApiResult.Success<T>.() -> Unit
): ApiResult<T> {
    if (this is ApiResult.Success) block(this)
    return this
}

suspend fun <T> ApiResult<T>.onSuspendFailed(
    block: suspend ApiResult.Failed.() -> Unit
): ApiResult<T> {
    if (this is ApiResult.Failed) block(this)
    return this
}

suspend fun <T> ApiResult<T>.onSuspendError(
    block: suspend ApiResult.Error.() -> Unit
): ApiResult<T> {
    if (this is ApiResult.Error) block(this)
    return this
}
