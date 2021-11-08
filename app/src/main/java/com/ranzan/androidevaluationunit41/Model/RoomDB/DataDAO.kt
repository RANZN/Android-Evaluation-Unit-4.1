package com.ranzan.androidevaluationunit41.Model.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ranzan.androidevaluationunit41.Model.Response.Response

@Dao
interface DataDAO {
    @Insert
    fun insertData(response: Response)

    @Update
    fun updateData(response: Response)

    @Query("select * from ResponseDB")
    fun getData(): LiveData<Response>

}