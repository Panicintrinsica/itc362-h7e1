package com.corbin.msu.criminalintent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.corbin.msu.criminalintent.Crime
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    fun getCrimes(): Flow<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    fun getCrime(id: UUID): Flow<Crime?>

    @Insert
    abstract fun addCrime(crime: Crime)

    @Query("DELETE FROM crime")
    suspend fun clearAllCrimes();
}
