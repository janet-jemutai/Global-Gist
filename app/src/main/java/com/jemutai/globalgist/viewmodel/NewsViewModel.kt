package com.jemutai.globalgist.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jemutai.globalgist.models.NewsResponse
import com.jemutai.globalgist.repository.NewsRepo
import com.jemutai.globalgist.util.Resource
import okhttp3.Response

class NewsViewModel (val newsRepo:NewsRepo,app:Application): ViewModel() {

    val headLines: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var headlinesPage = 1
    var headLinesResponse: NewsResponse? = null

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1
    var searchNewsResponse: NewsResponse? = null
    var newSearchQuery: String? = null
    var oldSearchQuery: String? = null

    fun handleHeadLinesResponse(response: retrofit2.Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                headlinesPage++
                if (headLinesResponse == null) {
                    headLinesResponse = resultResponse

                } else {
                    val oldArticles = headLinesResponse?.articles
                    val newArticles = resultResponse.articles


                }


            }
        }
    }
}