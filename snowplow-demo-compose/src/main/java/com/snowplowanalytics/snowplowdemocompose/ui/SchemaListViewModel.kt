package com.snowplowanalytics.snowplowdemocompose.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import casesList
import com.snowplowanalytics.snowplowdemocompose.data.CasesSchema
import kotlinx.coroutines.launch

class SchemaListViewModel : ViewModel() {
    var errorMessage: String by mutableStateOf("")

    private val _casesPartsList = mutableStateListOf<CasesSchema.CaseSchema>()
    val casesPartsList: List<CasesSchema.CaseSchema>
        get() = _casesPartsList

    fun getSchemaList() {
        viewModelScope.launch {
            try {
                val cases = casesList
                if (_casesPartsList.isEmpty()){
                    for (case in cases.data) {
                        _casesPartsList.add(CasesSchema.CaseSchema(
                                id = case.id,
                                case = case.case,
                                description = case.description,
                                dataPath = case.dataPath
                        ))
                    }
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }

    }

}
