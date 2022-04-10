package hu.bme.aut.bugsnaxapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.bugsnaxapp.network.BugsnaxService
import javax.inject.Singleton

// For Testing
class Service : BugsnaxService { }


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideBugsnaxService(): BugsnaxService {
        return Service()
    }
}