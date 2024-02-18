package com.app.assesmenttest.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.assesmenttest.room.entity.Medicine

@Dao
interface MedicineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Medicine>)

    @Query("select * from Medicine")
    fun getAllMedicine(): PagingSource<Int, Medicine>

    @Query("select Count(id) from Medicine")
    fun getTotalMedicineCount(): Int

    @Query("select * from Medicine where id = :id")
    suspend fun getMedicineById(id: Int): Medicine?

    @Query("Delete from Medicine")
    suspend fun clearAll()
}