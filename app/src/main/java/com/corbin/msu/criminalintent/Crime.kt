package com.corbin.msu.criminalintent

import android.text.format.DateFormat
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Crime(

    @PrimaryKey val id: UUID,
    var title: String,
    val date: Date,
    val isSolved: Boolean,
    val requiresPolice: Boolean,
){
    val formattedDate: String
        get() {
            return DateFormat.format("MMM d, yyyy (hh:mm a)", date).toString()
        }
}