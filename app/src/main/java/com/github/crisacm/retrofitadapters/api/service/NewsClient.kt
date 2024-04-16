package com.github.crisacm.retrofitadapters.api.service

import com.github.crisacm.module.easyretrofit.model.ApiResult
import com.github.crisacm.retrofitadapters.api.model.Business
import javax.inject.Inject

class NewsClient @Inject constructor(
    private val newsService: NewsService
) {

    suspend fun fetchNews(): ApiResult<Business> = newsService.getNews()
}
