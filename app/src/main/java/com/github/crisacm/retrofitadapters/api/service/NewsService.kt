package com.github.crisacm.retrofitadapters.api.service

import com.github.crisacm.module.easyretrofit.model.ApiResult
import com.github.crisacm.retrofitadapters.api.model.Business
import retrofit2.http.GET

interface NewsService {

    @GET("news-feed")
    suspend fun getNews(): ApiResult<Business>
}
