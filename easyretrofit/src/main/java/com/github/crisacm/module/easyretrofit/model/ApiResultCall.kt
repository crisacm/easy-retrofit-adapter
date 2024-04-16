package com.github.crisacm.module.easyretrofit.model

import com.github.crisacm.module.easyretrofit.utils.HttpStatusCodes
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class ApiResultCall<T>(
    private val callDelegate: Call<T>,
) : Call<ApiResult<T>> {

    override fun enqueue(callback: Callback<ApiResult<T>>) = callDelegate.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            response.body()?.let {
                when (response.code()) {
                    in HttpStatusCodes.C200.code..HttpStatusCodes.C208.code -> {
                        callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Success(it)))
                    }

                    in HttpStatusCodes.C400.code..HttpStatusCodes.C409.code -> {
                        callback.onResponse(
                            this@ApiResultCall,
                            Response.success(ApiResult.Failed("${response.code()} : ${response.message()}"))
                        )
                    }
                }
            } ?: callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Failed("message")))
        }

        override fun onFailure(call: Call<T>, throwable: Throwable) {
            callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Error(throwable)))
            call.cancel()
        }
    })

    override fun clone(): Call<ApiResult<T>> = ApiResultCall(callDelegate.clone())

    override fun execute(): Response<ApiResult<T>> =
        throw UnsupportedOperationException("ResponseCall does not support execute.")

    override fun isExecuted(): Boolean = callDelegate.isExecuted

    override fun cancel() = callDelegate.cancel()

    override fun isCanceled(): Boolean = callDelegate.isCanceled

    override fun request(): Request = callDelegate.request()

    override fun timeout(): Timeout = callDelegate.timeout()
}