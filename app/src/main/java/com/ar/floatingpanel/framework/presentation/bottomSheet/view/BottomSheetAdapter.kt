package com.ar.floatingpanel.framework.presentation.bottomSheet.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ar.floatingpanel.framework.presentation.bottomSheet.model.BottomSheet


class BottomSheetAdapter : ListAdapter<BottomSheet, BottomSheetHolder>(BottomSheetDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetHolder {
        return BottomSheetHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BottomSheetHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BottomSheetDiffCallback : DiffUtil.ItemCallback<BottomSheet>() {

        override fun areItemsTheSame(oldItem: BottomSheet, newItem: BottomSheet) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: BottomSheet, newItem: BottomSheet) =
            oldItem.name == newItem.name
    }
}