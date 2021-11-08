package com.ranzan.androidevaluationunit41.Model.RoomDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DataDAO {
    @Insert
    fun insertData(response: DataEntity)

    @Update
    fun updateData(response: DataEntity)

    @Query("select * from ResponseDB")
    fun getData(): LiveData<DataEntity>

}