package com.corbin.msu.criminalintent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inject Test Data on Each Launch
        lifecycleScope.launch {
            val crimeRepository = CrimeRepository.get()

            // Clear all crimes
            crimeRepository.clearAllCrimes()

            // Inject random crimes
            val crimes = listOf(
                Crime(
                    id = UUID.randomUUID(),
                    title = "unprofessional dishes in storage room",
                    isSolved = Random.nextBoolean(),
                    date = Date(1639615004107),
                    requiresPolice = Random.nextBoolean(),
                ),
                Crime(
                    id = UUID.randomUUID(),
                    title = "toxic lunch in copy room",
                    isSolved = Random.nextBoolean(),
                    date = Date(1639615004107),
                    requiresPolice = Random.nextBoolean(),
                ),
                Crime(
                    id = UUID.randomUUID(),
                    title = "messy sink at reception desk",
                    isSolved = Random.nextBoolean(),
                    date = Date(1639615004107),
                    requiresPolice = Random.nextBoolean(),
                ),
                Crime(
                    id = UUID.randomUUID(),
                    title = "unproductive sink in copy room",
                    isSolved = Random.nextBoolean(),
                    date = Date(1639615004107),
                    requiresPolice = Random.nextBoolean(),
                ),
                Crime(
                    id = UUID.randomUUID(),
                    title = "dirty sink at reception desk",
                    isSolved = Random.nextBoolean(),
                    date = Date(1639615004107),
                    requiresPolice = Random.nextBoolean(),
                )
            )
            crimes.forEach { crime ->
                crimeRepository.addCrime(crime)
            }
        }
    }
}