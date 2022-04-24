package hu.bme.aut.bugsnaxapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.bugsnaxapp.client.apis.BugsnaxApi
import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import hu.bme.aut.bugsnaxapp.ui.main.MainRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        bugsnaxApi: BugsnaxApi,
        bugsnakDao: BugsnakDao
    ) : MainRepository {
      return MainRepository(bugsnaxApi, bugsnakDao)
    }
}