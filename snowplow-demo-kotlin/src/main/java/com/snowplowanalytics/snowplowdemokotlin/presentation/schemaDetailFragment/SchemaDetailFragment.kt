package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaDetailFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.snowplowanalytics.snowplowdemokotlin.R
import com.snowplowanalytics.snowplowdemokotlin.databinding.FragmentSchemaDetailBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SchemaDetailFragment : Fragment() {

    private lateinit var binding: FragmentSchemaDetailBinding
    private val viewModel by viewModel<SchemaDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSchemaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("id")
        binding.itemCaseName.text = id.toString()
        if (id != null) {
            viewModel.getCaseData(caseId = id)
        }
        viewModel.manuallyTrackScreenView()
        lifecycleScope.launch {
            viewModel.state.flowWithLifecycle(lifecycle).collectLatest {
                binding.apply {
                    itemCaseName.text = it.caseName
                    itemDescription.text = it.caseDescription
                    itemJSONSchema.text = it.jsonScheme.toString().replace("\\", "")
                    binding.toolbar.title = it.caseName
                }
            }
        }
        binding.checkBox.text = requireContext().getString(R.string.update_global_context) + "false"
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigate(
                R.id.action_schemaDetailFragment_pop
            )
        }
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            binding.checkBox.text = requireContext().getString(R.string.update_global_context) + isChecked
        }
        binding.sendEventButton.setOnClickListener {
            if (id != null) {
                viewModel.sendHit(id, binding.checkBox.isChecked)
            }
        }
    }
}