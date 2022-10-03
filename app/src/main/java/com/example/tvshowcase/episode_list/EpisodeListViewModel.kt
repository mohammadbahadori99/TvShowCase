package com.example.tvshowcase.episode_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.ResponseWrapper
import com.example.domain.model.Episode
import com.example.domain.model.Season
import com.example.domain.usecase.FetchAllEpisodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EpisodeListViewModel @Inject constructor(private val useCase: FetchAllEpisodesUseCase) :
    ViewModel() {
    val episodeList: MutableLiveData<List<Episode>> by lazy {
        MutableLiveData<List<Episode>>()
    }

    fun getSeasons() {
        useCase.invoke().onEach { responseWrapper ->
            when (responseWrapper) {
                is ResponseWrapper.Loading -> {
                    //TODO:set value to a livedata to show a progress bar
                }
                is ResponseWrapper.Success -> {
                    val allSeason = groupBySeason(responseWrapper.data)
                    episodeList.postValue(responseWrapper.data)
                }
                is ResponseWrapper.Error -> {
                    //TODO:set value to a livedata to show a Snack Bar and retry action
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun groupBySeason(episodeList: List<Episode>?): List<Season> {
        episodeList?.let {
            val allSeasons: MutableList<Season> = mutableListOf()
            val allEpisode = episodeList.groupBy { it.seasonNumber }
            for (i in allEpisode.keys) {
                allSeasons.add(Season(i, allEpisode[i] ?: emptyList()))
            }
            return allSeasons
        }
        return emptyList()
    }
}