package com.snowplowanalytics.snowplowdemokotlin.data

import com.snowplowanalytics.snowplowdemokotlin.repository.CasesSchema

class CasesSchemaDataSource {
    private val casesList = CasesSchema(
        mutableListOf(
            CasesSchema.CaseSchema(
                1,
                "Send Screen View",
                "Example how sent screenView event",
                ""
            ),
            CasesSchema.CaseSchema(
                2,
                "Send event event for GA UA Structure",
                "Example of event for GA UA Structure",
                ""
            ),
            CasesSchema.CaseSchema(
                3,
                "Send event event for GA4 Structure",
                "Example of event for GA UA Structure",
                ""
            ),
        )
    )
    fun getData(): CasesSchema {
        return casesList
    }
}