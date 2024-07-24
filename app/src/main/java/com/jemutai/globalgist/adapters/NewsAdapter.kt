package com.jemutai.globalgist.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jemutai.globalgist.databinding.NewsItemBinding
import com.jemutai.globalgist.models.Article


class NewsAdapter(private  val articles: List<Article>,private var onArticleClick: (Article) -> Unit)
    :RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner  class  ArticleViewHolder(val binding:NewsItemBinding):RecyclerView.ViewHolder(binding.root){


        //fetchArticle

        fun bind(article: Article) {
            Glide.with(binding.ivArticleimage.context).load(article.urlToImage).into(binding.ivArticleimage)
            binding.tvsource.text = article.source.name
            binding.tvdate.text = article.publishedAt
            binding.tvtitle.text = article.title
            binding.tvarticledescription.text = article.description
            binding.root.setOnClickListener {
                onArticleClick(article)
            }

        }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
          return ArticleViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return  articles.size

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        holder.bind(articles[position])

    }

    fun  setOnArticleClickListerner(listerner:(Article)->Unit){
        onArticleClick = listerner
    }
}
