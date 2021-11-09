package com.marvel.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.comics.Comics
import com.marvel.usecase.comics.GetAllComicsUseCase
import com.marvel.usecase.comics.GetComicsByNameUseCase
import kotlinx.coroutines.launch

class ComicsViewModel : ViewModel() {

    fun getAllComicsFromAPI(): MutableLiveData<List<Comics>?> {
        val liveData = MutableLiveData<List<Comics>?>()
        viewModelScope.launch {
            val character = GetAllComicsUseCase().execute().getOrThrow()
            val data = character?.data?.results
            liveData.postValue(data)
        }
        return liveData
    }


    fun getSearchComicsFromAPI(nameCharacter: String): MutableLiveData<List<Comics>?> {
        val liveData = MutableLiveData<List<Comics>?>()
        viewModelScope.launch {
            val character = GetComicsByNameUseCase(nameCharacter).execute().getOrThrow()
            val data = character?.data?.results
            liveData.postValue(data)
        }
        return liveData
    }
}