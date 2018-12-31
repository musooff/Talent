package com.ballboycorp.talent.main.fragment.dashboard.gigslist.gig

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.ballboycorp.talent.R
import kotlinx.android.synthetic.main.gig_thumb_vp_item.view.*

/**
 * Created by muso on 31/12/2018.
 */

class GigThumbViewPagerAdapter (private val context: Context): PagerAdapter(){

        private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object` as LinearLayout
        }

        override fun getCount(): Int {
            return 3
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = layoutInflater.inflate(R.layout.gig_thumb_vp_item, container, false)
            view.gig_vp_thumb.setImageDrawable(context.resources.getDrawable(R.drawable.ic_gig_default))
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as LinearLayout)
        }

    }