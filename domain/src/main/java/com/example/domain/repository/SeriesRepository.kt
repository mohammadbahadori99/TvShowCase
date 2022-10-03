package com.example.domain.repository

import com.example.domain.model.Episode

interface SeriesRepository {
    suspend fun getAllSeason(): List<Episode>
}