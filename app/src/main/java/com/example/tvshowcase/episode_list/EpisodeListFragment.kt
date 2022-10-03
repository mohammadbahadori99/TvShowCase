package com.example.tvshowcase.episode_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tvshowcase.R
import com.example.tvshowcase.databinding.FragmentEpisodeListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeListFragment : Fragment() {
    private val adapter = EpisodeAdapter {
        findNavController().navigate(
            EpisodeListFragmentDirections.actionEpisodeListFragmentToEpisodeDetailFragment(
                it
            )
        )
    }
    private var _binding: FragmentEpisodeListBinding? = null
    private val binding get() = _binding!!
    private val vm: EpisodeListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpisodeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeObserver(adapter)
        vm.getSeasons()
    }

    private fun initializeObserver(adapter: EpisodeAdapter) {
        vm.episodeList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initializeViews() {
        requireActivity().title = resources.getString(R.string.app_name)
        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.rv_episode_list)
        recyclerView.adapter = adapter


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}