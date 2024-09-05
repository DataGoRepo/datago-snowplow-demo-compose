package com.snowplowanalytics.snowplowdemokotlin.useCases

import com.snowplowanalytics.snowplowdemokotlin.common.Resource
import com.snowplowanalytics.snowplowdemokotlin.repository.CasesSchema
import com.snowplowanalytics.snowplowdemokotlin.repository.SchemaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSchemaListUseCase(
    private val schemaRepository: SchemaRepository
) {
    operator fun invoke(): Flow<Resource<List<CasesSchema.CaseSchema>>> = flow {
        try {
            val casesPartsList: MutableList<CasesSchema.CaseSchema> = mutableListOf()
            val cases = schemaRepository.getSchemaList()
            for (case in cases.data) {
                casesPartsList.add(
                    CasesSchema.CaseSchema(
                        id = case.id,
                        case = case.case,
                        description = case.description,
                        dataPath = case.dataPath
                    )
                )
            }
            emit(Resource.Success(casesPartsList))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error while loading Schema cases"))
        }
    }
}