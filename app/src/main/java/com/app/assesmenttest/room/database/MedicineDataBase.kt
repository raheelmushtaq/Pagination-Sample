package com.app.assesmenttest.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.assesmenttest.room.dao.MedicineDao
import com.app.assesmenttest.room.entity.Medicine

@Database(entities = [Medicine::class], version = 1)
abstract class MedicineDataBase : RoomDatabase() {

    abstract val medicineDao: MedicineDao

    companion object {
        const val DATABASE_NAME: String = "FitnessDatabase"
    }
}