package hu.bme.aut.bugsnaxapp.ui.add

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val addRepository: AddRepository
) : ViewModel() {
    // TODO: ViewModel Logic
}