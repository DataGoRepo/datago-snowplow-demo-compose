package com.snowplowanalytics.snowplowdemocompose.data

import com.snowplowanalytics.snowplow.payload.SelfDescribingJson

data class SchemaDescription(
        val description: String?,
)

data class CaseDataJsonMap(
        val id: Int,
        val data: SelfDescribingJson
)


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

