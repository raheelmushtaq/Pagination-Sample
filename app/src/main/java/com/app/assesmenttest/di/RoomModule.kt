package com.app.assesmenttest.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.app.assesmenttest.remote.ApiClient
import com.app.assesmenttest.remote.MedicinePagingSourceMediator
import com.app.assesmenttest.room.MedicineRepository
import com.app.assesmenttest.room.database.MedicineDataBase
import com.app.assesmenttest.room.entity.Medicine
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
    fun provideSkillAssessmentsDatabase(@ApplicationContext context: Context): MedicineDataBase {
        return Room.databaseBuilder(
            context,
            MedicineDataBase::class.java,
            MedicineDataBase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .build()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideMedicinePager(
        medicineRepository: MedicineRepository,
        apiClient: ApiClient
    ): Pager<Int, Medicine> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = MedicinePagingSourceMediator(medicineRepository, apiClient),
            pagingSourceFactory = {
                medicineRepository.getAllMedicine()
            }
        )
    }
}