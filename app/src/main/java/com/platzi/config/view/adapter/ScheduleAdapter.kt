package com.platzi.config.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.config.R
import com.platzi.config.model.Conference
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listConference = ArrayList<Conference>()

    /// Cual sera el diseño para nuestra vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_schedule,
            parent,
            false
        )
    )

    override fun getItemCount() = listConference.size

    // COmo se enlazan los elemntos visuales
    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val conference = listConference[position] as Conference

        holder.tvConferenceName.text =  conference.title
        holder.tvSpeakerName.text =  conference.speaker
        holder.tvConferenceTag.text =  conference.tag

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val simpleDateFormatAMPM = SimpleDateFormat("a")

        val cal = Calendar.getInstance()
        cal.time = conference.dateTime

        val hourFormat = simpleDateFormat.format(conference.dateTime)
        holder.tvScheduleHour.text = hourFormat
        holder.tvConferenceAMPM.text = simpleDateFormatAMPM.format(conference.dateTime).toUpperCase()

     }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceDetail)
            val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
            val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleHourAMPM)
            val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceTag)
            val tvScheduleHour = itemView.findViewById<TextView>(R.id.txItemScheduleHour)
    }

    fun updateData(data:List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }
}