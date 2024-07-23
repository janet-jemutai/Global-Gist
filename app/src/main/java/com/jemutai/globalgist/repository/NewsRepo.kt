package com.jemutai.globalgist.repository

import com.jemutai.globalgist.local.NewsDatabase
import com.jemutai.globalgist.models.Article
import com.jemutai.globalgist.remote.RetrofitClient

class NewsRepo(private  val db :NewsDatabase) {

    suspend fun  fetchHeadlines(countryCode: String,page:Int)=
        RetrofitClient.api.fetchHeadLines(countryCode,page)

    suspend fun  searchEverything(searchQuery :String, pageNumber : Int) =
        RetrofitClient.api.searchNews(searchQuery,pageNumber)

    suspend fun  addFavourites(article: Article) =
        db.getNewsDao().addFavourite(article)

    fun  getFavouriteNews() = db.getNewsDao().getAllArticles()

    suspend fun  deleteArticle(article: Article)= db.getNewsDao().deleteFavourite(article)
}