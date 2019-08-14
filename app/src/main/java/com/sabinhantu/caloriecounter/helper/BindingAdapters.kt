package com.sabinhantu.caloriecounter.helper

import android.view.View
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter

@BindingAdapter("android:layout_weight")
fun setLayoutWeight(view: View, weight: Float) {
    val layoutParams = view.layoutParams as LinearLayout.LayoutParams
    layoutParams.weight = weight
    view.layoutParams = layoutParams
}