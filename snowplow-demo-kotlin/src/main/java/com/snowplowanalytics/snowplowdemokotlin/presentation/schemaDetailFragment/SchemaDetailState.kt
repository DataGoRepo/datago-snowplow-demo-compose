package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaDetailFragment

import com.snowplowanalytics.snowplow.payload.SelfDescribingJson

data class SchemaDetailState(
    val caseName: String = "",
    val caseDescription: String = "",
    val jsonScheme: SelfDescribingJson = SelfDescribingJson("some")
)