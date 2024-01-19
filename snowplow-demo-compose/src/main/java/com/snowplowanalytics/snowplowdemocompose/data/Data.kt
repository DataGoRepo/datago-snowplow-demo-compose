import com.snowplowanalytics.snowplow.payload.SelfDescribingJson
import com.snowplowanalytics.snowplowdemocompose.data.CaseDataJsonMap
import com.snowplowanalytics.snowplowdemocompose.data.CasesSchema

public var caseDataMapper = hashMapOf(
        1 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "event" to "ScreenView",// Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "screenName" to "%screenNameValue%",//Название экрана: String: Обязательный параметр
                        "screenPath" to "%screenPathValue%",//URI экрана: String: Обязательный параметр

                        // В eventContext любые дополнительные параметры просмотра экрана
                        // Все значения должны быть типа String
                        // Кол-во ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),
                )
        ),
        2 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры просмотра экрана
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),
                )
        ),
        3 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр

                        // В eventContext любые дополнительные параметры просмотра экрана
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                )
        )
)

public var casesList = CasesSchema(
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