package com.snowplowanalytics.snowplowdemokotlin.data

import java.io.Serializable

class MappedDataSource {
    private val caseDataMapper = hashMapOf(
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

    fun getData(caseId: Int): HashMap<String, Serializable> {
        return caseDataMapper.getValue(caseId)
    }
}