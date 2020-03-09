package com.google.android.material.lists.viewHolders;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/** A standard view holder that all specific Material view holders extend */
public abstract class MaterialViewHolder extends RecyclerView.ViewHolder {

    protected MaterialViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    protected MaterialViewHolder(int layout, @NonNull ViewGroup parent) {
        this(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
    }

    /** Sample mode allows the MaterialViewHolder to pre-populate its elements with sample text, imagery
     * and content. This allows for visual testing of the MaterialViewHolder's look and feel without using
     * real data.
     * When ran, the MaterialViewHolder will use sample content to overwrite basic attributes such as:
     *<ul>
     *<li> {@link android.widget.TextView#setText(CharSequence)}
     *<li> {@link android.widget.ImageView#setImageDrawable(Drawable)}
     *</ul>
     */
     public abstract void enableSampleMode();
}
