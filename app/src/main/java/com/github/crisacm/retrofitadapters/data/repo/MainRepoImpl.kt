package com.github.crisacm.retrofitadapters.data.repo

import androidx.annotation.VisibleForTesting
import androidx.annotation.WorkerThread
import com.github.crisacm.module.easyretrofit.model.onError
import com.github.crisacm.module.easyretrofit.model.onSuspendSuccess
import com.github.crisacm.retrofitadapters.AppDispatchers
import com.github.crisacm.retrofitadapters.Dispatcher
import com.github.crisacm.retrofitadapters.api.model.Business
import com.github.crisacm.retrofitadapters.api.service.NewsClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import javax.inject.Inject

@VisibleForTesting
class MainRepoImpl @Inject constructor(
    private val newsClient: NewsClient,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : MainRepo {

    @WorkerThread
    override fun fetchNews(onComplete: () -> Unit, onError: (String?) -> Unit): Flow<Business> =
        flow {
            val response = newsClient.fetchNews()
            response.onSuspendSuccess {
                emit(data)
            }
                .onError {
                    onError("Failed fetching news")
                }
        }.onCompletion { onComplete() }.flowOn(ioDispatcher)
}
