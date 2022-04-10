package hu.bme.aut.bugsnaxapp.ui.main

import hu.bme.aut.bugsnaxapp.network.BugsnaxService
import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val bugsnaxService: BugsnaxService,
    private val bugsnakDao: BugsnakDao
) {
    // TODO: Load Bugsnax Data

    // TODO: Delete Bugsnak Data
}