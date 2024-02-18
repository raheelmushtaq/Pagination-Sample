package com.app.assesmenttest.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.app.assesmenttest.room.dao.MedicineDao
import com.app.assesmenttest.room.database.MedicineDataBase
import com.app.assesmenttest.room.entity.Medicine
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class RoomDatabaseTest {

    lateinit var db: MedicineDataBase
    lateinit var dao: MedicineDao
    private fun getDB(context: Context): MedicineDataBase {
        return Room.inMemoryDatabaseBuilder(
            context,
            MedicineDataBase::class.java,
        ).allowMainThreadQueries().build()
    }

    @Before
    fun setUp() {
        db = getDB(ApplicationProvider.getApplicationContext())
        dao = db.medicineDao
    }

    @Test
    fun insertRecord() = runBlocking {
        val list = arrayListOf<Medicine>(
            Medicine(1, "Ved", "1", "500"),
            Medicine(3, "Ved 1", "1", "600"),
        )
        dao.insertAll(list)
        val count = dao.getTotalMedicineCount()
        assertEquals(2, count)
    }

    @Test
    fun getRecordById() = runBlocking {
        val list = arrayListOf<Medicine>(
            Medicine(1, "Ved", "1", "500"),
            Medicine(2, "Ved 1", "1", "600"),
            Medicine(3, "Ved 5", "1", "600"),
        )
        dao.insertAll(list)

        val medicine1 = dao.getMedicineById(1)
        val medicine2 = dao.getMedicineById(10)

        assert(medicine1 != null)
        assert(medicine2 == null)

    }

    fun getDummyList(): ArrayList<Medicine> {
        val list = arrayListOf<Medicine>(
            Medicine(1, "Ved", "1", "500"),
            Medicine(2, "Ved 1", "1", "600"),
            Medicine(3, "Ved 5", "1", "600"),
            Medicine(4, "Ved 5", "1", "600"),
            Medicine(5, "Ved 5", "1", "600"),
            Medicine(6, "Ved 5", "1", "600"),
            Medicine(7, "Ved 5", "1", "600"),
            Medicine(8, "Ved 5", "1", "600"),
            Medicine(9, "Ved 5", "1", "600"),
            Medicine(10, "Ved 5", "1", "600"),
            Medicine(11, "Ved 5", "1", "600"),
            Medicine(12, "Ved 5", "1", "600"),
            Medicine(13, "Ved 5", "1", "600"),
            Medicine(14, "Ved 5", "1", "600"),
            Medicine(15, "Ved 5", "1", "600"),
            Medicine(16, "Ved 5", "1", "600"),
            Medicine(17, "Ved 5", "1", "600"),
            Medicine(18, "Ved 5", "1", "600"),
            Medicine(19, "Ved 5", "1", "600"),
            Medicine(20, "Ved 5", "1", "600"),
            Medicine(21, "Ved 5", "1", "600"),
            Medicine(22, "Ved 5", "1", "600"),
            Medicine(23, "Ved 5", "1", "600"),
            Medicine(24, "Ved 5", "1", "600"),
        )
        return list
    }

    @Test
    fun getPagination() = runBlocking {

        dao.insertAll(getDummyList())

        val list = dao.getAllMedicine().getData()

        val count = dao.getTotalMedicineCount()

        assertEquals(list.size, count)
    }


    @After
    fun tearDown() {
        db.close()
    }


}