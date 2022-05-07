package hu.bme.aut.bugsnaxapp.persistence

import hu.bme.aut.bugsnaxapp.MockTestUtil.mockBugsnakList
import hu.bme.aut.bugsnaxapp.model.Bugsnak
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class BugsnakDaoTest : LocalDatabase() {
    private lateinit var bugsnakDao: BugsnakDao

    @Before
    fun init() {
        bugsnakDao = db.bugsnakDao()
    }

    @Test
    fun insertAndLoadBugsnakListTest() = runBlocking {
        val mockDataList = mockBugsnakList()
        bugsnakDao.insertBugsnakList(mockDataList)

        val loadFromDB = bugsnakDao.getBugsnakList()
        assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

        val mockData = Bugsnak.mock()
        assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))
    }

    @Test
    fun insertAndCheckLastIdTest() = runBlocking {
        val mockData = Bugsnak.mock()
        bugsnakDao.insertBugsnak(mockData)

        val lastId = bugsnakDao.getLastId()
        assertEquals(0, lastId)
    }

    @Test
    fun insertAndRemoveBugsnakTest() = runBlocking {
        val mockData = Bugsnak.mock()
        bugsnakDao.insertBugsnak(mockData)

        val loadFromDB = bugsnakDao.getBugsnak(0)
        assertThat(loadFromDB.toString(), `is`(mockData.toString()))

        bugsnakDao.removeBugsnak(0)

        val loadFromDBAfterDelete = bugsnakDao.getBugsnak(0)
        assertNull(loadFromDBAfterDelete)
    }
}