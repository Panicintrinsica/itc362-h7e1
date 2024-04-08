package com.corbin.msu.criminalintent

import androidx.lifecycle.ViewModel
import java.util.Calendar
import java.util.UUID
import java.util.concurrent.ThreadLocalRandom

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        val calendar = Calendar.getInstance()

        for (i in 0 until 100) {
            val randomHours = ThreadLocalRandom.current().nextInt(1, 24)
            val randomMinutes = ThreadLocalRandom.current().nextInt(1, 60)

            calendar.add(Calendar.HOUR, randomHours)
            calendar.add(Calendar.MINUTE, randomMinutes)

            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = calendar.time,
                isSolved = i % 2 == 0,
                requiresPolice = i % 3 == 0
            )

            crimes += crime

            // Prepare for the next iteration
            calendar.add(Calendar.HOUR, randomHours)
            calendar.add(Calendar.MINUTE, randomMinutes)
        }
    }
}