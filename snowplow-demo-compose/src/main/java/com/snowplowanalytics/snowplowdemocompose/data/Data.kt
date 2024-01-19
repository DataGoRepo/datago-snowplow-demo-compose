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

                        // В eventContext любые дополнительные параметры события
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

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                )
        ),
        4 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "currencyCode" to "RUR", // Валюта: String: НЕ обязательный параметр
                                "impressions" to listOf(
                                        hashMapOf(
                                                "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                "list" to "%list%", // Название показанного списка: String: НЕ обязательный параметр
                                                "position" to 1, // Позиция в списке: String: НЕ обязательный параметр
                                        ),
                                        hashMapOf(
                                                "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                "list" to "%list%", // Название показанного списка: String: НЕ обязательный параметр
                                                "position" to 1, // Позиция в списке: String: НЕ обязательный параметр
                                        ),
                                )
                        )
                )
        ),
        5 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "view_item_list", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "item_list_id" to "%item_list_id%", //  ID списка: String: НЕ обязательный параметр
                                "item_list_name" to "%item_list_name%", //  Название списка: String: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        6 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "click" to hashMapOf(
                                        "actionField" to hashMapOf( // Не обязательный параметр
                                                "list" to "%list%",// Название списка: String: НЕ обязательный параметр
                                                "step" to 1, // Шаг в воронке: Int: НЕ обязательный параметр
                                                "option" to "%option%"  // Опции: String: НЕ обязательный параметр
                                        ),
                                        "currencyCode" to "RUR", // Валюта: String: НЕ обязательный параметр
                                        "products" to listOf(
                                                hashMapOf(
                                                        "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                        "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                        "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                        "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                        "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                        "quantity" to 4, // Кол-во продукта: Int: НЕ обязательный параметр
                                                        "position" to 1, // Позиция в списке: Int: НЕ обязательный параметр
                                                        "list" to "%list%", // Название показанного списка: String: НЕ обязательный параметр

                                                        // Кастомные параметры
                                                        // Все значения должны быть типа String
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "dimension1" to "%dimensionValue1%",

                                                        // Кастомные метрики
                                                        // Все значения должны быть типа Float
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "metric1" to 12.4
                                                ),
                                        )
                                ),
                        )
                )
        ),
        7 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "select_item", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "item_list_id" to "%item_list_id%", //  ID списка: String: НЕ обязательный параметр
                                "item_list_name" to "%item_list_name%", //  Название списка: String: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        8 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "detail" to hashMapOf(
                                        "actionField" to hashMapOf( // Не обязательный параметр
                                                "list" to "%list%",// Название списка: String: НЕ обязательный параметр
                                                "step" to 1, // Шаг в воронке: Int: НЕ обязательный параметр
                                                "option" to "%option%"  // Опции: String: НЕ обязательный параметр
                                        ),
                                        "products" to listOf(
                                                hashMapOf(
                                                        "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                        "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                        "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                        "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                        "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                        "quantity" to 4, // Кол-во продукта: Ште: НЕ обязательный параметр
                                                        "position" to 1, // Позиция в списке: Int: НЕ обязательный параметр
                                                        "list" to "%list%", // Название показанного списка: String: НЕ обязательный параметр

                                                        // Кастомные параметры
                                                        // Все значения должны быть типа String
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "dimension1" to "%dimensionValue1%",

                                                        // Кастомные метрики
                                                        // Все значения должны быть типа Float
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "metric1" to 12.4
                                                ),
                                        )
                                ),
                        )
                )
        ),
        9 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "view_item", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "value" to 344.5, // Денежная ценноть события: Float: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        10 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "add" to hashMapOf(
                                        "actionField" to hashMapOf( // Не обязательный параметр
                                                "list" to "%list%",// Название списка: String: НЕ обязательный параметр
                                                "step" to 1, // Шаг в воронке: Int: НЕ обязательный параметр
                                                "option" to "%option%"  // Опции: String: НЕ обязательный параметр
                                        ),
                                        "currencyCode" to "RUR", // Валюта: String: НЕ обязательный параметр
                                        "products" to listOf(
                                                hashMapOf(
                                                        "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                        "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                        "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                        "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                        "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                        "quantity" to 4, // Кол-во продукта: Ште: НЕ обязательный параметр
                                                        "position" to 1, // Позиция в списке: Int: НЕ обязательный параметр
                                                        "list" to "%list%", // Название показанного списка: String: НЕ обязательный параметр

                                                        // Кастомные параметры
                                                        // Все значения должны быть типа String
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "dimension1" to "%dimensionValue1%",

                                                        // Кастомные метрики
                                                        // Все значения должны быть типа Float
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "metric1" to 12.4
                                                ),
                                        )
                                ),
                        )
                )
        ),
        11 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "add_to_cart", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "value" to 344.5, // Денежная ценноть события: Float: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        12 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "remove" to hashMapOf(
                                        "actionField" to hashMapOf( // Не обязательный параметр
                                                "list" to "%list%",// Название списка: String: НЕ обязательный параметр
                                                "step" to 1, // Шаг в воронке: Int: НЕ обязательный параметр
                                                "option" to "%option%"  // Опции: String: НЕ обязательный параметр
                                        ),
                                        "currencyCode" to "RUR", // Валюта: String: НЕ обязательный параметр
                                        "products" to listOf(
                                                hashMapOf(
                                                        "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                        "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                        "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                        "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                        "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                        "quantity" to 4, // Кол-во продукта: Ште: НЕ обязательный параметр
                                                        "position" to 1, // Позиция в списке: Int: НЕ обязательный параметр
                                                        "list" to "%list%", // Название показанного списка: String: НЕ обязательный параметр

                                                        // Кастомные параметры
                                                        // Все значения должны быть типа String
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "dimension1" to "%dimensionValue1%",

                                                        // Кастомные метрики
                                                        // Все значения должны быть типа Float
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "metric1" to 12.4
                                                ),
                                        )
                                ),
                        )
                )
        ),
        13 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "remove_from_cart", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "value" to 344.5, // Денежная ценноть события: Float: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        14 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "checkout" to hashMapOf(
                                        "actionField" to hashMapOf( // Не обязательный параметр
                                                "list" to "%list%",// Название списка: String: НЕ обязательный параметр
                                                "step" to 1, // Шаг в воронке: Int: НЕ обязательный параметр
                                                "option" to "%option%"  // Опции: String: НЕ обязательный параметр
                                        ),
                                        "currencyCode" to "RUR", // Валюта: String: НЕ обязательный параметр
                                        "products" to listOf(
                                                hashMapOf(
                                                        "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                        "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                        "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                        "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                        "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                        "quantity" to 4, // Кол-во продукта: Int: НЕ обязательный параметр
                                                        "position" to 1, // Позиция в списке: Int: НЕ обязательный параметр
                                                        "list" to "%list%", // Название показанного списка: String: НЕ обязательный параметр

                                                        // Кастомные параметры
                                                        // Все значения должны быть типа String
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "dimension1" to "%dimensionValue1%",

                                                        // Кастомные метрики
                                                        // Все значения должны быть типа Float
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "metric1" to 12.4
                                                ),
                                        )
                                ),
                        )
                )
        ),
        15 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "begin_checkout", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "value" to 344.5, // Денежная ценноть события: Float: НЕ обязательный параметр
                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        16 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "purchase" to hashMapOf(
                                        "actionField" to hashMapOf( // Не обязательный параметр
                                                "id" to "%id%", // ID транзакции: String: обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик: String: НЕ обязательный параметр
                                                "revenue" to 150.12,  // Доход от транзакции: Float: НЕ обязательный параметр
                                                "tax" to 20.5, // Сумма налогов: Float: НЕ обязательный параметр
                                                "shipping" to 20.5, // Стоимость доставки: Float: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: обязательный параметр
                                        ),
                                        "currencyCode" to "RUR", // Валюта: String: НЕ обязательный параметр
                                        "products" to listOf(
                                                hashMapOf(
                                                        "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                        "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                        "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                        "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                        "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                        "quantity" to 4, // Кол-во продукта: Int: НЕ обязательный параметр
                                                        "position" to 1, // Позиция в списке: Int: НЕ обязательный параметр
                                                        "list" to "%list%", // Название показанного списка: String: НЕ обязательный параметр

                                                        // Кастомные параметры
                                                        // Все значения должны быть типа String
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "dimension1" to "%dimensionValue1%",

                                                        // Кастомные метрики
                                                        // Все значения должны быть типа Float
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "metric1" to 12.4
                                                ),
                                        )
                                ),
                        )
                )
        ),
        17 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "purchase", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "transaction_id" to "%transaction_id%", // ID транзакции: String: НЕ обязательный параметр
                                "value" to 344.5, // Сумма транзакции: Float: НЕ обязательный параметр
                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                "shipping" to 12.4, // Стоимость доставки: Float: НЕ обязательный параметр
                                "tax" to 12.4, // Налог: Float: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        18 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "refund" to hashMapOf(
                                        "actionField" to hashMapOf( // Не обязательный параметр
                                                "id" to "%id%", // ID транзакции: String: обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик: String: НЕ обязательный параметр
                                                "revenue" to 150.12,  // Доход от транзакции: Float: НЕ обязательный параметр
                                                "tax" to 20.5, // Сумма налогов: Float: НЕ обязательный параметр
                                                "shipping" to 20.5, // Стоимость доставки: Float: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: обязательный параметр
                                        ),
                                        "currencyCode" to "RUR", // Валюта: String: НЕ обязательный параметр
                                        "products" to listOf(
                                                hashMapOf(
                                                        "name" to "%product name%", // название продукта: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id продукта: String: обязательный параметр, если не указан name
                                                        "price" to "%price%", // Цена: String: НЕ обязательный параметр
                                                        "brand" to "%brand%", // Название бренда: String: НЕ обязательный параметр
                                                        "category" to "%category%", // Категрия продукта: String: НЕ обязательный параметр
                                                        "variant" to "%variant%", // Вариант продукта: String: НЕ обязательный параметр
                                                        "quantity" to 4, // Кол-во продукта: Int: НЕ обязательный параметр
                                                        "position" to 1, // Позиция в списке: Int: НЕ обязательный параметр

                                                        // Кастомные параметры
                                                        // Все значения должны быть типа String
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "dimension1" to "%dimensionValue1%",

                                                        // Кастомные метрики
                                                        // Все значения должны быть типа Float
                                                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                                                        "metric1" to 12.4
                                                ),
                                        )
                                ),
                        )
                )
        ),
        19 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "refund", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "transaction_id" to "%transaction_id%", // ID транзакции: String: НЕ обязательный параметр
                                "value" to 344.5, // Сумма транзакции: Float: НЕ обязательный параметр
                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                "shipping" to 12.4, // Стоимость доставки: Float: НЕ обязательный параметр
                                "tax" to 12.4, // Налог: Float: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        20 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "promoView" to hashMapOf(
                                        "promotions" to listOf(
                                                hashMapOf(
                                                        "name" to "%promo name%", // название промо: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id промо: String: обязательный параметр, если не указан name
                                                        "creative" to "%creative%", // Название креатива: String: НЕ обязательный параметр
                                                        "position" to "%position%", // Название позиции: String: НЕ обязательный параметр
                                                ),
                                        )
                                ),
                        )
                )
        ),
        21 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "view_promotion", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "promotion_id" to "%promotion_id%", // ID промо: String: НЕ обязательный параметр
                                "promotion_name" to "%promotion_name%", // Название промо: String: НЕ обязательный параметр
                                "creative_name" to "%creative_name%", // Название креатива: String: НЕ обязательный параметр
                                "creative_slot" to "%creative_slot%", // Название рекламного места: String: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        22 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "UA", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "%eventName%", // Название события: String: Обязательный параметр
                        "eventCategory" to "%eventCategoryValue%", // Категория события: String: Обязательный параметр: по аналогии с GA UA
                        "eventAction" to "%eventActionValue%", // Действие по события: String: Обязательный параметр: по аналогии с GA UA
                        "eventLabel" to "%eventLabelValue%", // Ярлык события: String: НЕ Обязательный параметр: по аналогии с GA UA
                        "eventValue" to "%eventValueValue%", // Ценность события: String: НЕ Обязательный параметр: по аналогии с GA UA

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметрок ограничено настройками трекера на размер запроса
                        "eventContext" to hashMapOf(
                                "eventContext1" to "eventContextValue1",
                                "eventContext2" to "eventContextValue2",
                                "eventContext3" to "eventContextValue3"
                        ),

                        // Блок с информацией по ecommerce в структуре  GA UA
                        "ecommerce" to hashMapOf(
                                "promoClick" to hashMapOf(
                                        "promotions" to listOf(
                                                hashMapOf(
                                                        "name" to "%promo name%", // название промо: String: обязательный параметр, если не указан id
                                                        "id" to "%id%", // id промо: String: обязательный параметр, если не указан name
                                                        "creative" to "%creative%", // Название креатива: String: НЕ обязательный параметр
                                                        "position" to "%position%", // Название позиции: String: НЕ обязательный параметр
                                                ),
                                        )
                                ),
                        )
                )
        ),
        23 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "select_promotion", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "promotion_id" to "%promotion_id%", // ID промо: String: НЕ обязательный параметр
                                "promotion_name" to "%promotion_name%", // Название промо: String: НЕ обязательный параметр
                                "creative_name" to "%creative_name%", // Название креатива: String: НЕ обязательный параметр
                                "creative_slot" to "%creative_slot%", // Название рекламного места: String: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        24 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "view_cart", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "value" to 344.5, // Денежная ценноть события: Float: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        25 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "add_to_wishlist", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "value" to 344.5, // Денежная ценноть события: Float: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        26 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "add_shipping_info", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "value" to 344.5, // Денежная ценноть события: Float: НЕ обязательный параметр
                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                "shipping_tier" to "%shipping_tier%", // Категория доставки: String: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),
        27 to hashMapOf(
                "schema" to "iglu:ru.datago/event/jsonschema/1-0-0", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                "data" to hashMapOf(
                        "eventStructure" to "GA4", // Это константное значение: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ
                        "event" to "add_payment_info", // Название события: String: НЕ МЕНЯТЬ!!! НЕ УДАЛЯТЬ

                        // В eventContext любые дополнительные параметры события
                        // Все значения должны быть типа String
                        // Кол-во параметров ограничено настройками трекера на размер запроса
                        "eventParams" to hashMapOf(
                                "%eventParamsName1$" to "%eventParamsValue1",
                                "%eventParamsName2%" to "%eventParamsValue2%",
                                "%eventParamsName3%" to "%eventParamsValue3%"
                        ),
                        "ecommerce" to hashMapOf(
                                "currency" to "%currency%", // Валюта: String: НЕ обязательный параметр
                                "value" to 344.5, // Денежная ценноть события: Float: НЕ обязательный параметр
                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                "payment_type" to "%payment_type%", // Метод оплаты: String: НЕ обязательный параметр
                                "items" to listOf(
                                        hashMapOf(
                                                "item_name" to "%item_name%", // Название продукта: String: обязательный параметр, если не указан item_id
                                                "item_id" to "%item_id%",  // ID продукта: String: обязательный параметр, если не указан item_name
                                                "price" to 23.5, //  Цена продукта: Float: НЕ обязательный параметр
                                                "item_brand" to "%item_brand%",  // Бренд продукта: String: НЕ обязательный параметр
                                                "item_category" to "%item_category%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category2" to "%item_category2%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category3" to "%item_category3%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_category4" to "%item_category4%",  // Категория продукта: String: НЕ обязательный параметр
                                                "item_variant" to "%item_variant%",  // Вариант продукта: String: НЕ обязательный параметр
                                                "promotion_id" to "%promotion_id%",  // ID промо: String: НЕ обязательный параметр
                                                "promotion_name" to "%promotion_name%",  // Название промо: String: НЕ обязательный параметр
                                                "creative_name" to "%creative_name%",  // Название креатива: String: НЕ обязательный параметр
                                                "creative_slot" to "%creative_slot%",  // Слот креатива: String: НЕ обязательный параметр
                                                "location_id" to "%location_id%",  // ID локации: String: НЕ обязательный параметр
                                                "item_list_name" to "%item_list_name%", // Название списка: String: НЕ обязательный параметр
                                                "item_list_id" to "%item_list_id%", // ID списка: String: НЕ обязательный параметр
                                                "index" to 1,  // Позиция продукта в списке: Int: НЕ обязательный параметр
                                                "quantity" to 6,  // Кол-во продукта: Int: НЕ обязательный параметр
                                                "affiliation" to "%affiliation%", // Поставщик продукта: String: НЕ обязательный параметр
                                                "coupon" to "%coupon%", // Купон: String: НЕ обязательный параметр
                                                "discount" to 24.5, // Скидка: Float: НЕ обязательный параметр

                                                // Дополнительные параметры продукта
                                                // Тип String
                                                // Кол-во параметров ограничено настройками трекера на размер запроса
                                                "%customParamName1%" to "%customParamValue1", // Кастомный параметр 1: String: НЕ обязательный параметр
                                                "%customParamNameN%" to "%customParamValueN", // Кастомный параметр N: String: НЕ обязательный параметр
                                        )
                                )
                        )
                )
        ),

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
                        "Send event for GA UA Structure",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        3,
                        "Send event for GA4 Structure",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        4,
                        "GA UA: Ecommerce: Просмотр списка товаров",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        5,
                        "GA4: Ecommerce: Просмотр списка товаров",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        6,
                        "GA UA: Ecommerce: Клик по товару из списка",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        7,
                        "GA4: Ecommerce: Клик по товару из списка",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        8,
                        "GA UA: Ecommerce: Просмотр товара",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        9,
                        "GA4: Ecommerce: Просмотр товара",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        10,
                        "GA UA: Ecommerce: Добавление товара в корзину",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        11,
                        "GA4: Ecommerce: Добавление товара в корзину",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        12,
                        "GA UA: Ecommerce: Удаление товара из корзины",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        13,
                        "GA4: Ecommerce: Удаление товара из корзины",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        14,
                        "GA UA: Ecommerce: Старт оформления покупки",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        15,
                        "GA4: Ecommerce: Старт оформления покупки",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        16,
                        "GA UA: Ecommerce: Покупка",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        17,
                        "GA4: Ecommerce: Покупка",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        18,
                        "GA UA: Ecommerce: Возврат",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        19,
                        "GA4: Ecommerce: Возврат",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        20,
                        "GA UA: Ecommerce: Просмотр промо",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        21,
                        "GA4: Ecommerce: Просмотр промо",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        22,
                        "GA UA: Ecommerce: Клик по промо",
                        "Example of event for GA UA Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        23,
                        "GA4: Ecommerce: Клик по промо",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        24,
                        "GA4: Ecommerce: Просмотр корзины",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        25,
                        "GA4: Ecommerce: Добавление в список желаемого",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        25,
                        "GA4: Ecommerce: Добавление в список желаемого",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        26,
                        "GA4: Ecommerce: Указание сведений о доставке",
                        "Example of event for GA4 Structure",
                        ""
                ),
                CasesSchema.CaseSchema(
                        27,
                        "GA4: Ecommerce: Указание сведений об оплате",
                        "Example of event for GA4 Structure",
                        ""
                ),
        )
)