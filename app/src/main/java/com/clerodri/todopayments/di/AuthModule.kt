package com.clerodri.todopayments.di

import android.app.Application
import androidx.room.Room
import com.clerodri.todopayments.featureAuth.data.datasource.local.UserDao
import com.clerodri.todopayments.featureAuth.data.datasource.local.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app : Application): UserDatabase{
        return Room.databaseBuilder(
            app,UserDatabase::class.java,"users_db"
        ).build()
    }

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao = database.userDao()

}