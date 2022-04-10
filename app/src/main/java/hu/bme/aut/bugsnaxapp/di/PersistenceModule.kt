package hu.bme.aut.bugsnaxapp.di

import android.app.Application
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
        return DB()
    }

    @Provides
    @Singleton
    fun provideBugsnakDao(appDatabase: AppDatabase): BugsnakDao {
        return DAO()
    }
}

// For Testing
class DAO: BugsnakDao { }

// For Testing
class DB: AppDatabase() {
    override fun bugsnakDao(): BugsnakDao {
        return DAO()
    }
}