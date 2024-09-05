/*
 * Copyright (c) 2015-2023 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.snowplowanalytics.snowplowdemokotlin

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.snowplowanalytics.snowplowdemokotlin.databinding.ActivityMainBinding
import com.snowplowanalytics.snowplowdemokotlin.tracking.Tracking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        parseIntent()
        Tracking.setup("compose_demo", applicationContext)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.host_activity) as NavHostFragment
        navController = navHostFragment.navController
        Tracking.AutoTrackScreenView(navController = navController)
    }

    // Этот метод нужен для парсинга диплинков
    private fun parseIntent() {
        val action: String? = intent?.action
        val data: Uri? = intent?.data
        val id = data?.getQueryParameter("id") ?: 1
        if (data.toString() == "https://datago.ru") {
            navController.navigate(R.id.action_to_schemaDetailFragment, bundleOf("id" to id))
        }
    }
}
