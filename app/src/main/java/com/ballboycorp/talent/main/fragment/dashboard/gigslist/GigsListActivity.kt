package com.ballboycorp.talent.main.fragment.dashboard.gigslist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.talent.R
import com.ballboycorp.talent.main.fragment.dashboard.gigslist.gig.GigActivity
import com.ballboycorp.talent.main.fragment.dashboard.gigslist.model.Gig
import kotlinx.android.synthetic.main.activity_gigslist.*
import kotlinx.android.synthetic.main.gigs_rv_item.view.*

/**
 * Created by musooff on 30/12/2018.
 */

class GigsListActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_CATEGORY_ID = "categoryId"

        fun newIntent(context: Context, gigId: Int) {
            val intent = Intent(context, GigsListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra(EXTRA_CATEGORY_ID, gigId)
            context.startActivity(intent)
        }
    }


    private val gigs = ArrayList<Gig>()
    private lateinit var gigAdapter: GigAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gigslist)

        gigAdapter = GigAdapter()
        gigs_rv.layoutManager = LinearLayoutManager(this)
        gigs_rv.adapter = gigAdapter

        gigs.add(Gig("I do your homework within a day", 5.0))
        gigs.add(Gig("I do your homework within a day", 5.0))
        gigs.add(Gig("I do your homework within a day", 5.0))

        gigAdapter.notifyDataSetChanged()
    }

    inner class GigAdapter : RecyclerView.Adapter<GigsViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GigsViewHolder {
            return GigsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.gigs_rv_item, parent, false))
        }

        override fun getItemCount(): Int {
            return gigs.size
        }

        override fun onBindViewHolder(holder: GigsViewHolder, position: Int) {
            val item = gigs[position]
            holder.bind(item)
        }
    }

    class GigsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(gig: Gig){
            if (view.context == null)
                return
            view.gig_title.text = gig.title
            view.gig_start_price.text  = String.format(view.context.getString(R.string.gig_start_price_format), gig.startPrice)

            view.setOnClickListener {
                GigActivity.newIntent(view.context, gig.gigId)
            }
        }
    }
}