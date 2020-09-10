package com.mforn.template.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mforn.authentication.presentation.view.activity.AuthenticationLauncherActivity
import com.mforn.common.presentation.view.activity.BaseActivity
import com.mforn.onboarding.presentation.view.activity.OnboardingActivity
import com.mforn.template.R


class HomeActivity : BaseActivity() {


    override val layout = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViews()

        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
    }

    private fun setViews() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}