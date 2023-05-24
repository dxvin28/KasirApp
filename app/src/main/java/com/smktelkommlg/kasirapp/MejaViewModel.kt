package com.smktelkommlg.kasirapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers

class MejaViewModel (application: Application): AndroidViewModel(application) {
    val getTable: LiveData<List<Meja>>
    val repository : KasirRepo

    init {
        val dao = KasirDb.getDatabase(application).getDaoKsr()
        repository = KasirRepo(dao)
        getTable = repository.table
    }

    fun insertTable(meja: Meja) = viewModelScope.launch(Dispatchers.IO){
        repository.insertTable(meja)
    }

    fun deleteTable(meja: Meja) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteTable(meja)
    }

    fun updateTable(meja: Meja) = viewModelScope.launch(Dispatchers.IO){
        repository.updateTable(meja)
    }



}