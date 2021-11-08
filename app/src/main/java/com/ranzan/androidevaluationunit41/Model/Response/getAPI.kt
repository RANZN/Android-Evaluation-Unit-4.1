package com.ranzan.androidevaluationunit41.Model.Response

import retrofit2.Call
import retrofit2.http.GET

interface getAPI {
    @GET("api/")
    fun getData(): Call<Response>
}