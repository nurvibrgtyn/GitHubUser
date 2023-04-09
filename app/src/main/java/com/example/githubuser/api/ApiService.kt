package com.example.githubuser.api

import com.example.githubuser.data.model.DetailUserResponse
import com.example.githubuser.data.model.User
import com.example.githubuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String,
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}