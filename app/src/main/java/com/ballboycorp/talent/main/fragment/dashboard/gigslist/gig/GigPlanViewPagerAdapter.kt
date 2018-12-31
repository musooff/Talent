package com.ballboycorp.talent.main.fragment.dashboard.gigslist.gig

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.ballboycorp.talent.R
import com.ballboycorp.talent.main.fragment.dashboard.gigslist.gig.model.Plan
import kotlinx.android.synthetic.main.gig_plan_vp_item.view.*


/**
 * Created by muso on 31/12/2018.
 */


class GigPlanViewPagerAdapter (private val context: Context, private val plans: List<Plan>): PagerAdapter(){

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun getCount(): Int {
        return plans.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = layoutInflater.inflate(R.layout.gig_plan_vp_item, container, false)
        view.plan_item_description.text = plans[position].description
        view.plan_item_features.text = plans[position].features.joinToString("") { "- $it\n" }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return String.format("%d s", plans[position].price)
    }

}