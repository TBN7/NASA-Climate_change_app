package com.example.nasaproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InfoFactoryFragment(
    private val onCorrectAnswer: () -> Unit,
    private val onIncorrectAnswer: () -> Unit
): BottomSheetDialogFragment() {
    lateinit var infoFactory: AppCompatTextView
    lateinit var aVariant: AppCompatButton
    lateinit var bVariant: AppCompatButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_item_info_factory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews(){
        infoFactory = requireView().findViewById(R.id.info_factory)
        aVariant = requireView().findViewById(R.id.a_variant)
        bVariant = requireView().findViewById(R.id.b_variant)

        aVariant.setOnClickListener {
            onCorrectAnswer()
            openCorrect()
        }

        bVariant.setOnClickListener {
            onIncorrectAnswer()
            openIncorrect()
        }

    }

    private fun openCorrect() {
        val facCorrectFragment = FacCorrectFragment()
        facCorrectFragment.show(parentFragmentManager, "FacCorrectFragment")
    }

    private fun openIncorrect() {
        val facIncorrectFragment = FacIncorrectFragment()
        facIncorrectFragment.show(parentFragmentManager, "FacIncorrectFragment")
    }

}