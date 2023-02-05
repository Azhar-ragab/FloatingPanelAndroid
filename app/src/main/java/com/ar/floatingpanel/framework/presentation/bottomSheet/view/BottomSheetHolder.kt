package com.ar.floatingpanel.framework.presentation.bottomSheet.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ar.floatingpanel.databinding.ItemNameBinding
import com.ar.floatingpanel.framework.presentation.bottomSheet.model.BottomSheet


class BottomSheetHolder(private val binding: ItemNameBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(bottomSheet: BottomSheet) {
        binding.name = bottomSheet.name
    }

    companion object {
        fun from(parent: ViewGroup): BottomSheetHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemNameBinding.inflate(layoutInflater, parent, false)
            return BottomSheetHolder(binding)
        }
    }
}