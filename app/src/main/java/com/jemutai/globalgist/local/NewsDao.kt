package com.jemutai.globalgist.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.jemutai.globalgist.models.Article



@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavourite(article: Article):Long

//    @Query("SELECT * FROM  articles")
//    fun  getAllArticles():LiveData<List<Article>>


    @Delete
    suspend fun deleteFavourite(article: Article):
}