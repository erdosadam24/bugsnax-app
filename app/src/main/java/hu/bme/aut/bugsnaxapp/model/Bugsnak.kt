package hu.bme.aut.bugsnaxapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class Bugsnak(
    @PrimaryKey val id: Long,
    val name: String,
    val location: String,
    val userAdded: Boolean
) {
    companion object {
        fun mock() = Bugsnak(
            id = 0,
            name = "My Bugsnak",
            location = "My Home",
            userAdded = false
        )
    }
}