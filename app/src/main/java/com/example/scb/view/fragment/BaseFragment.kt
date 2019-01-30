package com.example.scb.view.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.scb.R
import com.example.scb.presenter.adapter.MyPagerAdapter





class BaseFragment : Fragment() {
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //        Create TabLayout
        createTabLayout()

        //        Create ViewPager
        createViewPager()

    }   // Main Method

    private fun createViewPager() {
        viewPager = view!!.findViewById(R.id.viewPager)
        val myPagerAdapter = MyPagerAdapter(
                activity!!.supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = myPagerAdapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout!!.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {


            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
//                Log.d("FINDDDD", "change!!"+tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
//                Log.d("FINDDDD", "unselect!!"+tab.position)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
//                Log.d("FINDDDD", "reselct!!"+tab.position)
            }
        })
    }

    private fun createTabLayout() {
        tabLayout = view!!.findViewById(R.id.tabLayout)
        val strings = arrayOf("Mobile List", "Favourite List")
        var i = 0
        while (i < strings.size) {
            tabLayout!!.addTab(tabLayout!!.newTab().setText(strings[i]))
            i += 1
        }
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }
}
