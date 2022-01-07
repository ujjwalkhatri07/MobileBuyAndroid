package com.ujjwal.mobileShop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.mobileShop.R
import com.ujjwal.mobileShop.entity.Article

class SingleArticleAdapter (
    private val lstArticles: List<Article>,
    private val context: Context,
): RecyclerView.Adapter<SingleArticleAdapter.SingleArticleViewHolder>() {
    class SingleArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvArticleTitle: TextView = view.findViewById(R.id.tvArticleTitle)
        val tvArticleBody: TextView = view.findViewById(R.id.tvArticleBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_single_article_layout, parent, false)
        return SingleArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SingleArticleViewHolder, position: Int) {
        val article = lstArticles[position]
        holder.tvArticleTitle.text = article.article_title
        holder.tvArticleBody.text = article.article_body

    }

    override fun getItemCount(): Int {
        return lstArticles.size
    }
}