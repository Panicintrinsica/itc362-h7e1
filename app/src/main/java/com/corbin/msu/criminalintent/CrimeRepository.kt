package com.corbin.msu.criminalintent

import android.content.Context
import androidx.room.Room
import com.corbin.msu.criminalintent.database.CrimeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.UUID

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context) {

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE ?:
                throw IllegalStateException("CrimeRepository must be initialized")
        }
    }

    private val database = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    private val crimeDao = database.crimeDao()

    fun getCrimes(): Flow<List<Crime>> = database.crimeDao().getCrimes()

    fun getCrime(id: UUID): Flow<Crime?> = database.crimeDao().getCrime(id)

    suspend fun addCrime(crime: Crime) = withContext(Dispatchers.IO) {
        crimeDao.addCrime(crime)
    }

    suspend fun clearAllCrimes() = withContext(Dispatchers.IO) {
        crimeDao.clearAllCrimes()
    }


}