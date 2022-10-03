package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TvShowInformation(
    val seasons: List<SeasonModel>,
    val title: String
)

@Serializable
data class SeasonModel(
    val episodes: List<EpisodeEntity>
)