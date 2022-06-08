package com.idn.newsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.newsapp.DetailActivity
import com.idn.newsapp.data.News
import com.idn.newsapp.databinding.RowItemNewsBinding

class NewsAdapter(private val listNews: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val itemNewsBinding: RowItemNewsBinding) :
        RecyclerView.ViewHolder(itemNewsBinding.root) {

        fun bindItem(news: News) {
            itemNewsBinding.tvCategory.text = news.category
            itemNewsBinding.tvTime.text = news.time
            itemNewsBinding.tvDate.text = news.date
            itemNewsBinding.tvTitle.text = news.title
            itemNewsBinding.imgNews.setImageResource(news.photo)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(listNews[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.NEWS_DATA, listNews[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listNews.size

}