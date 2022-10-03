package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "episode_table")
data class EpisodeEntity(
    val Actors: String,
    val Awards: String,
    val Country: String,
    val Director: String,
    val Episode: String,
    val Genre: String,
    val Language: String,
    val Metascore: String,
    val Plot: String,
    val Poster: String,
    val Rated: String,
    val Ratings: List<Rating>,
    val Released: String,
    val Response: String,
    val Runtime: String,
    val Season: String,
    val Title: String,
    val Type: String,
    val Writer: String,
    val Year: String,
    @PrimaryKey
    val imdbID: String,
    val imdbRating: String,
    val imdbVotes: String,
    val seriesID: String
)