package com.github.crisacm.retrofitadapters.ui.main

import androidx.databinding.Bindable
import androidx.lifecycle.viewModelScope
import com.github.crisacm.retrofitadapters.api.model.News
import com.github.crisacm.retrofitadapters.data.repo.MainRepo
import com.skydoves.bindables.BindingViewModel
import com.skydoves.bindables.asBindingProperty
import com.skydoves.bindables.bindingProperty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepo: MainRepo
) : BindingViewModel() {

    @get:Bindable
    var isLoading: Boolean by bindingProperty(true)
        private set

    @get:Bindable
    var toastMessage: String? by bindingProperty(null)
        private set

    private val newsListFlow = mainRepo.fetchNews(
        onComplete = { isLoading = false },
        onError = { toastMessage = it }
    ).map { it.news }

    @get:Bindable
    val newsList: List<News> by newsListFlow.asBindingProperty(viewModelScope, emptyList())
}
