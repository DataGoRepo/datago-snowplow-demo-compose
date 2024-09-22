package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaListFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snowplowanalytics.snowplowdemokotlin.common.Resource
import com.snowplowanalytics.snowplowdemokotlin.useCases.GetSchemaListUseCase
import com.snowplowanalytics.snowplowdemokotlin.repository.CasesSchema
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SchemaListViewModel(
    private val useCase: GetSchemaListUseCase
) : ViewModel() {
    private var _state: MutableStateFlow<SchemaListState> = MutableStateFlow(SchemaListState())
    val state:StateFlow<SchemaListState>
        get() = _state

    fun getSchemaList() {
        useCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SchemaListState(result.data!!)
                }
                is Resource.Error -> {
                    _state.value = SchemaListState()
                }
            }
        }.launchIn(viewModelScope)
    }
}