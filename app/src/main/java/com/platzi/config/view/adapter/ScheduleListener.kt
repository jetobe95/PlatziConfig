package com.platzi.config.view.adapter

import android.telecom.Conference

interface ScheduleListener {
    fun onConferenceClick(conference: Conference, position: Int)
}