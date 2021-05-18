package com.example.kotlinflow

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.coroutineContext

class WordsApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordRoomDatabase.getDatabase(context = this, scope = applicationScope) }
    val repository by lazy { WordsRepository(database.wordDao()) }
}