package com.marvel.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.characters.Character
import com.marvel.model.comics.Comics
import com.marvel.model.series.Series
import com.marvel.model.stories.Stories
import com.marvel.model.user.DataUser
import com.marvel.usecase.character.*
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    fun getAllCharacterFromAPI(): MutableLiveData<List<Character>?> {
        val characterList = MutableLiveData<List<Character>?>()
        viewModelScope.launch {
            val character = GetAllCharacterUseCase().execute().getOrThrow()
            val data = character?.dataCharacter?.results
            characterList.postValue(data)
        }
        return characterList
    }

    fun getSearchCharacterFromAPI(nameCharacter: String): MutableLiveData<List<Character>?> {
        val characterList = MutableLiveData<List<Character>?>()
        viewModelScope.launch {
            val character = GetCharacterByNameUseCase(nameCharacter).execute().getOrThrow()
            val data = character?.dataCharacter?.results
            characterList.postValue(data)
        }
        return characterList
    }

    fun getCharacterComicsFromAPI(id: String): MutableLiveData<List<Comics>?> {
        val characterList = MutableLiveData<List<Comics>?>()
        viewModelScope.launch {
            val character = GetCharacterComicsUseCase(id).execute().getOrThrow()
            val data = character?.data?.results
            characterList.postValue(data)
        }
        return characterList
    }

    fun getCharacterSeriesFromAPI(id: String): MutableLiveData<List<Series>?> {
        val characterList = MutableLiveData<List<Series>?>()
        viewModelScope.launch {
            val character = GetCharacterSeriesUseCase(id).execute().getOrThrow()
            val data = character?.data?.results
            characterList.postValue(data)
        }
        return characterList
    }

    fun getCharacterStoriesFromAPI(id: String): MutableLiveData<List<Stories>?> {
        val characterList = MutableLiveData<List<Stories>?>()
        viewModelScope.launch {
            val character = GetCharacterStoriesUseCase(id).execute().getOrThrow()
            val data = character?.data?.results
            characterList.postValue(data)
        }
        return characterList
    }
}