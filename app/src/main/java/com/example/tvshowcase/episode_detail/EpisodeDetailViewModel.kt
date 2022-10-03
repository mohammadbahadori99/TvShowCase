package com.example.tvshowcase.episode_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.model.Episode
import com.example.tvshowcase.utils.Constant.EPISODE_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) :
    ViewModel() {
    private var _episode: MutableLiveData<Episode> = MutableLiveData()
    val episode: LiveData<Episode> get() = _episode

    init {
        _episode.value = savedStateHandle.get<Episode>(EPISODE_KEY)
    }

}