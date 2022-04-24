package hu.bme.aut.bugsnaxapp.ui.main

import hu.bme.aut.bugsnaxapp.client.apis.BugsnaxApi
import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val bugsnaxApi: BugsnaxApi,
    private val bugsnakDao: BugsnakDao
) {
    // TODO: Load Bugsnax Data

    fun test() {
        bugsnaxApi.getBugsnax()
    }

    // TODO: Delete Bugsnak Data
}