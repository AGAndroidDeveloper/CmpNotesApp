package org.ankit.mycmpnotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@Entity(tableName = "notes")
data class Note @OptIn(ExperimentalTime::class) constructor(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String,
    val colorHex: Long, // Store color as a specific Hex Long (e.g., 0xFFFFF9C4)
    val isPinned: Boolean = false,
    val isArchived: Boolean = false,
    val createdAt: Long = Clock.System.now().toEpochMilliseconds()
)