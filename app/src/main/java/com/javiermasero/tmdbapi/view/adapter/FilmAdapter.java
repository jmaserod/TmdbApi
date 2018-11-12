package com.javiermasero.tmdbapi.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.jetbrains.annotations.NotNull;

public class FilmAdapter extends RootAdapter {
    @Override
    public int getItemLayoutId() {
        return 0;
    }

    @NotNull
    @Override
    public RootViewHolder viewHolder(@NotNull View view) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
