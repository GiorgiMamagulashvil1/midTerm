package com.example.midtermandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedbackViewModel : ViewModel() {

    private val errorMutableLiveData: MutableLiveData<Int> = MutableLiveData()
    val errorLiveData: LiveData<Int> = errorMutableLiveData

    private val successMutableLiveData:MutableLiveData<Int> = MutableLiveData()
    val successLiveData:LiveData<Int> = successMutableLiveData

    fun checkEmptyField(name: String, lastName: String, text: String) {
        if (name.isBlank() || lastName.isBlank() || text.isBlank()) {
            errorMutableLiveData.postValue(R.string.please_fill_all_fields)
            return
        }
        if (name.length < 3 || lastName.length < 5 || text.length < 10){
            errorMutableLiveData.postValue(R.string.input_is_short)
            return
        }
        successMutableLiveData.postValue(R.string.success)
    }
}