package com.platzi.config.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.platzi.config.model.Conference
import com.platzi.config.model.Speaker

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(callback: Callback<List<Speaker>>): Unit {
        firebaseFirestore.collection("speakers")
            .orderBy("category")
            .get()
            .addOnSuccessListener { result->
                for (doc in result){
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(callback: Callback<List<Conference>>): Unit {
        firebaseFirestore.collection("conferences")
            .get()
            .addOnSuccessListener { result->
                for (doc in result){
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}