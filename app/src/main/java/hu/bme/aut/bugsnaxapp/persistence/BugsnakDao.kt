package hu.bme.aut.bugsnaxapp.persistence

import androidx.room.*
import hu.bme.aut.bugsnaxapp.model.Bugsnak

@Dao
interface BugsnakDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBugsnak(bugsnak: Bugsnak)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBugsnakList(bugsnax: List<Bugsnak>)

    @Query("SELECT * FROM Bugsnak WHERE id = :id_")
    fun getBugsnak(id_: Long): Bugsnak?

    @Query("SELECT * FROM Bugsnak")
    fun getBugsnakList(): List<Bugsnak>

    @Query("DELETE FROM Bugsnak WHERE id = :id_")
    fun removeBugsnak(id_: Long)
}