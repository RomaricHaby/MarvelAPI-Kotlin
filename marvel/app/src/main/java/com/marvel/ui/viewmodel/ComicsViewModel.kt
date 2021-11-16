package com.marvel.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.comics.Comics
import com.marvel.model.creators.Creator
import com.marvel.usecase.comics.GetAllComicsUseCase
import com.marvel.usecase.comics.GetComicsByNameUseCase
import com.marvel.usecase.comics.GetComicsCreatorsUseCase
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    fun getAllComicsFromAPI(): LiveData<List<Comics>?> {
        val liveData = MutableLiveData<List<Comics>?>()
        viewModelScope.launch {
            val character = GetAllComicsUseCase().execute().getOrThrow()
            val data = character?.data?.results
            liveData.postValue(data)
        }
        return liveData
    }

    fun getSearchComicsFromAPI(nameCharacter: String): LiveData<List<Comics>?> {
        val liveData = MutableLiveData<List<Comics>?>()
        viewModelScope.launch {
            val character = GetComicsByNameUseCase(nameCharacter).execute().getOrThrow()
            val data = character?.data?.results
            liveData.postValue(data)
        }
        return liveData
    }

    fun getComicsCreatorFromAPI(id: String): LiveData<List<Creator>?> {
        val liveData = MutableLiveData<List<Creator>?>()
        viewModelScope.launch {
            val character = GetComicsCreatorsUseCase(id).execute().getOrThrow()
            val data = character?.data?.results
            liveData.postValue(data)
        }
        return liveData
    }


}