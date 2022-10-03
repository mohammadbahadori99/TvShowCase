package com.example.data.datasource.file

import android.content.Context
import com.example.data.model.EpisodeEntity
import com.example.data.model.TvShowInformation
import com.example.data.utils.getAssetJsonData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class FileDataSource @Inject constructor(@ApplicationContext val context: Context) {
    fun fetchSeasons(): List<EpisodeEntity> {
        val stringValue = getAssetJsonData(context)
        stringValue?.let {
            val tvShowInformation = Json.decodeFromString<TvShowInformation>(stringValue)
            return tvShowInformation.seasons.flatMap { it.episodes }
        }
        return emptyList()
    }
}