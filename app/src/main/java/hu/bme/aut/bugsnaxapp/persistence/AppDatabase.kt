package hu.bme.aut.bugsnaxapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.bugsnaxapp.model.Bugsnak

@Database(entities = [Bugsnak::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bugsnakDao(): BugsnakDao
}