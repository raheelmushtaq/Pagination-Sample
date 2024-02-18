package com.app.assesmenttest.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.assesmenttest.room.entity.Medicine

interface MedicineRepository {

    suspend fun insertAll(list: List<Medicine>)

    fun getAllMedicine(): PagingSource<Int, Medicine>

    fun getTotalMedicineCount(): Int

    suspend fun getMedicineById(id: Int): Medicine?

    suspend fun clearAll()
}