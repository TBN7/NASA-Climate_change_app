package com.example.nasaproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InfoPersonFragment : BottomSheetDialogFragment() {
    lateinit var button: AppCompatButton
    lateinit var infoPerson: AppCompatTextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_item_info_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews(){
        infoPerson = requireView().findViewById(R.id.info_person)
        button = requireView().findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(requireContext(), IntroActivity::class.java)
            startActivity(intent)
        }

    }
}