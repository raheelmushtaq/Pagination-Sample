package com.app.assesmenttest.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.assesmenttest.room.dao.CarsDao
import com.app.assesmenttest.room.entity.Cars

@Database(entities = [Cars::class], version = 1)
abstract class CarsDataBase : RoomDatabase() {

    abstract val carsDao: CarsDao

    companion object {
        const val DATABASE_NAME: String = "FitnessDatabase"
    }
}