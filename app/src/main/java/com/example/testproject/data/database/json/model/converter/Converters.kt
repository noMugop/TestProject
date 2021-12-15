package com.example.testproject.data.database.json.model.converter

import androidx.room.TypeConverter
import com.example.testproject.domain.repository.json.pojo.ShortScreenshot

import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<ShortScreenshot>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<ShortScreenshot>::class.java).toList()
}