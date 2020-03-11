package com.google.android.material.lists.viewHolders;

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

  /**
   * Allows for the MaterialViewHolder to have a divider that is placed at the bottom of the item
   * @param dividerType Controls the type of divider placed. In some cases, if {@link DividerType#INSET}
   * is entered, then {@link DividerType#FULL_BLEED} will be used (if the MaterialViewHolder does not
   * support inset dividers).
   */
  public abstract void setDividerType(DividerType dividerType);

  /**
   * A representation for different dividers used in a {@link MaterialViewHolder}
   */
  public enum DividerType {
    /** Represents the no divider for a list item **/
    NONE,
    /** Represents a divider that spans until it reaches a visual or primary action element **/
    INSET,
    /** Represents a divider that spans for the entire width of a list item **/
    FULL_BLEED
  }
}
