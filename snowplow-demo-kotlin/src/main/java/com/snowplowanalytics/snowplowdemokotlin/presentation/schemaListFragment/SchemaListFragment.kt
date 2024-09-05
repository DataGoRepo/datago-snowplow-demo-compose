package com.snowplowanalytics.snowplowdemokotlin.presentation.schemaListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.snowplowanalytics.snowplowdemokotlin.R
import com.snowplowanalytics.snowplowdemokotlin.databinding.FragmentSchemaListBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SchemaListFragment : Fragment() {

    private lateinit var binding: FragmentSchemaListBinding
    private lateinit var schemaListAdapter: SchemaCardRecyclerViewAdapter
    private val viewModel by viewModel<SchemaListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSchemaListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        schemaListAdapter = SchemaCardRecyclerViewAdapter(onSchemaCardClicked = { id ->
            val bundle = bundleOf("id" to id)
            findNavController().navigate(
                R.id.action_to_schemaDetailFragment,
                bundle
            )
        })
        binding.schemaRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = schemaListAdapter
        }
        viewModel.getSchemaList()
        lifecycleScope.launch {
            viewModel.state.flowWithLifecycle(lifecycle).collectLatest {
                schemaListAdapter.submitList(it.schemaList)
            }
        }
    }
}