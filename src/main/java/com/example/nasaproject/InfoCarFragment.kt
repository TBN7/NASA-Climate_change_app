package com.example.nasaproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InfoCarFragment(
    private val onCorrectAnswer: () -> Unit,
    private val onIncorrectAnswer: () -> Unit,
    private val onSemiIncorrectAnswer: () -> Unit
): BottomSheetDialogFragment() {
    lateinit var infoCar: AppCompatTextView
    lateinit var aVariant: AppCompatButton
    lateinit var bVariant: AppCompatButton
    lateinit var cVariant: AppCompatButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_item_info_car, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews(){
        infoCar = requireView().findViewById(R.id.info_car)
        aVariant = requireView().findViewById(R.id.a_car_variant)
        bVariant = requireView().findViewById(R.id.b_car_variant)
        cVariant = requireView().findViewById(R.id.c_car_variant)

        aVariant.setOnClickListener {
            onIncorrectAnswer()
            openIncorrectA()
        }

        bVariant.setOnClickListener {
            onCorrectAnswer()
            openCorrectAnswer()
        }

        cVariant.setOnClickListener {
            onSemiIncorrectAnswer()
            openIncorrectC()
        }


    }

    private fun openCorrectAnswer() {
        val carFragment = CarCorrectFragment()
        carFragment.show(parentFragmentManager, "CarCorrectFragment")
    }

    private fun openIncorrectA() {
        val incorrectAFragment = CarIncorrectAFragment()
        incorrectAFragment.show(parentFragmentManager, "CarIncorrectAFragment")
    }

    private fun openIncorrectC() {
        val incorrectCFragment = CarIncorrectCFragment()
        incorrectCFragment.show(parentFragmentManager, "CatIncorrectCFragment")
    }
}