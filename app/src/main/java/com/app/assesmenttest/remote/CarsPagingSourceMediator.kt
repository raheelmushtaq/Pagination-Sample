package com.app.assesmenttest.remote

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.app.assesmenttest.room.CarsRepository
import com.app.assesmenttest.room.entity.Cars
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class CarsPagingSourceMediator(
    private val carsRepository: CarsRepository, private val apiClient: ApiClient
) : RemoteMediator<Int, Cars>() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, Cars>
    ): MediatorResult {
        return try {
            val count = carsRepository.getTotalCarsCount()
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
            val carsResponse =
                apiClient.getCars(state.config.pageSize, state.config.pageSize * (page - 1))

            val isEnd = carsResponse.results.size + count > carsResponse.total_count

            withContext(Dispatchers.IO) {
                if (loadType === LoadType.REFRESH) {
                    carsRepository.clearAll()
                }
                carsRepository.insertAll(carsResponse.results)

                MediatorResult.Success(endOfPaginationReached = isEnd)
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)

        }
    }
}