package com.ballboycorp.talent.main.fragment.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ballboycorp.talent.R
import com.ballboycorp.talent.main.fragment.dashboard.gigslist.GigsListActivity
import com.ballboycorp.talent.main.fragment.dashboard.model.Category
import kotlinx.android.synthetic.main.dashboard_category_item.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*


/**
 * Created by musooff on 30/12/2018.
 */

class DashboardFragment : Fragment() {

    private val categories = ArrayList<Category>()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_dashboard, container, false)
        categoryAdapter = CategoryAdapter()
        view.dashboard_rv.layoutManager = LinearLayoutManager(context)
        view.dashboard_rv.adapter = categoryAdapter

        categories.add(Category("Homework", listOf("Mathematics, Physics")))
        categories.add(Category("Work", listOf("Truck loading", "Painting")))
        categories.add(Category("Anything else", listOf("Video Editing")))

        categoryAdapter.notifyDataSetChanged()

        return view
    }

    inner class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            return CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.dashboard_category_item, parent, false))
        }

        override fun getItemCount(): Int {
            return categories.size
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            val item = categories[position]
            holder.bind(item)
        }
    }

    class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(category: Category){
            if (view.context == null)
                return
            view.category_title.text = category.title
            view.category_sub_titles.text  = category.subTitles.joinToString(", ")

            view.setOnClickListener {
                GigsListActivity.newIntent(view.context, category.id)
            }
        }
    }
}