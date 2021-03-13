package com.platzi.config.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.config.R
import com.platzi.config.model.Speaker

class SpeakersAdapter() : RecyclerView.Adapter<SpeakersAdapter.ViewHolder>() {
    var listSpeakers = ArrayList<Speaker>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakersAdapter.ViewHolder {
        // Buscamos el id del layout
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SpeakersAdapter.ViewHolder, position: Int) {
        val speaker = listSpeakers[position]
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerJob.text = speaker.jobtitle
        //holder.ivSpeakerImage
    }

    override fun getItemCount(): Int {
        return listSpeakers.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /// Realizar aca la extraccion de los ids del layout
        val ivSpeakerImage = view.findViewById<ImageView>(R.id.ivSpeakerImage)
        val tvSpeakerName = view.findViewById<TextView>(R.id.tvSpeakerName)
        val tvSpeakerJob = view.findViewById<TextView>(R.id.tvSpeakerJob)

    }

}