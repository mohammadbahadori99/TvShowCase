package com.example.data.repositry

import com.example.data.datasource.file.FileDataSource
import com.example.data.datasource.local.LocalDataSource
import com.example.data.utils.toSeason
import com.example.domain.model.Episode
import com.example.domain.repository.SeriesRepository
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor(
    private val fileDataSource: FileDataSource,
    private val localDataSource: LocalDataSource
) : SeriesRepository {
    override suspend fun getAllSeason(): List<Episode> {
        var episodeList = localDataSource.getAllEpisode().toSeason()
        if (episodeList.isEmpty()) {
            val data = fileDataSource.fetchSeasons()
            localDataSource.insertAllEpisodes(data)
            episodeList = localDataSource.getAllEpisode().toSeason()
        }
        return episodeList
    }
}