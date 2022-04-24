package hu.bme.aut.bugsnaxapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import javax.inject.Singleton
import hu.bme.aut.bugsnaxapp.persistence.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "BugsnaxApp.db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideBugsnakDao(appDatabase: AppDatabase): BugsnakDao {
        return appDatabase.bugsnakDao()
    }
}