package com.example.data.utils

import androidx.room.TypeConverter
import com.example.data.model.Rating
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MyTypeConverter {
    @TypeConverter
    fun fromList(value: List<Rating>) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<Rating>>(value)
}