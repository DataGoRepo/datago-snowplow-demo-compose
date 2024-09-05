package com.snowplowanalytics.snowplowdemokotlin.repository

import com.snowplowanalytics.snowplowdemokotlin.data.CasesSchemaDataSource
import com.snowplowanalytics.snowplowdemokotlin.data.MappedDataSource
import java.io.Serializable

class SchemaRepository(
    private val casesSchemaDataSource: CasesSchemaDataSource,
    private val mappedDataSource: MappedDataSource
) {
    fun getSchemaList(): CasesSchema {
        return casesSchemaDataSource.getData()
    }

    fun getMappedData(caseId: Int): HashMap<String, Serializable>{
        return mappedDataSource.getData(caseId)
    }

    fun getSchemaById(caseId: Int): CasesSchema.CaseSchema? {
        var schemaCase:CasesSchema.CaseSchema? = null
        for(case in getSchemaList().data){
            if(case.id == caseId) {
                schemaCase = case
            }
        }
        return schemaCase
    }
}