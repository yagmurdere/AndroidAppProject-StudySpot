package com.example.studyspot.managers

import com.example.studyspot.entities.UserModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FireBaseManager {
    private val usersDBReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("users")

    fun createAUser(user: UserModel): Boolean {
        val userId = usersDBReference.push().key!!
        var isSuccess: Boolean = false
        usersDBReference.child(userId).setValue(user)
            .addOnCompleteListener {
                isSuccess = true
        }.addOnFailureListener {
                isSuccess = false
            }
        return isSuccess
    }
}