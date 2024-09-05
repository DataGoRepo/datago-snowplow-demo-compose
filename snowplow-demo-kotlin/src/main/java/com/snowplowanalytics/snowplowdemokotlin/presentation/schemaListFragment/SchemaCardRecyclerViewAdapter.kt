package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaListFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.snowplowanalytics.snowplowdemokotlin.databinding.SchemaCardItemBinding
import com.snowplowanalytics.snowplowdemokotlin.repository.CasesSchema

class SchemaCardRecyclerViewAdapter(private val onSchemaCardClicked: (Int) -> Unit ) :
    ListAdapter<CasesSchema.CaseSchema, SchemaCardItemViewHolder>(SchemaCardDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchemaCardItemViewHolder {

        return SchemaCardItemViewHolder(
            SchemaCardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: SchemaCardItemViewHolder, position: Int) {
        holder.bind(currentList[position] as CasesSchema.CaseSchema, onSchemaCardClicked)
    }
}