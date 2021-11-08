package com.ranzan.androidevaluationunit41.viewModel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.ranzan.androidevaluationunit41.Model.Response.Network
import com.ranzan.androidevaluationunit41.Model.Response.Response
import com.ranzan.androidevaluationunit41.Model.Response.getAPI
import com.ranzan.androidevaluationunit41.Model.RoomDB.DataDAO
import com.ranzan.androidevaluationunit41.Model.RoomDB.DataEntity
import com.ranzan.androidevaluationunit41.Model.RoomDB.MainDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback

class Repo(var context: Context) : ViewModel() {

    private lateinit var mainDataBase: MainDataBase
    private lateinit var dataDAO: DataDAO
    fun fetchAPI() {
        mainDataBase = MainDataBase.getRoomDataBase(context)
        dataDAO = mainDataBase.getDataDao()
        val fetchAPI = Network.getRetrofitInstance().create(getAPI::class.java)
        fetchAPI.getData().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val list = response.body()?.results?.get(0)!!
                var data = DataEntity(
                    list.name.toString(),
                    list.gender.toString(),
                    list.location!!.city.toString(),
                    list.location!!.country.toString(),
                    list.phone.toString(),
                    list.dob.toString(),
                    list.email.toString(),
                    list.picture!!.large.toString()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    dataDAO.insertData(data)
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
            }
        })
    }

    fun getData(lifecycle: LifecycleOwner): DataEntity {
        mainDataBase = MainDataBase.getRoomDataBase(context)
        dataDAO = mainDataBase.getDataDao()
        var data: DataEntity? = null
        dataDAO.getData().observe(lifecycle, Observer {
            data = it
        })
        return data!!
    }
}