package com.snowplowanalytics.snowplowdemokotlin.data

import com.snowplowanalytics.snowplowdemokotlin.repository.CasesSchema

class CasesSchemaDataSource {
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

    fun getData(): CasesSchema {
        return casesList
    }
}