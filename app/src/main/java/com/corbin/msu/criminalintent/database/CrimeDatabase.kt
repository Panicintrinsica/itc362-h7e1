package com.corbin.msu.criminalintent.database

import androidx.room.Database
import androidx.room.Insert
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.corbin.msu.criminalintent.Crime

@Database(entities = [Crime::class], version = 1)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase: RoomDatabase() {

    abstract fun crimeDao(): CrimeDao

}