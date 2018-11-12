package com.javiermasero.tmdbapi.view.adapter;

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.javiermasero.tmdbapi.R
import com.javiermasero.tmdbapi.model.PageView

class PageAdapter (private var items: MutableList<PageView> = mutableListOf(),
                          private val onItemClick: (PageView) -> Unit,
                          private val onItemSelected: (PageView) -> Unit): RecyclerView.Adapter<PageAdapter.PageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.activity_main, parent, false)
        return PageViewHolder(itemView = view,
                onItemClick = { onItemClick(items[it]) },
                onItemSelected = { onItemSelected(items[it]) })
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun replaceItems(items: MutableList<PageView>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun addItem(pageView: PageView) {
        this.items.add(pageView)
        notifyItemInserted(items.size - 1)
    }

    

    override fun getItemCount(): Int = items.size


    class PageViewHolder (itemView: View, onItemClick: (Int) -> Unit,
                          onItemSelected: (Int) -> Unit) : RecyclerView.ViewHolder(itemView){

    }
}




