package com.marvel.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.comic.Comic
import com.marvel.model.creator.Creator
import com.marvel.usecase.comic.GetAllComicsUseCase
import com.marvel.usecase.comic.GetComicByNameUseCase
import com.marvel.usecase.comic.GetComicCreatorsUseCase
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    fun getAllComicsFromAPI(): LiveData<List<Comic>?> {
        val liveData = MutableLiveData<List<Comic>?>()
        viewModelScope.launch {
            val character = GetAllComicsUseCase().execute().getOrThrow()
            val data = character?.dataComics?.results
            liveData.postValue(data)
        }
        return liveData
    }

    fun getSearchComicsFromAPI(nameCharacter: String): LiveData<List<Comic>?> {
        val liveData = MutableLiveData<List<Comic>?>()
        viewModelScope.launch {
            val character = GetComicByNameUseCase(nameCharacter).execute().getOrThrow()
            val data = character?.dataComics?.results
            liveData.postValue(data)
        }
        return liveData
    }

    fun getComicsCreatorFromAPI(id: String): LiveData<List<Creator>?> {
        val liveData = MutableLiveData<List<Creator>?>()
        viewModelScope.launch {
            val character = GetComicCreatorsUseCase(id).execute().getOrThrow()
            val data = character?.dataCreators?.results
            liveData.postValue(data)
        }
        return liveData
    }


}