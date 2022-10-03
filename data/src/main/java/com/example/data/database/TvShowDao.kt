package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.EpisodeEntity


@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEpisode(list: List<EpisodeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSeasons(list: List<EpisodeEntity>)

    @Query("SELECT * FROM episode_table")
    suspend fun getAllSeason(): List<EpisodeEntity>

}