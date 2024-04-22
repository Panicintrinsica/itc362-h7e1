package com.corbin.msu.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()

    val crimes: Flow<List<Crime>> = crimeRepository.getCrimes()

    init {
        viewModelScope.launch {}
    }
}