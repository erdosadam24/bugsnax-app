package hu.bme.aut.bugsnaxapp.ui.add

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.bugsnaxapp.model.Bugsnak
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val addRepository: AddRepository
) : ViewModel() {

    fun createBugsnak(name: String, location: String): Bugsnak {
        val newBugsnak = Bugsnak(addRepository.getNextId(), name, location, true)
        addRepository.addNewBugsnak(newBugsnak)
        return newBugsnak
    }
}