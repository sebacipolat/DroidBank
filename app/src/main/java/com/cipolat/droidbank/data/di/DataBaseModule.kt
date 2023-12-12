package com.cipolat.droidbank.data.di

import android.content.Context
import androidx.room.Room
import com.cipolat.droidbank.data.database.AppDataBase
import com.cipolat.droidbank.data.database.DataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "DROID_BANK_DATABASE"
        ).build()
    }
    @Singleton
    @Provides
    fun provideDataStore(bd:AppDataBase): DataStore {
        return DataStore(bd)
    }

}