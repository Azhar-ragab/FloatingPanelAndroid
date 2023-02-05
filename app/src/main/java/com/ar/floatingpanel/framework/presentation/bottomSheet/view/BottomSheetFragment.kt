package com.ar.floatingpanel.framework.presentation.bottomSheet.view

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ar.floatingpanel.databinding.FragmentBottomSheetBinding
import com.ar.floatingpanel.framework.presentation.bottomSheet.model.BottomSheet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding
    private val height: Int by lazy { Resources.getSystem().displayMetrics.heightPixels }
    private lateinit var adapter: BottomSheetAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        val layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (height * 0.90f).toInt())
        binding.root.layoutParams = layoutParams
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }
    override fun onStart() {
        super.onStart()
        handleBottomSheetBehavior()
    }

    private fun bindViews() {
        adapter = BottomSheetAdapter()
        val bottomSheetList = arrayListOf<BottomSheet>()
        for(i in 0..15) {
            val item = BottomSheet("Item $i")
            bottomSheetList.add(item)
        }
        adapter.submitList(bottomSheetList)
        binding.itemsRV.adapter = adapter
    }

    private fun handleBottomSheetBehavior() {
        BottomSheetBehavior.from(requireView().parent as View).apply {
            peekHeight = height / 2
            if (state == BottomSheetBehavior.STATE_COLLAPSED)
                binding.itemsRV.setPadding(0, 0, 0, height / 4)

            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {}

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    binding.itemsRV.setPadding(
                        0,
                        0,
                        0,
                        ((height / 4.0) - (slideOffset * (height / 4.0))).toInt()
                    )
                }
            })
        }
    }

    companion object {
        const val TAG = "BottomSheetFragment"
    }
}