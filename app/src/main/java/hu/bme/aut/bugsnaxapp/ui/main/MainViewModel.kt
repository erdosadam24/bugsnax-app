package hu.bme.aut.bugsnaxapp.ui.main

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.bugsnaxapp.model.Bugsnak
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var mainRepository: MainRepository
) : ViewModel() {
    //val bugsnakList = mainRepository.loadBugsnaxData()

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    fun selectTab(@StringRes tab: Int) {
        _selectedTab.value = tab
    }

    fun getBugsnax(): List<Bugsnak> {
       return mainRepository.loadBugsnaxData()
    }

    init {
        mainRepository.loadBugsnaxData()
    }
}