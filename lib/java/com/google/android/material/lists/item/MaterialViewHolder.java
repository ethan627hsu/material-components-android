/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.material.lists.item;

import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;

public class MaterialViewHolder extends RecyclerView.ViewHolder {

  private Visual visual;
  private TextCollection textCollection;
  private SecondaryContent secondaryContent;

  @NonNull
  public ShapeableImageView getVisual() {
    return visual;
  }

  public void setVisualSize(@Visual.VisualSize int visualSize) {
    visual.setSize(visualSize);
  }

  @NonNull
  public TextView getOverlineText() {
    return textCollection.getOverlineText();
  }

  @NonNull
  public TextView getPrimaryText() {
    return textCollection.getPrimaryText();
  }

  @NonNull
  public TextView getSecondaryText() {
    return textCollection.getSecondaryText();
  }

  @NonNull
  public TextView getMetadata() {
    return secondaryContent.getMetadata();
  }

  @NonNull
  public FrameLayout getAction() {
    return secondaryContent.getAction();
  }

  public MaterialViewHolder(@NonNull ViewGroup parent) {

    super(inflateListItemLayout(parent));

    visual = itemView.findViewById(R.id.material_list_item_visual);
    textCollection = itemView.findViewById(R.id.material_list_item_text_collection);
    secondaryContent = itemView.findViewById(R.id.material_list_item_secondary_content);

    textCollection.setTotalLinesListener(new TotalLinesListener() {
      @Override
      public void onTotalLinesChange(int totalLines) {
        updateTotalLines(totalLines);
      }
    });


    final int[] attrs = new int[]{
        R.attr.visualShapeAppearance,
        R.attr.visualShapeAppearanceOverlay,
        R.attr.visualSize,
        R.attr.overlineTextAppearance,
        R.attr.primaryTextAppearance,
        R.attr.secondaryTextAppearance,
        R.attr.metadataTextAppearance};

    TypedValue typedValue = new TypedValue();
    parent.getContext().getTheme().resolveAttribute(R.attr.materialViewHolderStyle, typedValue, true);
    TypedArray style = parent.getContext().getTheme().obtainStyledAttributes(typedValue.resourceId, attrs);

    visual.setShapeAppearanceModel(ShapeAppearanceModel.builder(parent.getContext(), style.getResourceId(0, 0), style.getResourceId(1, 0)).build());
    visual.setSize(style.getInt(2, 0));
    TextViewCompat.setTextAppearance(getOverlineText(), style.getResourceId(3, 0));
    TextViewCompat.setTextAppearance(getPrimaryText(), style.getResourceId(4, 0));
    TextViewCompat.setTextAppearance(getSecondaryText(), style.getResourceId(5, 0));
    TextViewCompat.setTextAppearance(getMetadata(), style.getResourceId(6, 0));
    style.recycle();

    updateTotalLines(0);
  }

  private static View inflateListItemLayout(@NonNull ViewGroup parent) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View itemView = layoutInflater.inflate(R.layout.material_list_item, parent, false);
    return itemView;
  }

  private void updateTotalLines(int totalLines) {
    visual.onTotalLinesChange(totalLines);
    textCollection.onTotalLinesChange(totalLines);
    secondaryContent.onTotalLinesChange(totalLines);
  }
}
