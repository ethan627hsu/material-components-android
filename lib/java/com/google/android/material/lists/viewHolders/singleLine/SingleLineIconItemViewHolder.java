package com.google.android.material.lists.viewHolders.singleLine;
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

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.R;
import com.google.android.material.lists.viewHolders.MaterialViewHolder;

/**
 * A single-lined ViewHolder with a two actions and one line of text
 */
public class SingleLineIconItemViewHolder extends MaterialViewHolder {

    public FrameLayout primaryAction;
    public TextView primaryText;

    public SingleLineIconItemViewHolder(@NonNull ViewGroup parent) {

        super(R.layout.single_line_icon_item, parent);
        this.primaryAction = itemView.findViewById(R.id.mtrl_list_item_primary_action);
        this.primaryText = itemView.findViewById(R.id.mtrl_list_item_primary_text);
    }

    @Override
    public void enableSampleMode() {
        Resources res = itemView.getResources();
        primaryAction.removeAllViews();
        primaryAction.setBackgroundColor(res.getColor(R.color.placeholder_content));
        primaryText.setText(res.getString(R.string.mtrl_list_item_sample_mode_single_line_primary_text));
    }


}
