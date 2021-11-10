package com.example.advweek4.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.Volley.newRequestQueue
import com.example.advweek4.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailListModel(application: Application): AndroidViewModel(application){
    val studentLD = MutableLiveData<Student>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(id: String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=$id"

        val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    val result = Gson().fromJson<Student>(response,
                            Student::class.java)
                    studentLD.value=result
                    Log.d("showvoley", result.toString())
                },
                {
                    Log.d("showvoley", it.toString())
                })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}