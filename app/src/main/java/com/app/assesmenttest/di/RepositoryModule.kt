package com.app.assesmenttest.di

import com.app.assesmenttest.room.MedicineRepository
import com.app.assesmenttest.room.dao.MedicineDao
import com.app.assesmenttest.room.database.MedicineDataBase
import com.app.assesmenttest.ui.screens.home.MedicineRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositoryModule(db: MedicineDataBase): MedicineRepository {
        return MedicineRepositoryImp(db.medicineDao)
    }
}