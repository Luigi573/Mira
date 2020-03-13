package com.luigi573.mira.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luigi573.mira.data.Result
import com.luigi573.mira.data.Stat
import com.luigi573.mira.data.source.StatDataRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class StatisticsViewModel @Inject constructor(
        private val repository: StatDataRepository)
    : ViewModel()
{
    private val _stat = MutableLiveData<Stat>()
    val stat : LiveData<Stat> = _stat

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess : LiveData<Boolean> = _isSuccess

    fun start() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            repository.getStat().let {
                _isLoading.postValue(false)
                when(it){
                    is Result.Success -> {
                        _stat.postValue(it.data)
                        _isSuccess.postValue(true)
                    }
                    is Result.Error -> _isSuccess.postValue(false)
                }
            }
        }
    }
}