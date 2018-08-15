package com.kravtsov.sovkombankkravtsov.task2

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kravtsov.sovkombankkravtsov.R
import kotlinx.android.synthetic.main.dialog_fragment_task2.*

class Task2DialogFragment : DialogFragment() {

    //// DIALOG FRAGMENT

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.dialog_fragment_task2, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupOkButton()
    }

    ////

    private fun setupOkButton() {
        okButton.setOnClickListener { dismiss() }
    }
}