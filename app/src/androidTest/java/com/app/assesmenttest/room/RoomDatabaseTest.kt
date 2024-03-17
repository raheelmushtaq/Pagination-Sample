package com.app.assesmenttest.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.app.assesmenttest.room.dao.CarsDao
import com.app.assesmenttest.room.database.CarsDataBase
import com.app.assesmenttest.room.entity.Cars
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class RoomDatabaseTest {

    lateinit var db: CarsDataBase
    lateinit var dao: CarsDao
    private fun getDB(context: Context): CarsDataBase {
        return Room.inMemoryDatabaseBuilder(
            context,
            CarsDataBase::class.java,
        ).allowMainThreadQueries().build()
    }

    @Before
    fun setUp() {
        db = getDB(ApplicationProvider.getApplicationContext())
        dao = db.carsDao
    }

    @Test
    fun insertRecord() = runBlocking {
        val list = arrayListOf<Cars>(
//            Cars(1, "Ved", "1", "500"),
//            Cars(3, "Ved 1", "1", "600"),
        )
        dao.insertAll(list)
        val count = dao.getTotalMedicineCount()
        assertEquals(2, count)
    }

    @Test
    fun getRecordById() = runBlocking {
        val list = arrayListOf<Cars>(
//            Cars(1, "Ved", "1", "500"),
//            Cars(2, "Ved 1", "1", "600"),
//            Cars(3, "Ved 5", "1", "600"),
        )
        dao.insertAll(list)

        val medicine1 = dao.getMedicineById("1")
        val medicine2 = dao.getMedicineById("10")

        assert(medicine1 != null)
        assert(medicine2 == null)

    }

    fun getDummyList(): ArrayList<Cars> {
        val list = arrayListOf<Cars>(
//            Cars(1, "Ved", "1", "500"),
//            Cars(2, "Ved 1", "1", "600"),
//            Cars(3, "Ved 5", "1", "600"),
//            Cars(4, "Ved 5", "1", "600"),
//            Cars(5, "Ved 5", "1", "600"),
//            Cars(6, "Ved 5", "1", "600"),
//            Cars(7, "Ved 5", "1", "600"),
//            Cars(8, "Ved 5", "1", "600"),
//            Cars(9, "Ved 5", "1", "600"),
//            Cars(10, "Ved 5", "1", "600"),
//            Cars(11, "Ved 5", "1", "600"),
//            Cars(12, "Ved 5", "1", "600"),
//            Cars(13, "Ved 5", "1", "600"),
//            Cars(14, "Ved 5", "1", "600"),
//            Cars(15, "Ved 5", "1", "600"),
//            Cars(16, "Ved 5", "1", "600"),
//            Cars(17, "Ved 5", "1", "600"),
//            Cars(18, "Ved 5", "1", "600"),
//            Cars(19, "Ved 5", "1", "600"),
//            Cars(20, "Ved 5", "1", "600"),
//            Cars(21, "Ved 5", "1", "600"),
//            Cars(22, "Ved 5", "1", "600"),
//            Cars(23, "Ved 5", "1", "600"),
//            Cars(24, "Ved 5", "1", "600"),
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