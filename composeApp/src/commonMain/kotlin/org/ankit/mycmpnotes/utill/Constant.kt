package org.ankit.mycmpnotes.utill

import org.ankit.mycmpnotes.data.Note

object Constant {
    fun dummyNotesData(): List<Note> {
        return listOf(
            Note(
                id = 1,
                title = "Groceries",
                content = "Buy milk, eggs, bread, and apples",
                colorHex = 0xFFFFF9C4,
                isPinned = true
            ),
            Note(
                id = 2,
                title = "Workout Plan",
                content = "Morning jog at 6 AM, strength training at 7 PM",
                colorHex = 0xFFBBDEFB
            ),
            Note(
                id = 3,
                title = "Important Task",
                content = "Prepare project presentation for Monday",
                colorHex = 0xFFFFCDD2,
                isArchived = true
            ),
            Note(
                id = 4,
                title = "Ideas",
                content = "Build a Note app with color tags and pin support",
                colorHex = 0xFFFFF59D
            ),
            Note(
                id = 5,
                title = "Birthday Gift",
                content = "Order smart watch online for Rahul",
                colorHex = 0xFFE1BEE7
            ),
            Note(
                id = 6,
                title = "Books to Read",
                content = "Clean Code, Atomic Habits, Kotlin in Action",
                colorHex = 0xFFC8E6C9
            ),
            Note(
                id = 7,
                title = "Coding Goals",
                content = "Finish Room DB integration and Compose UI list",
                colorHex = 0xFFD7CCC8,
                isPinned = true
            ),
            Note(
                id = 8,
                title = "UI Ideas",
                content = "Add search, pin, archive, dark mode",
                colorHex = 0xFFB3E5FC
            ),
            Note(
                id = 9,
                title = "Tests",
                content = "Write viewmodel unit tests for Notes module",
                colorHex = 0xFFFFE082
            ),
            Note(
                id = 10,
                title = "Weekend Trip",
                content = "Visit Lonavala, book cab, pack snacks",
                colorHex = 0xFFF0F4C3,
                isArchived = true
            ),
            Note(
                id = 11,
                title = "Budget",
                content = "Track monthly expenses: food, rent, travel",
                colorHex = 0xFFD1C4E9
            ),
            Note(
                id = 12,
                title = "Recipe",
                content = "Pasta: tomatoes, garlic, basil, olive oil",
                colorHex = 0xFFFFE0B2
            ),
            Note(
                id = 13,
                title = "Office Notes",
                content = "Next sprint starts on Monday, refine backlog",
                colorHex = 0xFFCFD8DC
            ),
            Note(
                id = 14,
                title = "Meeting Notes",
                content = "Discuss compose lazy list optimization",
                colorHex = 0xFFDCEDC8
            ),
            Note(
                id = 15,
                title = "Shopping Cart",
                content = "New laptop bag, headphones, HDMI cable",
                colorHex = 0xFFEF9A9A
            ),
            Note(
                id = 16,
                title = "Daily Planner",
                content = "7 AM run, 10 AM coding, 6 PM walk",
                colorHex = 0xFFB2DFDB,
                isPinned = true
            ),
            Note(
                id = 17,
                title = "Inspiration",
                content = "‘Simplicity is the soul of efficiency’",
                colorHex = 0xFFFFFFFF
            ),
            Note(
                id = 18,
                title = "Study List",
                content = "Coroutines, Flow, StateFlow, WorkManager",
                colorHex = 0xFFE6EE9C
            ),
            Note(
                id = 19,
                title = "Travel Packing",
                content = "Charger, documents, socks, toothbrush",
                colorHex = 0xFFF8BBD0
            ),
            Note(
                id = 20,
                title = "Tax Work",
                content = "Upload receipts and finalize financial year",
                colorHex = 0xFF80CBC4,
                isArchived = true
            )
        )
    }
}