package com.example.studyspot.managers

import android.content.Context
import com.example.studyspot.entities.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FireBaseManager {
    private val realTimeDBReferance: DatabaseReference = FirebaseDatabase
        .getInstance()
        .getReference("Users")
        private lateinit var auth: FirebaseAuth

    fun createAUser(user: UserModel): Boolean {
        val userId = realTimeDBReferance.push().key!!
        var isSuccess: Boolean = false
        auth = Firebase.auth

        auth.createUserWithEmailAndPassword(user.eMail, user.password)
            .addOnCompleteListener() { task ->
                if(task.isSuccessful) {
                    val savedUser = FirebaseAuth.getInstance().currentUser
                    val uid = savedUser?.uid
                    user.id = uid
                    realTimeDBReferance.child(userId).setValue(user)
                        .addOnCompleteListener{
                            isSuccess = true
                        } .addOnFailureListener {
                            isSuccess = false
                        }
                } else {

                    isSuccess = false
                }
            }
        return isSuccess
    }
}