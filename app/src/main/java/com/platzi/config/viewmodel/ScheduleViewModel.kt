package com.platzi.config.viewmodel

import androidx.lifecycle.MutableLiveData
import com.platzi.config.model.Conference
import com.platzi.config.network.Callback
import com.platzi.config.network.FirestoreService
import java.lang.Exception

class ScheduleViewModel {
    val firestoreService = FirestoreService()
    val listSchedule = MutableLiveData<List<Conference>>()
    val isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getScheduleFromFirebase()
    }

    fun getScheduleFromFirebase() {
        firestoreService.getSchedule(object : Callback<List<Conference>> {
            override fun onSuccess(result: List<Conference>?) {
                listSchedule.postValue(result)
                proccessFinished()
            }

            override fun onFailed(exception: Exception) {
                proccessFinished()
            }

        })

    }

        fun proccessFinished() {
            isLoading.value = true
        }

}
