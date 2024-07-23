package com.jemutai.globalgist.remote

import com.jemutai.globalgist.models.NewsResponse
import com.jemutai.globalgist.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
     suspend fun  fetchHeadLines(
        @Query("country") countryCode :String ="ke",
        @Query("pageNumber") page :Int = 1,
        @Query("apikey") apikey :String =API_KEY

     ):Response<NewsResponse>

@GET("/v2/everything")
     suspend fun  searchNews(
         @Query("q")searchQuery :String,
         @Query("page")pageNumber :Int = 1,
         @Query("apikey")apiKey :String = API_KEY):Response<NewsResponse>
}