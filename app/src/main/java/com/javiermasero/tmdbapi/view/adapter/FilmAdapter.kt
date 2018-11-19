package com.javiermasero.tmdbapi.view.adapter;


import android.view.View

import com.bumptech.glide.Glide

import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.R


import kotlinx.android.synthetic.main.element.view.*


class FilmAdapter : RootAdapter<Film>() {
    override val itemLayoutId: Int = R.layout.element

    override fun viewHolder(view: View): RootViewHolder<Film> = PageViewHolder(view)

    class PageViewHolder(itemView: View) : RootViewHolder<Film>(itemView = itemView) {
        override fun bind(model: Film) {
            itemView.title.text = model.title
            itemView.descriptionDetail.text = model.description
            Glide.with(itemView).load("https://image.tmdb.org/t/p/original" + model.image).into(itemView.poster)
            itemView.average.text = "Note: " + model.average.toString()
        }
    }
}





