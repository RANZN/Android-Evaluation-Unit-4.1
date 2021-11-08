package com.ranzan.androidevaluationunit41.Model.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ResponseDB")
data class DataEntity(
    @ColumnInfo(name = "Name")
    val name: String,

    @ColumnInfo(name = "Gender")
    val gender: String,

    @ColumnInfo(name = "City")
    val city: String,

    @ColumnInfo(name = "County")
    val country: String,

    @ColumnInfo(name = "Phone")
    val phone: String,

    @ColumnInfo(name = "DOB")
    val dob: String,

    @PrimaryKey
    @ColumnInfo(name = "Email")
    val email: String,

    @ColumnInfo(name = "PicURI")
    val pic: String
//    Photo, Name, Gender, City, Country, Phone, Date of birth, Email.
)