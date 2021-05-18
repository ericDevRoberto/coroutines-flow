package com.example.kotlinflow

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class WordsRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @WorkerThread
    suspend fun insert(word:Word){
        wordDao.insert(word)
    }
}