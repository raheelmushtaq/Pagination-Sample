package com.app.assesmenttest.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cars")
data class Cars(
    val make: String? = "",
    val model: String? = "",
    val drive: String? = "",
    val engid: String? = "",
    val fueltype: String? = "",
    val trany: String? = "",
    val vclass: String? = "",
    val year: String? = "",
    val ucity: String? = "",
    val pv2: String? = "",
    val pv4: String? = "",
    val barrels08: String? = "",
    val cylinders: String? = "",
    val displ: String? = "",
    val createdon: String? = "",
    val modifiedon: String? = "",
    @PrimaryKey val id: String
) : Parcelable