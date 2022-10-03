package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.TvShowDataBase
import com.example.data.utils.Constants.DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TvShowDataBase::class.java, DATA_BASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(database: TvShowDataBase) = database.tvShowDao()
}