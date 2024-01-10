package com.example.studyspot.managers

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.entities.UserModel
import com.example.studyspot.modules.Map_Screen.mapDetailViewModel
import com.example.studyspot.ui.theme.StudySpotTheme
import com.example.studyspot.utilities.errors.FireBaseError
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FireBaseManager {
    private val userDBReference: DatabaseReference = FirebaseDatabase
        .getInstance()
        .getReference("Users")
    private val restaurantDBRefrance: DatabaseReference = FirebaseDatabase
        .getInstance()
        .getReference("Restaurant")
    private lateinit var auth: FirebaseAuth

    fun createAUser(user: UserModel): FireBaseError {
        val userId = userDBReference.push().key!!
        auth = Firebase.auth
        var error = FireBaseError.Sucess

        auth.createUserWithEmailAndPassword(user.eMail, user.password)
            .addOnCompleteListener() { task ->
                if(task.isSuccessful) {
                    val savedUser = FirebaseAuth.getInstance().currentUser
                    val uid = savedUser?.uid
                    user.id = uid
                    userDBReference.child(userId).setValue(user)
                        .addOnCompleteListener{
                            error = FireBaseError.Sucess
                        } .addOnFailureListener {
                            error = FireBaseError.ConnectionError
                        }
                } else {
                    error = FireBaseError.UndifiendError
                }
            }
        return error
    }

    fun readRestaurants(completion: (List<RestaurantModel>?) -> Unit){
        val restaurantPlaces = mutableListOf<RestaurantModel>()

        restaurantDBRefrance.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(rSnapshot in snapshot.children){
                    val place = rSnapshot.getValue(RestaurantModel::class.java)
                    if (place != null) {
                        restaurantPlaces.add(place)
                    }
                }
                completion(restaurantPlaces)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}

