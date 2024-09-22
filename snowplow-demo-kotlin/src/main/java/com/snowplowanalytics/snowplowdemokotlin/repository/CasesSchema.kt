package com.snowplowanalytics.snowplowdemokotlin.repository

data class CasesSchema(
    val data: List<CaseSchema>
){
    data class CaseSchema(
        val id: Int = 0,
        val case: String = "",
        val description: String = "",
        val dataPath: String = ""
    )
}