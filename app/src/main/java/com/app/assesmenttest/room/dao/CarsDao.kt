package com.app.assesmenttest.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.assesmenttest.room.entity.Cars

@Dao
interface CarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Cars>)

    @Query("select * from cars")
    fun getAllMedicine(): PagingSource<Int, Cars>

    @Query("select Count(id) from cars")
    fun getTotalMedicineCount(): Int

    @Query("select * from cars where id = :id")
    suspend fun getMedicineById(id: String): Cars?

    @Query("Delete from cars")
    suspend fun clearAll()
}