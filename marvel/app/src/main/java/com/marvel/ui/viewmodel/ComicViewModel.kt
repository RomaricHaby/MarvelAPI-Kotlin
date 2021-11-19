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

class ComicViewModel : ViewModel() {

    fun getAllComicsFromAPI(): LiveData<List<Comic>?> {
        val liveData = MutableLiveData<List<Comic>?>()
        viewModelScope.launch {
            val character = GetAllComicsUseCase().execute().getOrThrow()
            val data = character?.dataComics?.results
            liveData.postValue(data)
        }
        return liveData
    }

    fun getSearchComicFromAPI(nameComic: String): LiveData<List<Comic>?> {
        val liveData = MutableLiveData<List<Comic>?>()
        viewModelScope.launch {
            val character = GetComicByNameUseCase(nameComic).execute().getOrThrow()
            val data = character?.dataComics?.results
            liveData.postValue(data)
        }
        return liveData
    }

    fun getComicCreatorsFromAPI(id: String): LiveData<List<Creator>?> {
        val liveData = MutableLiveData<List<Creator>?>()
        viewModelScope.launch {
            val character = GetComicCreatorsUseCase(id).execute().getOrThrow()
            val data = character?.dataCreators?.results
            liveData.postValue(data)
        }
        return liveData
    }
}