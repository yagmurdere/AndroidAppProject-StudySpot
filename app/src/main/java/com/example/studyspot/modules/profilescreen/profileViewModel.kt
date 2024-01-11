package com.example.studyspot.modules.profilescreen



import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.studyspot.R
import com.example.studyspot.managers.FireBaseManager

class profileViewModel:ViewModel() {
    val user_names = arrayOf(
        "John Doe",
        "John Doe",
        "John Doe",
        "John Doe",
        "John Doe"


    )
    val comments = arrayOf(
        "Müzik çok yüksekti ama kahve inanılmaz",
        "Masalar çok küçüktü. Ayrıca priz sayısı yeterli değildi",
        "Şu an çok güneş alıyor",
        "Çok kalabalık ve sesliydi",
        "Hiç beğenmedim"
    )
    val res_names=arrayOf(
        "Depo",
        "Top Roastry",
        "Kubbe",
        "Rektörlük",
        "GSF"
    )

    val fireBaseManager = FireBaseManager()

    fun fetchUser(){
        fireBaseManager.readUsers {
            if(it != null){
                for (item in it){
                    Log.d("doa", item.name!!)
                }
            }
        }
    }



}