package com.github.crisacm.retrofitadapters.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.crisacm.retrofitadapters.R
import com.github.crisacm.retrofitadapters.api.model.News
import com.github.crisacm.retrofitadapters.databinding.ItemNewsBinding
import com.skydoves.bindables.BindingListAdapter
import com.skydoves.bindables.binding

class NewsAdapter : BindingListAdapter<News, NewsAdapter.NewsNewHolder>(diffUtil) {

    override fun onBindViewHolder(holder: NewsNewHolder, position: Int) = holder.bindPokemon(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsNewHolder =
        parent.binding<ItemNewsBinding>(R.layout.item_news).let(::NewsNewHolder)

    inner class NewsNewHolder(
        private val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindPokemon(news: News) {
            binding.news = news
            binding.executePendingBindings()
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<News>() {

            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean =
                oldItem == newItem
        }
    }
}
