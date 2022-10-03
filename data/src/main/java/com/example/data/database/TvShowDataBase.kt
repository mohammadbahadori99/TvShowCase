package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.model.EpisodeEntity
import com.example.data.utils.MyTypeConverter


@Database(entities = [EpisodeEntity::class], version = 1, exportSchema = false)
@TypeConverters(MyTypeConverter::class)
abstract class TvShowDataBase : RoomDatabase() {
    abstract fun tvShowDao(): TvShowDao
}