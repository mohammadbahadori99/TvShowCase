package com.example.data.utils

import com.example.data.model.EpisodeEntity
import com.example.domain.model.Episode

fun EpisodeEntity.toEpisode() = Episode(
    coverImageUrl = this.Poster,
    seasonNumber = this.Season,
    episodeNumber = this.Episode,
    episodeName = this.Title,
    summary = this.Plot,
    director = this.Director,
    imdbRating = this.imdbRating,
    year = this.Year,
    duration = this.Runtime,
    released = this.Released
)

fun List<EpisodeEntity>.toSeason() = this.map { it.toEpisode() }