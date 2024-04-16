package com.example.novaviagematualizado.viewmodel

import com.example.novaviagematualizado.model.Viagem
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
class ViagemViewModel : ViewModel (){
    private val _uiState = MutableStateFlow(Viagem())
    val uiState: StateFlow<Viagem> = _uiState.asStateFlow()
    fun updatedestino (newdestino : String){
        _uiState.update{
            it.copy(destino = newdestino)
        }
    }
    fun updateorcamento (neworcamento : Float){
        _uiState.update{
            it.copy(orcamento = neworcamento)
        }
    }
}