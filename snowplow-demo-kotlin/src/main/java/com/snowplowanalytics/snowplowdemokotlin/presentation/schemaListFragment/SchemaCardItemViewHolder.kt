package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaListFragment

import androidx.recyclerview.widget.RecyclerView
import com.snowplowanalytics.snowplowdemokotlin.databinding.SchemaCardItemBinding
import com.snowplowanalytics.snowplowdemokotlin.repository.CasesSchema

class SchemaCardItemViewHolder(private val binding: SchemaCardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(schemaCard: CasesSchema.CaseSchema, onClickListener: (Int) -> Unit) {
        binding.apply {
            itemId.text = schemaCard.id.toString()
            itemCase.text = schemaCard.case
            itemDescription.text = schemaCard.description
        }
        binding.root.setOnClickListener { onClickListener(schemaCard.id) }
    }

}