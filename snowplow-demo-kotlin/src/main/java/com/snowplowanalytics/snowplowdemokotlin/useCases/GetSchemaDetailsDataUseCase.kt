package com.snowplowanalytics.snowplowdemokotlin.useCases

import com.snowplowanalytics.snowplow.payload.SelfDescribingJson
import com.snowplowanalytics.snowplowdemokotlin.common.Resource
import com.snowplowanalytics.snowplowdemokotlin.presentation.schemaDetailFragment.SchemaDetailState
import com.snowplowanalytics.snowplowdemokotlin.repository.SchemaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSchemaDetailsDataUseCase(private val schemaRepository: SchemaRepository) {
    operator fun invoke(caseId: Int): Flow<Resource<SchemaDetailState>> = flow {
        try {
            val case = schemaRepository.getSchemaById(caseId)
            val mappedData = schemaRepository.getMappedData(caseId)
            val schema = mappedData["schema"]
            val data = mappedData["data"]
            if (case != null) {
                emit(
                    Resource.Success(
                        SchemaDetailState(
                            jsonScheme = SelfDescribingJson(
                                schema.toString(),
                                data!!
                            ), caseDescription = case.description, caseName = case.case
                        )
                    )
                )
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error while loading Schema cases"))
        }
    }
}