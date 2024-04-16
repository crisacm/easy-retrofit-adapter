package com.github.crisacm.retrofitadapters.api.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Business(
    @field:Json(name = "Business") val news: List<News>
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class News(
    @field:Json(name = "link") val link: String,
    @field:Json(name = "og") val og: String,
    @field:Json(name = "source") val source: String,
    @field:Json(name = "source_icon") val sourceIcon: String,
    @field:Json(name = "title") val title: String,
) : Parcelable
