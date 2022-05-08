package hu.bme.aut.bugsnaxapp.ui.main

import android.util.Log
import androidx.annotation.WorkerThread
import hu.bme.aut.bugsnaxapp.client.apis.BugsnaxApi
import hu.bme.aut.bugsnaxapp.model.Bugsnak
import hu.bme.aut.bugsnaxapp.persistence.BugsnakDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val bugsnaxApi: BugsnaxApi,
    private val bugsnakDao: BugsnakDao
) {
    @WorkerThread
    fun loadBugsnaxData(): List<Bugsnak> {
        val converted = bugsnakDao.getBugsnakList().toMutableList()
        if (converted.isEmpty()) {
            val v = bugsnaxApi.getBugsnax().blockingGet()
            v.bugsnax?.forEach { bugsnak ->
                if (bugsnak.id != null) {
                    val newId = bugsnak.id!!.toLong()

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
            }
        }
        return converted
    }

    fun deleteBugsnak(id: Long) {
        bugsnakDao.removeBugsnak(id)
    }
}