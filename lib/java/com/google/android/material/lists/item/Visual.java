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

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntDef;
import androidx.annotation.Nullable;

import com.google.android.material.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.internal.ViewUtils;

class Visual extends ShapeableImageView implements TotalLinesListener {

  public Visual(Context context) {
    super(context);
  }

  public Visual(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public Visual(Context context, @Nullable AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @IntDef({ICON, NORMAL, LARGE})
  public @interface VisualSize {
  }

  public static final int ICON = 0;
  public static final int NORMAL = 1;
  public static final int LARGE = 2;

  @VisualSize
  int size = 0;

  public @VisualSize
  int getSize() {
    return size;
  }

  public void setSize(int size) {

    this.size = size;
    updateVisual();
  }

  private int totalLines = 0;

  @Override
  public void onTotalLinesChange(int totalLines) {

    this.totalLines = totalLines;
    updateVisual();

  }

  private void updateVisual() {

    int gravity = calculateGravity(totalLines);
    int[] bounds = calculateBounds(totalLines);
    int[] layoutMargins = calculateLayoutMargins(totalLines);

    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
    layoutParams.gravity = gravity;
    layoutParams.width = bounds[0];
    layoutParams.height = bounds[1];
    layoutParams.setMargins(layoutMargins[0], layoutMargins[1], layoutMargins[2], layoutMargins[3]);
  }

  private int calculateGravity(int totalLines) {
    int gravity = Gravity.CENTER_VERTICAL;
    if (size == ICON || totalLines >= 3) {
      gravity = Gravity.TOP;
    }
    return gravity;
  }

  private int[] calculateBounds(int totalLines) {
    int[] bounds = new int[2];

    if (size == LARGE) {
      int rectangleWidth = getDimensionInt(R.dimen.mtrl_list_item_visual_rectangle_width);
      int rectangleHeight = getDimensionInt(R.dimen.mtrl_list_item_visual_rectangle_height);
      bounds[0] = rectangleWidth;
      bounds[1] = rectangleHeight;
    } else {
      int size = 0;
      switch (this.size) {
        case ICON:
          size = getDimensionInt(R.dimen.mtrl_list_item_visual_icon_size);
          break;
        case NORMAL:
          size = getDimensionInt(R.dimen.mtrl_list_item_visual_normal_size);
      }
      bounds[0] = size;
      bounds[1] = size;
    }
    return bounds;
  }

  private int[] calculateLayoutMargins(int totalLines) {
    int smallLayoutMargin = getDimensionInt(R.dimen.mtrl_list_item_visual_layout_margin_small);
    int normalLayoutMargin = getDimensionInt(R.dimen.mtrl_list_item_visual_layout_margin_normal);
    int largeLayoutMargin = getDimensionInt(R.dimen.mtrl_list_item_visual_layout_margin_large);

    int[] layoutMargins = {
        normalLayoutMargin,
        normalLayoutMargin,
        normalLayoutMargin,
        normalLayoutMargin};

    switch (size) {
      case ICON:
        layoutMargins[2] = largeLayoutMargin;
        break;
      case NORMAL:
        if (totalLines == 1) {
          layoutMargins[1] = smallLayoutMargin;
          layoutMargins[3] = smallLayoutMargin;
        }
        break;
      case LARGE:
        layoutMargins[0] = 0;
        if (totalLines >= 3) {
          layoutMargins[2] = 20;
        } else {
          layoutMargins[1] = smallLayoutMargin;
          layoutMargins[3] = smallLayoutMargin;
        }
        break;
    }

    if (ViewUtils.isLayoutRtl(this)) {
      int temp = layoutMargins[0];
      layoutMargins[0] = layoutMargins[2];
      layoutMargins[2] = temp;
    }
    return layoutMargins;
  }

  @Dimension
  private int getDimensionInt(@DimenRes int resource) {

    return (int) getContext().getResources().getDimension(resource);
  }
}
