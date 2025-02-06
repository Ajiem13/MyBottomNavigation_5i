package com.example.mybottomnavigation_5i

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.mybottomnavigation_5i.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mybottomnavigation_5i.ui.dashboard.DashboardFragment
import com.example.mybottomnavigation_5i.ui.home.HomeFragment
import com.example.mybottomnavigation_5i.ui.notifications.NotificationsFragment
import com.example.mybottomnavigation_5i.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewPager2 Setup
        val viewPagerAdapter = FragmentAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter

        // BottomNavigationView
        val navView: BottomNavigationView = binding.navView

        // Synchronize BottomNavigationView and ViewPager2
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> binding.viewPager.currentItem = 0
                R.id.navigation_dashboard -> binding.viewPager.currentItem = 1
                R.id.navigation_notifications -> binding.viewPager.currentItem = 2
                R.id.navigation_profile -> binding.viewPager.currentItem = 3
            }
            true
        }

        // Synchronize swipe on ViewPager2 with BottomNavigationView
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.navView.selectedItemId = R.id.navigation_home
                    1 -> binding.navView.selectedItemId = R.id.navigation_dashboard
                    2 -> binding.navView.selectedItemId = R.id.navigation_notifications
                    3 -> binding.navView.selectedItemId = R.id.navigation_profile
                }
            }
        })
    }
}

// Adapter untuk ViewPager2
class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4  // Menyesuaikan jumlah item menu

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> DashboardFragment()
            2 -> NotificationsFragment()
            3 -> ProfileFragment()
            else -> HomeFragment()
        }
    }
}
