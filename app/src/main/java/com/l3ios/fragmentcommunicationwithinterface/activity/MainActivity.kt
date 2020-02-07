package com.l3ios.fragmentcommunicationwithinterface.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.l3ios.fragmentcommunicationwithinterface.R
import com.l3ios.fragmentcommunicationwithinterface.adapter.SectionsPagerAdapter
import com.l3ios.fragmentcommunicationwithinterface.fragment.FirstFragment
import com.l3ios.fragmentcommunicationwithinterface.fragment.SecondFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FirstFragment.OnFragmentCommunicationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = adapter
        tabs.setupWithViewPager(view_pager)
    }

    override fun onNameChange(name: String) {
        val tag = "android:switcher:${view_pager.id}:1"
        val fragment = supportFragmentManager.findFragmentByTag(tag) as SecondFragment?
        fragment?.onNameChange(name)
    }

    override fun onEmailChange(email: String) {
        val tag = "android:switcher:${view_pager.id}:1"
        val fragment = supportFragmentManager.findFragmentByTag(tag) as SecondFragment?
        fragment?.onEmailChange(email)
    }
}
