package com.ranzan.androidevaluationunit41.viewModel

import androidx.lifecycle.ViewModel
import com.ranzan.androidevaluationunit41.Model.Response.Network
import com.ranzan.androidevaluationunit41.Model.Response.Response
import com.ranzan.androidevaluationunit41.Model.Response.getAPI
import com.ranzan.androidevaluationunit41.Model.RoomDB.DataDAO
import com.ranzan.androidevaluationunit41.Model.RoomDB.MainDataBase
import retrofit2.Call
import retrofit2.Callback

class Repo : ViewModel() {

    private lateinit var mainDataBase: MainDataBase
    private lateinit var dataDAO: DataDAO
    fun fetchAPI() {
        dataDAO = mainDataBase.getDataDao()
        val fetchAPI = Network.getRetrofitInstance().create(getAPI::class.java)
        fetchAPI.getData().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                dataDAO.insertData(response)
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
            }
        })
    }
}