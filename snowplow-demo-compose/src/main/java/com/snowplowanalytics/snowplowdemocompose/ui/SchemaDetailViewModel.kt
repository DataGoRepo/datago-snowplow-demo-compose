package com.snowplowanalytics.snowplowdemocompose.ui

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import caseDataMapper
import kotlinx.coroutines.launch
import org.json.JSONObject
import casesList
import com.snowplowanalytics.snowplow.payload.SelfDescribingJson
import com.snowplowanalytics.snowplowdemocompose.data.CasesSchema


class SchemaDetailViewModel : ViewModel() {
    var eventValue: MutableState<SelfDescribingJson?> = mutableStateOf(SelfDescribingJson("some"))
    var caseName: MutableState<String> = mutableStateOf("")
    var caseDescription: MutableState<String> = mutableStateOf("")

//    fun getCaseDescription(caseDescription: String) {
//        viewModelScope.launch {
//            try {
//                description.value = caseDescription
//            } catch (e: Exception) {
//                println("❌ " + e.message.toString())
//            }
//        }
//    }

    fun getCaseDataJson(caseId: Int) {
        viewModelScope.launch {
            try {
                val schema = caseDataMapper[caseId]!!.get("schema")
                val data = caseDataMapper[caseId]!!.get("data")
                eventValue.value = SelfDescribingJson(
                        schema.toString(),
                        data!!
                )
            } catch (e: Exception) {
                println("❌ " + e.message.toString())
            }
        }
    }

    fun getCaseName(caseId: Int) {
        viewModelScope.launch {
            try {
                for (case in casesList.data){
                    if (case.id == caseId){
                        caseName.value = case.case
                    }
                }
            } catch (e: Exception) {
                println("❌ " + e.message.toString())
            }
        }
    }
    fun getCaseDescription(caseId: Int) {
        viewModelScope.launch {
            try {
                for (case in casesList.data){
                    if (case.id == caseId){
                        caseDescription.value = case.description
                    }
                }
            } catch (e: Exception) {
                println("❌ " + e.message.toString())
            }
        }
    }
}
