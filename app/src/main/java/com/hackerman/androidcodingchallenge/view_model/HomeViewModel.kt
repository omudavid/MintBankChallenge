package com.hackerman.androidcodingchallenge.view_model

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.hackerman.androidcodingchallenge.repository.Repository
import com.hackerman.androidcodingchallenge.repository.model.CardDetail
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class HomeViewModel@ViewModelInject constructor
    (var repository: Repository, @Assisted private val savedStateHandle: SavedStateHandle):ViewModel() {


   suspend fun getCardDetails(number:String):CardDetail? {
        return repository.getCardDetails(number)

        }

}