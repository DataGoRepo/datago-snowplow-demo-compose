package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaDetailFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snowplowanalytics.snowplow.payload.SelfDescribingJson
import com.snowplowanalytics.snowplowdemokotlin.common.Resource
import com.snowplowanalytics.snowplowdemokotlin.useCases.GetSchemaDetailsDataUseCase
import com.snowplowanalytics.snowplowdemokotlin.tracking.Tracking
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SchemaDetailViewModel(
    private val useCase: GetSchemaDetailsDataUseCase
) : ViewModel() {
    private var _state: MutableStateFlow<SchemaDetailState> = MutableStateFlow(SchemaDetailState())
    val state: StateFlow<SchemaDetailState>
        get() = _state

    fun getCaseData(caseId: Int) {
        useCase(caseId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = result.data!!
                }

                is Resource.Error -> {
                    _state.value = result.data!!
                }
            }
        }.launchIn(viewModelScope)
    }

    fun sendHit(caseId: Int, updateGlobalContext: Boolean = false) {
        if(updateGlobalContext){
            val tag = "userContext"
            val userContext = Tracking.updateUserContext()
            Tracking.updateGlobalContext(tag,userContext)
        }

        if (caseId == 1){
            Tracking.sendEvent(state.value.jsonScheme)
        }
        if (caseId == 2){
            Tracking.sendEvent(state.value.jsonScheme)
        }
    }

    fun manuallyTrackScreenView() {
        val entity = SelfDescribingJson(
            "iglu:com.snowplowanalytics.iglu/anything-a/jsonschema/1-0-0",
            hashMapOf("name" to _state.value.caseName, "description" to _state.value.caseDescription)
        )
        Tracking.ManuallyTrackScreenView("case_details", entities = listOf(entity))
    }
}