package com.example.tvshowcase.episode_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tvshowcase.databinding.FragmentEpisodeDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EpisodeDetailFragment : Fragment() {

    private var _binding: FragmentEpisodeDetailBinding? = null
    private val binding get() = _binding!!

    private val vm: EpisodeDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodeDetailBinding.inflate(inflater, container, false)
        binding.vm = vm
        initializeToolbarTitle()
        return binding.root
    }

    private fun initializeToolbarTitle() {
        requireActivity().title = vm.episode.value?.episodeName
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}