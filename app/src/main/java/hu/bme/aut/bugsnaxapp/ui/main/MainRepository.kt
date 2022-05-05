package hu.bme.aut.bugsnaxapp.ui.main

import android.util.Log
import android.widget.Toast
import androidx.annotation.WorkerThread
import hu.bme.aut.bugsnaxapp.client.apis.BugsnaxApi
import hu.bme.aut.bugsnaxapp.client.models.InlineResponse200
import hu.bme.aut.bugsnaxapp.model.Bugsnak
import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val bugsnaxApi: BugsnaxApi,
    private val bugsnakDao: BugsnakDao
) {
    @WorkerThread
    fun loadBugsnaxData(): List<Bugsnak> {
        val converted = bugsnakDao.getBugsnakList().toMutableList()
        if (converted.isEmpty()) {
            bugsnaxApi.getBugsnax().subscribe(
                { v ->
                    v.bugsnax?.forEach { bugsnak ->
                        var newId: Long = 0L
                        if (bugsnak.id != null) {
                            newId = bugsnak.id!!.toLong()
                        }
                        converted.add(
                            Bugsnak(
                                id = newId,
                                location = (bugsnak.location?.name ?: ""),
                                name = (bugsnak.name ?: ""),
                                userAdded = false
                            )
                        )
                        Log.e("Info", "Bugsnak added: " + bugsnak.name)
                    }
                    bugsnakDao.insertBugsnakList(converted)
                },
                { e -> Log.e(null, "ERROR: $e") }
            )
        }
        return converted
    }

    fun deleteBugsnak(id: Long) {
        bugsnakDao.removeBugsnak(id)
    }
}