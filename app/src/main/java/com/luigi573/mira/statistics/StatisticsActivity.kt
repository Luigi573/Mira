package com.luigi573.mira.statistics

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import androidx.navigation.findNavController
import com.luigi573.mira.R

class StatisticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.statistics_act)
//        val fragment =StatisticsFragment()
//        val fragmentManager = supportFragmentManager
//        fragmentManager.beginTransaction().add(R.id.container, fragment).commit()
//        val navController = findNavController(R.id.nav_host_fragment)
//        navController.navigate(R.id.statisticsFragment)
    }
}