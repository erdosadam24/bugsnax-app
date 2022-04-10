package hu.bme.aut.bugsnaxapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.bugsnaxapp.network.BugsnaxService
import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import hu.bme.aut.bugsnaxapp.ui.main.MainRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMainRepository(
        bugsnaxService: BugsnaxService,
        bugsnakDao: BugsnakDao
    ) : MainRepository {
      return MainRepository(bugsnaxService, bugsnakDao)
    }
}