package com.app.assesmenttest.room.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Medicine")
@Parcelize
data class Medicine(
    @PrimaryKey val id: Int? = null,
    val name: String,
    val dose: String,
    val strength: String
) : Parcelable