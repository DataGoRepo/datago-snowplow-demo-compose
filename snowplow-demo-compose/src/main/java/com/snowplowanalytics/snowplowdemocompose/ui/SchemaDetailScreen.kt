package com.snowplowanalytics.snowplowdemocompose.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import caseDataMapper
import com.snowplowanalytics.snowplow.payload.SelfDescribingJson
import com.snowplowanalytics.snowplowdemocompose.R
import com.snowplowanalytics.snowplowdemocompose.data.CasesSchema
import com.snowplowanalytics.snowplowdemocompose.data.Tracking


@Composable
fun SchemaDetailScreen(
        vm: SchemaDetailViewModel,
        caseId: Int,
        onBackButtonClicked: () -> Unit = {}
) {
    LaunchedEffect(Unit, block = {
        vm.getCaseName(caseId)
        vm.getCaseDescription(caseId)
        vm.getCaseDataJson(caseId)
    })
    val case = CasesSchema.CaseSchema(caseId, vm.caseName.value, vm.caseDescription.value, "")
    val checked = remember { mutableStateOf(false) }

    // ScreenViews, like all event types, can be tracked manually.
    // This code tracks a ScreenView with attached context entity.
    // The entity records information about the specific schema being viewed.
    // To attach entities to ScreenViews tracked automatically via Navigation, use the Global Contexts API.
    val entity = SelfDescribingJson(
            "iglu:com.snowplowanalytics.iglu/anything-a/jsonschema/1-0-0",
            hashMapOf("name" to case.case, "description" to case.description)
    )
    Tracking.ManuallyTrackScreenView("case_details", entities = listOf(entity))
    Scaffold(
            topBar = {
                TopAppBar(
                        title = { Text(case.case) },
                        navigationIcon = {
                            IconButton(onClick = onBackButtonClicked) {
                                Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = stringResource(R.string.back_button)
                                )
                            }
                        }
                )
            }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            Column(modifier = Modifier.padding(all = 12.dp)) {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    DetailsSchemaProperty(title = "Case Name", data = case.case)
                    DetailsSchemaProperty(
                            title = "Description",
                            data = case.description
                    )
                    DetailsSchemaProperty(
                            title = "JSON Schema",
                            data = vm.eventValue.value.toString().replace("\\", "")
                    )
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Checkbox(checked = checked.value, onCheckedChange = { isChecked -> checked.value = isChecked })
                        Text(text = "Update Global Context: ${checked.value}")
                    }
                    Button(
                            onClick = {
                                sendHit(
                                        caseId
                                        , checked.value
                                )
                            }
                    ){
                        Text("Send Event")
                    }
                }
            }
        }
    }
}

fun sendHit(caseId: Int, updateGlobalContext: Boolean = false) {
    val schema: String
    val eventData = caseDataMapper[caseId]!!
    val data = eventData["data"]!!
    schema = eventData["schema"].toString()
    if(updateGlobalContext){
        val tag = "userContext"
        val userContext = Tracking.updateUserContext()
        Tracking.updateGlobalContext(tag,userContext)
    }

    if (caseId == 1){
        Tracking.sendEvent(SelfDescribingJson(schema, data))
    }
    if (caseId == 2){
        Tracking.sendEvent(SelfDescribingJson(schema, data))
    }
}
@Composable
fun DetailsSchemaProperty(title: String, data: String) {
    Text(
            text = title,
            style = MaterialTheme.typography.subtitle1
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
            data,
            style = MaterialTheme.typography.body1,
    )
    Spacer(modifier = Modifier.height(16.dp))
}
