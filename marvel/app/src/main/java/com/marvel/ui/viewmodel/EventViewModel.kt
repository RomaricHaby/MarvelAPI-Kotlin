package com.marvel.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.events.Events
import com.marvel.usecase.events.GetAllEventsUseCase
import com.marvel.usecase.events.GetEventByNameUseCase
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {

    fun getAllEventFromAPI(): MutableLiveData<List<Events>?> {
        val liveData = MutableLiveData<List<Events>?>()
        viewModelScope.launch {
            val event = GetAllEventsUseCase().execute().getOrThrow()
            val data = event?.data?.results
            liveData.postValue(data)
        }
        return liveData
    }


    fun getSearchEventFromAPI(nameEvent: String): MutableLiveData<List<Events>?> {
        val liveData = MutableLiveData<List<Events>?>()
        viewModelScope.launch {
            val event = GetEventByNameUseCase(nameEvent).execute().getOrThrow()
            val data = event?.data?.results
            liveData.postValue(data)
        }
        return liveData
    }
}