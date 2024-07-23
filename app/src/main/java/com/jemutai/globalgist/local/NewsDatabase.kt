package com.jemutai.globalgist.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jemutai.globalgist.models.Article
import com.jemutai.globalgist.models.NewsResponse
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [Article::class],
    version = 1)
@TypeConverters(Converters::class)
abstract  class NewsDatabase:RoomDatabase() {


     abstract  fun  getNewsDao():NewsDao

     @OptIn(InternalCoroutinesApi::class)
     companion object{
         @Volatile
         private  var instance :NewsDatabase? = null
         private  val LOCK = Any()

         operator  fun  invoke (context: Context) = instance?: synchronized(LOCK){

             instance ?: createDatabase(context).also{
             instance = it
             }
         }

         private fun createDatabase(context: Context) =
             Room.databaseBuilder(
                 context.applicationContext,NewsDatabase::class.java,
                 "News_db"
             )
                 .build()


     }
}