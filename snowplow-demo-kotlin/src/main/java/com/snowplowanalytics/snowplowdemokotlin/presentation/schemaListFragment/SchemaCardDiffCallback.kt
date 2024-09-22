package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaListFragment

import androidx.recyclerview.widget.DiffUtil
import com.snowplowanalytics.snowplowdemokotlin.repository.CasesSchema

class SchemaCardDiffCallback : DiffUtil.ItemCallback<CasesSchema.CaseSchema>() {
    override fun areItemsTheSame(
        oldItem: CasesSchema.CaseSchema,
        newItem: CasesSchema.CaseSchema
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: CasesSchema.CaseSchema,
        newItem: CasesSchema.CaseSchema
    ): Boolean {
        return oldItem == newItem
    }
}