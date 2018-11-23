package com.javiermasero.tmdbapi.view.adapter

import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.parseIntent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.R
import com.javiermasero.tmdbapi.view.activity.SecondActivity
import kotlinx.android.synthetic.main.details.view.*
import kotlinx.android.synthetic.main.element.view.*

class DetailsAdapter: RootAdapter<Film>() {
    override val itemLayoutId: Int = R.layout.details

    override fun viewHolder(view: View): RootViewHolder<Film> = PageViewHolder(view)

    class PageViewHolder(itemView: View) : RootViewHolder<Film>(itemView = itemView) {


        override fun bind(model: Film) {

            itemView.titleDetail.text = model.title
            itemView.descriptionDetail.text = model.description
            Glide.with(itemView).load("https://image.tmdb.org/t/p/original" + model.image).into(itemView.posterDetail)
            itemView.averageDetail.text = "Note: " + model.average.toString()
            Glide.with(itemView).load("https://image.tmdb.org/t/p/original" + model.backdrop).into(itemView.backdropDetail)
            itemView.countDetail.text = model.count.toString()
            itemView.adultDetail.text = model.adult.toString()
            itemView.dateDetail.text = model.date
        }



    }
}