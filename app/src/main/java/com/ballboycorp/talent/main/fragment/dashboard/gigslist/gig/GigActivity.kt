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
import kotlinx.android.synthetic.main.activity_gig.*
import kotlinx.android.synthetic.main.gig_vp_item.view.*

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

        gig_vp.adapter = GigViewPagerAdapter(this)
        gig_vp_navigator.setupWithViewPager(gig_vp, true)
    }

    inner class GigViewPagerAdapter (context: Context): PagerAdapter(){

        private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object` as LinearLayout
        }

        override fun getCount(): Int {
            return 3
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = layoutInflater.inflate(R.layout.gig_vp_item, container, false)
            view.gig_vp_thumb.setImageDrawable(resources.getDrawable(R.drawable.ic_gig_default))
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as LinearLayout)
        }

    }
}