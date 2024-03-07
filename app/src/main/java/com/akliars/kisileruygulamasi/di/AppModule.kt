package com.akliars.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.akliars.kisileruygulamasi.data.datasource.KisilerDataSource
import com.akliars.kisileruygulamasi.data.repo.KisilerRepository
import com.akliars.kisileruygulamasi.room.KisilerDao
import com.akliars.kisileruygulamasi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kds)
    }
    @Provides
    @Singleton
    fun provideDataSource(kdao:KisilerDao) : KisilerDataSource{
        return KisilerDataSource(kdao)
    }
    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context:Context) : KisilerDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite").build()
        return vt.getKisilerDao()
    }
}