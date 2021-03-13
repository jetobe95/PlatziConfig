package com.platzi.config.viewmodel

import androidx.lifecycle.MutableLiveData
import com.platzi.config.model.Conference
import com.platzi.config.model.Speaker
import com.platzi.config.network.Callback
import com.platzi.config.network.FirestoreService
import java.lang.Exception

class SpeakersViewModel {
    val firestoreService = FirestoreService()

    var speakersList = MutableLiveData<List<Speaker>>()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakersFromFirebase()
    }

    private fun getSpeakersFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
                speakersList.postValue(result)
                proccessFinished()
            }

            override fun onFailed(exception: Exception) {
                proccessFinished()
            }

        })

    }

    private fun proccessFinished() {
        isLoading.value = true
    }

}