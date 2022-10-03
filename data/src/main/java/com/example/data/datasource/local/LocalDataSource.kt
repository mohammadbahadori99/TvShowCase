package com.example.data.datasource.local

import com.example.data.database.TvShowDao
import com.example.data.model.EpisodeEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: TvShowDao) {
    suspend fun getAllEpisode(): List<EpisodeEntity> = dao.getAllSeason()
    suspend fun insertAllEpisodes(allSeasons: List<EpisodeEntity>) {
        dao.insertAllSeasons(allSeasons)
    }
}