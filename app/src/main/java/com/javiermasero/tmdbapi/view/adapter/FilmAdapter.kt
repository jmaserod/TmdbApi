package com.javiermasero.tmdbapi.view.adapter


import android.view.View
import com.bumptech.glide.Glide
import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.R
import kotlinx.android.synthetic.main.element.view.*



class FilmAdapter(onItemClick: (Film) -> Unit) : RootAdapter<Film>(onItemClickListener = onItemClick) {
    override val itemLayoutId: Int = R.layout.element

    override fun viewHolder(view: View): RootViewHolder<Film> = PageViewHolder(view)

    class PageViewHolder(itemView: View) : RootViewHolder<Film>(itemView = itemView) {

        init {
            itemView.title2.setOnClickListener {
                onItemClickListener(adapterPosition)
            }
            //itemView.description.setOnClickListener { onItemClickListener(adapterPosition) }
            itemView.poster2.setOnClickListener { onItemClickListener(adapterPosition) }
        }

        override fun bind(model: Film) {
            itemView.title2.text = model.title
            //itemView.description.text = model.description
            Glide.with(itemView).load("https://image.tmdb.org/t/p/original" + model.image).into(itemView.poster2)
            //itemView.average.text = "Note: " + model.average.toString()
            itemView.dateDetail2.text = model.date
        }
    }
}





