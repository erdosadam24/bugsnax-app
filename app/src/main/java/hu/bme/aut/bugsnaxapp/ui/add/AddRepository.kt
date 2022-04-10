package hu.bme.aut.bugsnaxapp.ui.add

import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import javax.inject.Inject

class AddRepository @Inject constructor(
    private val bugsnakDao: BugsnakDao
) {
    // TODO: Add New Bugsnak
}