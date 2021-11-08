package com.ranzan.androidevaluationunit41.Model.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ranzan.androidevaluationunit41.Model.Response.Response

@Database(entities = [DataEntity::class], version = 1)
abstract class MainDataBase : RoomDatabase() {

    abstract fun getDataDao(): DataDAO

    companion object {
        private var INSTANCE: MainDataBase? = null
        fun getRoomDataBase(context: Context): MainDataBase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "room_db"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            } else return INSTANCE!!
        }
    }
}