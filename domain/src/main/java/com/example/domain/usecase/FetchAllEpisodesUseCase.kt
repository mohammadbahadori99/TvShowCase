package com.example.domain.usecase

import com.example.base.ResponseWrapper
import com.example.domain.model.Episode
import com.example.domain.repository.SeriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchAllEpisodesUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    operator fun invoke(): Flow<ResponseWrapper<List<Episode>>> = flow {
        try {
            emit(ResponseWrapper.Loading())
            val response = seriesRepository.getAllSeason()
            emit(ResponseWrapper.Success(response))
        } catch (e: Exception) {
            emit(ResponseWrapper.Error(e.message.toString(), null))
        }
    }
}