package com.app.assesmenttest.ui.screens.home

import androidx.paging.PagingSource
import com.app.assesmenttest.room.MedicineRepository
import com.app.assesmenttest.room.dao.MedicineDao
import com.app.assesmenttest.room.entity.Medicine

class MedicineRepositoryImp(private val medicineDao: MedicineDao) : MedicineRepository {
    override suspend fun insertAll(list: List<Medicine>) {
        medicineDao.insertAll(list)
    }

    override fun getAllMedicine(): PagingSource<Int, Medicine> = medicineDao.getAllMedicine()

    override fun getTotalMedicineCount(): Int = medicineDao.getTotalMedicineCount()

    override suspend fun getMedicineById(id: Int): Medicine? = medicineDao.getMedicineById(id)

    override suspend fun clearAll() {
        medicineDao.clearAll()
    }
}