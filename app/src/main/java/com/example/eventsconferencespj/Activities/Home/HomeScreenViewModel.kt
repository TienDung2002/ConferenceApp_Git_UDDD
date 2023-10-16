package com.example.eventsconferencespj.Activities.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {
    private val conferenceDataList: MutableList<ConfeData> = mutableListOf()

    // Thêm dữ liệu vào conferenceDataList.
    fun addConferenceData(conferenceData: ConfeData) {
        conferenceDataList.add(conferenceData)
    }

    // Lấy danh sách dữ liệu cho adapter.
    fun getConferenceDataList(): List<ConfeData> {
        return conferenceDataList
    }
}