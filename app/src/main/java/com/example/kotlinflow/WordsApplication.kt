package com.example.kotlinflow

import android.app.Application

class WordsApplication: Application() {

    val database by lazy { WordRoomDatabase.getDatabase(this) }
    val repository by lazy { WordsRepository(database.wordDao()) }
}