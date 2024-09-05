package com.snowplowanalytics.snowplowdemokotlin.data

import com.snowplowanalytics.snowplow.payload.SelfDescribingJson

data class SchemaDescription(
        val description: String?,
)

data class CaseDataJsonMap(
        val id: Int,
        val data: SelfDescribingJson
)

