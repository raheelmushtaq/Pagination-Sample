package com.app.assesmenttest.di

import com.app.assesmenttest.room.CarsRepository
import com.app.assesmenttest.room.database.CarsDataBase
import com.app.assesmenttest.ui.presentation.feature_cars.CarsRepositoryImp
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
    fun provideRepositoryModule(db: CarsDataBase): CarsRepository {
        return CarsRepositoryImp(db.carsDao)
    }
}