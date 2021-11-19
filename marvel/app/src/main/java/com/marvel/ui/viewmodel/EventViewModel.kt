package com.marvel.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.event.Event
import com.marvel.usecase.event.GetAllEventsUseCase
import com.marvel.usecase.event.GetEventByNameUseCase
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {

    fun getAllEventFromAPI(): LiveData<List<Event>?> {
        val liveData = MutableLiveData<List<Event>?>()
        viewModelScope.launch {
            val event = GetAllEventsUseCase().execute().getOrThrow()
            val data = event?.dataEvents?.results
            liveData.postValue(data)
        }
        return liveData
    }


    fun getSearchEventFromAPI(nameEvent: String): LiveData<List<Event>?> {
        val liveData = MutableLiveData<List<Event>?>()
        viewModelScope.launch {
            val event = GetEventByNameUseCase(nameEvent).execute().getOrThrow()
            val data = event?.dataEvents?.results
            liveData.postValue(data)
        }
        return liveData
    }
}