package com.example.itscoronatime.infoActivity.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(
    private val id: Int
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T?>): T {
        return if (modelClass == InfoViewModel::class.java) {
            InfoViewModel(id) as T
        } else {
            throw IllegalArgumentException("Invalid view model type")
        }
    }
}
