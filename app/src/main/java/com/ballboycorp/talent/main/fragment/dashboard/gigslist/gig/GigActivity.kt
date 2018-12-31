package com.ballboycorp.talent.main.fragment.dashboard.gigslist.gig

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.ballboycorp.talent.R
import com.ballboycorp.talent.main.fragment.dashboard.gigslist.gig.model.Plan
import com.ballboycorp.talent.main.fragment.dashboard.gigslist.gig.util.WrapContentHeightViewPager
import kotlinx.android.synthetic.main.activity_gig.*
import kotlinx.android.synthetic.main.gig_thumb_vp_item.view.*

/**
 * Created by musooff on 30/12/2018.
 */

class GigActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_GIG_ID = "gigId"

        fun newIntent(context: Context, gigId: Int) {
            val intent = Intent(context, GigActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra(EXTRA_GIG_ID, gigId)
            context.startActivity(intent)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gig)

        gig_thumb_vp.adapter = GigThumbViewPagerAdapter(this)
        gig_thumb_tl.setupWithViewPager(gig_thumb_vp, true)

        val plans = ArrayList<Plan>()
        plans.add(Plan(5, "Some description", listOf("Homework solution", "Explanation of the homework")))
        plans.add(Plan(10, "Some description", listOf("Homework solution", "Explanation of the homework")))
        plans.add(Plan(20, "Some description", listOf("Homework solution", "Explanation of the homework")))

        gig_plans_vp.adapter = GigPlanViewPagerAdapter(this, plans)
        gig_plans_tl.setupWithViewPager(gig_plans_vp, true)

    }
}