package com.snowplowanalytics.snowplowdemocompose.data

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.snowplowanalytics.snowplow.Snowplow
import com.snowplowanalytics.snowplow.configuration.EmitterConfiguration
import com.snowplowanalytics.snowplow.configuration.GlobalContextsConfiguration
import com.snowplowanalytics.snowplow.configuration.NetworkConfiguration
import com.snowplowanalytics.snowplow.configuration.SessionConfiguration
import com.snowplowanalytics.snowplow.configuration.SubjectConfiguration
import com.snowplowanalytics.snowplow.configuration.TrackerConfiguration
import com.snowplowanalytics.snowplow.controller.TrackerController
import com.snowplowanalytics.snowplow.emitter.BufferOption
import com.snowplowanalytics.snowplow.event.ScreenView
import com.snowplowanalytics.snowplow.event.SelfDescribing
import com.snowplowanalytics.snowplow.globalcontexts.GlobalContext
import com.snowplowanalytics.snowplow.network.HttpMethod
import com.snowplowanalytics.snowplow.payload.SelfDescribingJson
import com.snowplowanalytics.snowplow.tracker.DevicePlatform
import com.snowplowanalytics.snowplow.tracker.LogLevel
import com.snowplowanalytics.snowplow.util.TimeMeasure
import java.util.concurrent.TimeUnit
import kotlin.random.Random

object Tracking {
    @Composable
    fun setup(namespace: String) : TrackerController {
        // Replace this collector endpoint with your own
        val networkConfig = NetworkConfiguration("https://test.testing.stream.datago.ru/collector", HttpMethod.POST)

        val trackerConfig = TrackerConfiguration("com.datago.datagoSnowplowAndroidComposeExample")
                .logLevel(LogLevel.DEBUG)
                .base64encoding(false)
                .devicePlatform(DevicePlatform.Mobile)
                .deepLinkContext(true)
                .applicationContext(true)
                .platformContext(true)
                .geoLocationContext(true)
                .screenContext(true)
                .screenViewAutotracking(true)
                .lifecycleAutotracking(true)
                .installAutotracking(true)
                .screenContext(true)
                .userAnonymisation(false)
        val emitterConfig = EmitterConfiguration()
                .bufferOption(BufferOption.Single)
                .serverAnonymisation(false)
                .byteLimitPost(100000)
                .retryFailedRequests(false)

        val sessionConfig = SessionConfiguration(
                TimeMeasure(30, TimeUnit.MINUTES),
                TimeMeasure(30, TimeUnit.MINUTES)
        )

        val subjectConfig = SubjectConfiguration()
                .domainUserId("%UserId%")

        val userContext = GlobalContext(
                mutableListOf(
                        SelfDescribingJson(
                                "iglu:ru.datago/user_context/jsonschema/1-0-0",
                                hashMapOf(
                                        "userId" to "%userId%",
                                        "userEmail" to "%hashUserEmail%",
                                        "userPhone" to "%hashPhone%",
                                        "userDataGoId" to ""
                                )
                        )
                )
        )

        // Если используете схему данных GA4 добавьте этот контекст
        val ga4UserParamsContext = GlobalContext(
                mutableListOf(
                        SelfDescribingJson(
                                "iglu:ru.datago/ga4_user_params_context/jsonschema/1-0-0",
                                hashMapOf(
                                        "%userParam1%" to "%userParamValue1%",
                                        //"%userParam2%" to "%userParamValue2%",
                                        //"%userParam3%" to "%userParamValue3%",
                                        // ...
                                        //"%userParamN%" to "%userParamValueN%",
                                        // кол-во параметров ограничено размером отправляемых данных в настройках трекера
                                )
                        )
                )
        )

        // Если используете схему данных GA UA добавьте этот контекст
        val staticCustomDimensionContext = GlobalContext(
                mutableListOf(
                        SelfDescribingJson(
                                "iglu:ru.datago/custom_dimension/jsonschema/1-0-0",
                                hashMapOf(
                                        "customDimension1" to "%Value1%",
                                        // "customDimension2" to "%Value2%",
                                        // "customDimension3" to "%Value3%",
                                        // ....
                                        // "customDimensionN" to "%ValueN%",
                                        // кол-во параметров ограничено размером отправляемых данных в настройках трекера

                                )
                        )
                )
        )

        // Если используете схему данных GA UA добавьте этот контекст
        val staticCustomMetricContext = GlobalContext(
                mutableListOf(
                        SelfDescribingJson(
                                "iglu:ru.datago/custom_metric/jsonschema/1-0-0",
                                hashMapOf(
                                        "customMetric1" to 1,
                                        // "customMetric2" to 2,
                                        // "customMetric3" to 3,
                                        // ....
                                        // "customMetricN" to 9000000000,
                                        // кол-во параметров ограничено размером отправляемых данных в настройках трекера

                                )
                        )
                )
        )

        // Если используете схему данных GA UA добавьте этот контекст
        val staticCustomGroupContext = GlobalContext(
                mutableListOf(
                        SelfDescribingJson(
                                "iglu:ru.datago/custom_group/jsonschema/1-0-0",
                                hashMapOf(
                                        "customGroup1" to "%Value1%",
                                        // "customGroup2" to "%Value2%",
                                        // "customGroup3" to "%Value3%",
                                        // ....
                                        // "customGroupN" to "%ValueN%",
                                        // кол-во параметров ограничено размером отправляемых данных в настройках трекера
                                )
                        )
                )
        )

        val globalContext = GlobalContextsConfiguration(
                mutableMapOf(
                        "userContext" to userContext,
                        "ga4UserParamsContext" to ga4UserParamsContext, // для схемы GA4
                        "staticCustomDimensionContext" to staticCustomDimensionContext, // для схемы GA UA
                        "staticCustomMetricContext" to staticCustomMetricContext, // для схемы GA UA
                        "staticCustomGroupContext" to staticCustomGroupContext, // для схемы GA UA
                )
        )

        return Snowplow.createTracker(
                LocalContext.current,
                namespace,
                networkConfig,
                trackerConfig,
                emitterConfig,
                sessionConfig,
                subjectConfig,
                globalContext
        )
    }

    @Composable
    fun AutoTrackScreenView(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            Snowplow.defaultTracker?.track(ScreenView(destination.route ?: "null"))
        }
    }

    @Composable
    fun ManuallyTrackScreenView(screenName: String,
                                entities: List<SelfDescribingJson>? = null,
    ) {
        LaunchedEffect(Unit, block = {
            val event = ScreenView(screenName).entities(entities)
            Snowplow.defaultTracker?.track(event)
        })
    }
    fun sendEvent(data: SelfDescribingJson) {
        val event = SelfDescribing(data)
        Snowplow.defaultTracker?.track(event)
    }

    fun updateGlobalContext(globalContextTag: String, context: GlobalContext){
        Snowplow.defaultTracker?.globalContexts?.remove(globalContextTag) // Сначала удаляем контекст по тегу globalContextTag: String
        Snowplow.defaultTracker?.globalContexts?.add(globalContextTag, context) // Добавляем измененный контекст (context: GlobalContext) по тегу (globalContextTag: String)


    }
    fun updateUserContext(): GlobalContext{
        val data = listOf(
                SelfDescribingJson(
                        "iglu:ru.datago/user_context/jsonschema/1-0-0",
                        mapOf(
                                "userId" to Random.nextInt(100000, 999999).toString(),
                                "userEmail" to Random.nextInt(10000000, 999999999).toString(),
                                "userPhone" to Random.nextInt(10000000, 999999999).toString(),
                                "userDataGoId" to Random.nextInt(10000000, 999999999).toString(),
                                "NewValue" to Random.nextInt(10000000, 999999999).toString()
                        )
                )
        )
        return GlobalContext(data)

    }
}
