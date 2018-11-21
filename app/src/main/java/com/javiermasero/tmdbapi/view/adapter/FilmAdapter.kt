package com.javiermasero.tmdbapi.view.adapter


import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast

import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init

import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.R
import com.javiermasero.tmdbapi.R.id.films
import com.javiermasero.tmdbapi.view.activity.MainActivity
import com.javiermasero.tmdbapi.view.activity.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*


import kotlinx.android.synthetic.main.element.view.*


class FilmAdapter : RootAdapter<Film>() {
    override val itemLayoutId: Int = R.layout.element

    override fun viewHolder(view: View): RootViewHolder<Film> = PageViewHolder(view)

    class PageViewHolder(itemView: View) : RootViewHolder<Film>(itemView = itemView){

        init {
            itemView.title.setOnClickListener { onItemClickListener(adapterPosition) }
        }
        override fun bind(model: Film) {
            itemView.title.text = model.title
            itemView.description.text = model.description
            Glide.with(itemView).load("https://image.tmdb.org/t/p/original" + model.image).into(itemView.poster)
            itemView.average.text = "Note: " + model.average.toString()
            //itemView.setOnClickListener {
            //    itemView.context.startActivity(Intent(itemView.context, SecondActivity::class.java).putExtra("id", itemView.id))
            //}
        }
    }
}





