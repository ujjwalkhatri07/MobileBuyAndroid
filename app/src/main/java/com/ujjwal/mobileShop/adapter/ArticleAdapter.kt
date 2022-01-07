package com.ujjwal.mobileShop.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.mobileShop.R
import com.ujjwal.mobileShop.ViewSingleArticleActivity
import com.ujjwal.mobileShop.entity.Article

class ArticleAdapter (


        private val context: Context,
        ): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){
    var lstArticles= emptyList<Article>()

    fun setList(list: List<Article>){
        lstArticles = list
        notifyDataSetChanged()
    }
    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvArticleTitle: TextView = view.findViewById(R.id.tvArticleTitle)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_article_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = lstArticles[position]
        holder.tvArticleTitle.text = article.article_title
        holder.tvArticleTitle.setOnClickListener{
            val id = article._id
            val intent = Intent (context, ViewSingleArticleActivity::class.java)
            context.startActivity(intent.putExtra("article",id))
        }
    }
    override fun getItemCount(): Int {
        return lstArticles.size
    }
}