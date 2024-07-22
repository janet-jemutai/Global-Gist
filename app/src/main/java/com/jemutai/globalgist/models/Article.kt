package com.jemutai.globalgist.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val sources: List<Source>,
    val status: String?
)