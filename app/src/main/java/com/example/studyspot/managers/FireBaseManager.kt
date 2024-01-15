package com.example.studyspot.managers

import android.util.Log
import com.example.studyspot.entities.BookMarkModel
import com.example.studyspot.entities.CommentModel
import com.example.studyspot.entities.CrawdedModel
import com.example.studyspot.entities.RestaurantModel
import com.example.studyspot.entities.UserModel
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
    private val commentDBReference: DatabaseReference = FirebaseDatabase
        .getInstance()
        .getReference("Comments")
    private val crawdedDBReference: DatabaseReference = FirebaseDatabase
        .getInstance()
        .getReference("Crawded")
    private val bookmarkDBReference: DatabaseReference = FirebaseDatabase
        .getInstance()
        .getReference("Bookmark")
    private lateinit var auth: FirebaseAuth

    fun createAUser(user: UserModel): FireBaseError {
        val userId = userDBReference.push().key!!
        auth = Firebase.auth
        var error = FireBaseError.Sucess

        user.eMail?.let {
            user.password?.let { it1 ->
                auth.createUserWithEmailAndPassword(it, it1)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            val savedUser = FirebaseAuth.getInstance().currentUser
                            val uid = savedUser?.uid
                            user.id = uid
                            userDBReference.child(userId).setValue(user)
                                .addOnCompleteListener {
                                    error = FireBaseError.Sucess
                                }.addOnFailureListener {
                                    error = FireBaseError.ConnectionError
                                }
                        } else {
                            error = FireBaseError.UndifiendError
                        }
                    }
            }
        }
        return error
    }

    fun createComment(comment: CommentModel) {
        val commentId = commentDBReference.push().key!!

        commentDBReference.child(commentId).setValue(comment)
            .addOnCompleteListener {

            }.addOnFailureListener {

            }
    }

    fun addCrawded(crawded: CrawdedModel): Boolean {
        val crawdedId = commentDBReference.push().key!!
        var isSuccess = false
        crawdedDBReference.child(crawdedId).setValue(crawded)
            .addOnCompleteListener{
                isSuccess = true
            } .addOnFailureListener {
                isSuccess = false
            }
        return isSuccess
    }

    fun addBookMark(bookmark: BookMarkModel): Boolean {
        val bookMarkId = commentDBReference.push().key!!
        var isSuccess = false
        bookmarkDBReference.child(bookMarkId).setValue(bookmark)
            .addOnCompleteListener{
                isSuccess = true
            } .addOnFailureListener {
                isSuccess = false
            }
        return isSuccess
    }

    fun fetchComment(completion: (List<CommentModel>) -> Unit) {
        val commentList = mutableListOf<CommentModel>()
        commentDBReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (item in snapshot.children) {
                    val comment = item.getValue(CommentModel::class.java)
                    commentList.add(comment!!)
                }
                completion(commentList)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    fun fetchUsers(completion: (List<UserModel>) -> Unit) {
        val userList = mutableListOf<UserModel>()
        userDBReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.map {
                    userList.add(it.getValue(UserModel::class.java)!!)
                }
                completion(userList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
    
    fun fetchCreawdedData(completion: (List<CrawdedModel>) -> Unit) {
        val crawdedList = mutableListOf<CrawdedModel>()
        crawdedDBReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.map {
                    crawdedList.add(it.getValue(CrawdedModel::class.java)!!)
                }
                completion(crawdedList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun removeCreawdedData(userId: String) {
        var key = ""
        crawdedDBReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.map {
                    if(it.getValue(CrawdedModel::class.java)!!.userId == userId) {
                        key = snapshot.key.toString()
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        crawdedDBReference.child(key).removeValue()
    }

    fun fetchBookMark(completion: (List<BookMarkModel>) -> Unit) {
        val bookmarkList = mutableListOf<BookMarkModel>()
        bookmarkDBReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.map {
                    bookmarkList.add(it.getValue(BookMarkModel::class.java)!!)
                }
                completion(bookmarkList)
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    
    fun removeBookMark(userId: String) {
        var key = ""
        bookmarkDBReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.map {
                    if(it.getValue(BookMarkModel::class.java)!!.userId == userId) {
                        key = snapshot.key.toString()
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        bookmarkDBReference.child(key).removeValue()
    }
    
    fun readRestaurants(completion: (List<RestaurantModel>?) -> Unit){
        val restaurantPlaces = mutableListOf<RestaurantModel>()

        restaurantDBRefrance.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(rSnapshot in snapshot.children){
                    val place = rSnapshot.getValue(RestaurantModel::class.java)
                    if (place != null) {
                        Log.e("doğa",place.toString())
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