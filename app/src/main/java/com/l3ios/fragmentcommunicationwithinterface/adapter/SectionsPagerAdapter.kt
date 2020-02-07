package com.l3ios.fragmentcommunicationwithinterface.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.annotation.StringRes
import com.l3ios.fragmentcommunicationwithinterface.fragment.FirstFragment
import com.l3ios.fragmentcommunicationwithinterface.R
import com.l3ios.fragmentcommunicationwithinterface.fragment.SecondFragment


class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    @StringRes
    private val TAB_TITLES = intArrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
    )

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            FirstFragment().newInstance()
        } else {
            SecondFragment().newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int = 2

}

