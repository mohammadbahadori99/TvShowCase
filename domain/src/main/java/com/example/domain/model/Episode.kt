package com.example.domain.model

import java.io.Serializable


data class Episode(
    val coverImageUrl: String,
    val seasonNumber: String,
    val episodeNumber: String,
    val episodeName: String,
    val summary: String,
    val director: String,
    val imdbRating: String,
    val year: String,
    val released: String,
    val duration: String,
) : Serializable