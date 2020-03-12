package com.google.android.material.lists.viewHolders.twoLine;
/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.R;
import com.google.android.material.lists.viewHolders.MaterialViewHolder;

public class TwoLineCircleItemViewHolder extends MaterialViewHolder {

    public ImageView visual;
    public TextView primaryText;
    public TextView secondaryText;
    public FrameLayout secondaryAction;

    public TwoLineCircleItemViewHolder(@NonNull ViewGroup parent) {

        super(R.layout.two_line_circle_item, parent);
        this.visual = itemView.findViewById(R.id.material_list_item_visual);
        this.primaryText = itemView.findViewById(R.id.material_list_item_primary_text);
        this.secondaryText = itemView.findViewById(R.id.material_list_item_secondary_text);
        this.secondaryAction = itemView.findViewById(R.id.material_list_item_secondary_action);

    }

    @Override
    public void enableSampleMode() {
        Resources res = itemView.getResources();
        visual.setImageDrawable(res.getDrawable(R.drawable.square_sample_visual));
        primaryText.setText(res.getString(R.string.material_list_item_sample_mode_two_line_primary_text));
        secondaryText.setText(res.getString(R.string.material_list_item_sample_mode_two_line_secondary_text));
        secondaryAction.removeAllViews();
        secondaryAction.setBackgroundColor(res.getColor(R.color.placeholder_content));
    }
}
