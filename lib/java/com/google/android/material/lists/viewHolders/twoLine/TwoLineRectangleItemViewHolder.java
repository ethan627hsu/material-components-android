package com.google.android.material.lists.viewHolders.twoLine;
/*
 * Copyright (C) 2019 The Android Open Source Project
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

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.lists.viewHolders.MaterialViewHolder;

/**
 * A two-lined ViewHolder with a rectangular image, title text, one line of subtext and an action
 */
public class TwoLineRectangleItemViewHolder extends MaterialViewHolder {

    public ShapeableImageView visual;
    public TextView primaryText;
    public TextView secondaryText;
    public FrameLayout secondaryAction;

    public TwoLineRectangleItemViewHolder(@NonNull ViewGroup parent) {

        super(R.layout.two_line_rectangle_item, parent);
        this.visual = itemView.findViewById(R.id.mtrl_list_item_visual);
        this.primaryText = itemView.findViewById(R.id.mtrl_list_item_primary_text);
        this.secondaryText = itemView.findViewById(R.id.mtrl_list_item_secondary_text);
        this.secondaryAction = itemView.findViewById(R.id.mtrl_list_item_secondary_action);
    }

}
