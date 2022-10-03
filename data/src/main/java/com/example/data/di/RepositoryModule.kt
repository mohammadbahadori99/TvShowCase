package com.example.data.di

import com.example.data.repositry.SeriesRepositoryImpl
import com.example.domain.repository.SeriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindSeriesRepository(seriesRepositoryImpl: SeriesRepositoryImpl): SeriesRepository

}