package hu.bme.aut.bugsnaxapp.ui.main

import android.util.Log
import androidx.annotation.WorkerThread
import hu.bme.aut.bugsnaxapp.client.apis.BugsnaxApi
import hu.bme.aut.bugsnaxapp.client.models.InlineResponse200
import hu.bme.aut.bugsnaxapp.model.Bugsnak
import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val bugsnaxApi: BugsnaxApi,
    private val bugsnakDao: BugsnakDao
) {
    // TODO: Load Bugsnax Data

    @WorkerThread
    fun loadBugsnaxData() {
        bugsnaxApi.getBugsnax().subscribe(
            { v ->
                val converted = mutableListOf<Bugsnak>()
                v.bugsnax?.forEach { bugsnak ->
                    var newId: Long = 0L
                    if (bugsnak.id != null) {
                        newId = bugsnak.id!!.toLong()
                    }
                    converted.add(Bugsnak(
                    id = newId,
                    location = (bugsnak.location?.name ?: "" ),
                    name = (bugsnak.name ?: ""),
                    userAdded = false))
                }
                bugsnakDao.insertBugsnakList(converted)
            },
            { e -> Log.e(null, "ERROR: $e")}
        )
    }

    // TODO: Delete Bugsnak Data
}