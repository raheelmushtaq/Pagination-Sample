package com.app.assesmenttest.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.app.assesmenttest.remote.ApiClient
import com.app.assesmenttest.remote.CarsPagingSourceMediator
import com.app.assesmenttest.room.CarsRepository
import com.app.assesmenttest.room.database.CarsDataBase
import com.app.assesmenttest.room.entity.Cars
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideSkillAssessmentsDatabase(@ApplicationContext context: Context): CarsDataBase {
        return Room.databaseBuilder(
            context,
            CarsDataBase::class.java,
            CarsDataBase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .build()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideMedicinePager(
        carsRepository: CarsRepository,
        apiClient: ApiClient
    ): Pager<Int, Cars> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = CarsPagingSourceMediator(carsRepository, apiClient),
            pagingSourceFactory = {
                carsRepository.getAllCars()
            }
        )
    }
}