package com.example.mybottomnavigation_5i

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mybottomnavigation_5i.ui.dashboard.DashboardFragment
import com.example.mybottomnavigation_5i.ui.home.HomeFragment
import com.example.mybottomnavigation_5i.ui.notifications.NotificationsFragment
import com.example.mybottomnavigation_5i.ui.profile.ProfileFragment

class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = NotificationsFragment()
            2 -> fragment = DashboardFragment()
            3 -> fragment = ProfileFragment()
        }
        return fragment as Fragment
    }
}