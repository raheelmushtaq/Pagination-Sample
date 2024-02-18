package com.app.assesmenttest.remote

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.app.assesmenttest.room.MedicineRepository
import com.app.assesmenttest.room.database.MedicineDataBase
import com.app.assesmenttest.room.entity.Medicine
import com.app.assesmenttest.ui.screens.home.MedicineRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class MedicinePagingSourceMediator(
    private val medicineRepository: MedicineRepository, private val apiClient: ApiClient
) : RemoteMediator<Int, Medicine>() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, Medicine>
    ): MediatorResult {
        return try {
            val count = medicineRepository.getTotalMedicineCount()
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (count / state.config.pageSize) + 1
                    }
                }
            }
            withContext(Dispatchers.IO) {
                if (page == 1) {
                    val listofMedicine = apiClient.getMedicines()

                    if (loadType == LoadType.REFRESH) {
                        medicineRepository.clearAll()
                    }
                    medicineRepository.insertAll(listofMedicine)

                }
                MediatorResult.Success(endOfPaginationReached = count / state.config.pageSize >= page)
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)

        }
    }
}