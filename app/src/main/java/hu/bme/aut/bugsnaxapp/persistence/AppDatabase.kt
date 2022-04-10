package hu.bme.aut.bugsnaxapp.persistence

// TODO: Annotations
abstract class AppDatabase {
    abstract fun bugsnakDao(): BugsnakDao
}