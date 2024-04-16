package com.github.crisacm.retrofitadapters.data.repo

import androidx.annotation.WorkerThread
import com.github.crisacm.retrofitadapters.api.model.Business
import kotlinx.coroutines.flow.Flow

interface MainRepo {

    @WorkerThread
    fun fetchNews(
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<Business>
}
