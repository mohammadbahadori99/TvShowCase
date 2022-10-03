package com.example.tvshowcase.episode_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.Episode
import com.example.tvshowcase.R

class EpisodeAdapter(private val onClick: (Episode) -> Unit) :
  ListAdapter<Episode, EpisodeAdapter.EpisodeViewHolder>(
        EpisodeDiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.episode_item, parent, false),
            onClick
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
    //TODO: we can use DataBinding here
    class EpisodeViewHolder(viewItem: View, private val onClick: (Episode) -> Unit) :
        RecyclerView.ViewHolder(viewItem) {
        fun onBind(episode: Episode) {
            itemView.setOnClickListener {
                onClick(episode)
            }
            val name: TextView = itemView.findViewById(R.id.tv_name_episodeItem)
            val number: TextView = itemView.findViewById(R.id.tv_episodeNumber_episodeItem)
            val imdbRating: TextView = itemView.findViewById(R.id.tv_imdbRating_episodeItem)
            val seasonNumber: TextView = itemView.findViewById(R.id.tv_seasonNumber_episodeItem)
            val imageView: ImageView = itemView.findViewById(R.id.iv_episodeCover_episodeItem)
            name.text = episode.episodeName
            imdbRating.text =
                itemView.context.resources.getString(R.string.label_imdb_rating, episode.imdbRating)
            number.text =
                itemView.context.resources.getString(R.string.label_episode, episode.episodeNumber)
            seasonNumber.text =
                itemView.context.resources.getString(R.string.label_season, episode.seasonNumber)
            Glide.with(itemView).load(episode.coverImageUrl)
                .placeholder(R.drawable.image_palce_holder).into(imageView)
        }

    }

}

object EpisodeDiffCallback : DiffUtil.ItemCallback<Episode>() {
    override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}