package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaListFragment

import com.snowplowanalytics.snowplowdemokotlin.repository.CasesSchema

data class SchemaListState(val schemaList: List<CasesSchema.CaseSchema> = emptyList(), val error: String = "")
