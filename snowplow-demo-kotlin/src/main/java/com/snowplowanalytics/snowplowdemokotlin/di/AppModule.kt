package com.snowplowanalytics.snowplowdemokotlin.di

import com.snowplowanalytics.snowplowdemokotlin.data.CasesSchemaDataSource
import com.snowplowanalytics.snowplowdemokotlin.data.MappedDataSource
import com.snowplowanalytics.snowplowdemokotlin.presentation.schemaDetailFragment.SchemaDetailViewModel
import com.snowplowanalytics.snowplowdemokotlin.presentation.schemaListFragment.SchemaListViewModel
import com.snowplowanalytics.snowplowdemokotlin.useCases.GetSchemaDetailsDataUseCase
import com.snowplowanalytics.snowplowdemokotlin.useCases.GetSchemaListUseCase
import com.snowplowanalytics.snowplowdemokotlin.repository.SchemaRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { CasesSchemaDataSource() }
    single { MappedDataSource() }
    single { SchemaRepository(get(), get()) }
    single { GetSchemaListUseCase(get()) }
    single { GetSchemaDetailsDataUseCase(get()) }
    viewModel { SchemaListViewModel(get()) }
    viewModel { SchemaDetailViewModel(get()) }
}