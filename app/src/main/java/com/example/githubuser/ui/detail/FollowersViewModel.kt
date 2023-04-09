package com.example.githubuser.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubuser.api.RetrofitClient
import com.example.githubuser.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel : ViewModel() {
    val listFollowers = MutableLiveData<ArrayList<User>>()

    //State ini akan menunjukkan apakah data sedang diambil dari server atau tidak.
    val loading = MutableLiveData<Boolean>()

    fun setListFollowers(username: String) {
        loading.value = true // set loading menjadi true
        RetrofitClient.apiInstance
            .getFollowers(username)
            .enqueue(object : Callback<ArrayList<User>> {
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
                    if (response.isSuccessful) {
                        listFollowers.postValue(response.body())
                        Log.d("viewModel", response.body()?.size.toString())
                    }
                    loading.value = false // set loading menjadi false
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    Log.d("Failure", t.message.toString())
                    loading.value = false // set loading menjadi false
                }
            })
    }

    fun getListFollowers(): LiveData<ArrayList<User>> {
        return listFollowers
    }


}