package com.app.assesmenttest.ui.presentation.feature_cars

import androidx.paging.PagingSource
import com.app.assesmenttest.room.CarsRepository
import com.app.assesmenttest.room.dao.CarsDao
import com.app.assesmenttest.room.entity.Cars

class CarsRepositoryImp(private val carsDao: CarsDao) : CarsRepository {
    override suspend fun insertAll(list: List<Cars>) {
        carsDao.insertAll(list)
    }

    override fun getAllCars(): PagingSource<Int, Cars> = carsDao.getAllMedicine()

    override fun getTotalCarsCount(): Int = carsDao.getTotalMedicineCount()

    override suspend fun getCarsById(id: String): Cars? = carsDao.getMedicineById(id)

    override suspend fun clearAll() {
        carsDao.clearAll()
    }
}