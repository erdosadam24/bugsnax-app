package hu.bme.aut.bugsnaxapp.network

import android.util.Log
import hu.bme.aut.bugsnaxapp.client.apis.BugsnaxApi
import hu.bme.aut.bugsnaxapp.client.models.InlineResponse200
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BugsnaxApiTest : ApiAbstract<BugsnaxApi>() {

    lateinit var service: BugsnaxApi

    @Before
    fun createBugsnaxService() {
        service = createService(BugsnaxApi::class.java)
    }

    @Test
    fun getAllBugsnaxTest() = runBlocking {
        enqueueResponse("Bugsnax.json")
        val result =  service.getBugsnax().blockingGet()
        assertNotNull(result.bugsnax)
        assertEquals(99, result.bugsnax?.size)
    }

    @Test
    fun getSingleBugsnakTest() = runBlocking {
        enqueueResponse("Bugsnak.json")
        val result = service.getBugsnakById(1).blockingGet()
        assertNotNull(result)
        assertEquals("Bunger", result.name)
    }
}