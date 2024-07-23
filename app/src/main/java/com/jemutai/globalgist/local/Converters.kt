package com.jemutai.globalgist.local

import androidx.room.TypeConverters
import com.jemutai.globalgist.models.Source

class Converters {


    @TypeConverters
     fun fronSource(source:Source):String{
         return source.name
     }

    @TypeConverters
    fun toSource(name:String):Source{
        return  Source(name,name)
    }
}