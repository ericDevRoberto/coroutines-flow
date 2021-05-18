package com.example.kotlinflow

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WordViewModel(private val repository: WordsRepository) : ViewModel() {

    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

@Suppress("UNCHECKED_CAST")
class WordViewModelFactory(private val repository: WordsRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WordViewModel::class.java)){
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}