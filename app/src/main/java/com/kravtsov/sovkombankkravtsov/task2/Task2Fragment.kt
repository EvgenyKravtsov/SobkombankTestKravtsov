package com.kravtsov.sovkombankkravtsov.task2

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kravtsov.sovkombankkravtsov.R
import kotlinx.android.synthetic.main.fragment_task2.*

class Task2Fragment : Fragment(), Task2View {

    private lateinit var presenter: Task2Presenter

    private val dialogFragment = Task2DialogFragment()

    //// FRAGMENT

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_task2, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter = Task2Presenter()
        presenter.attachView(this)
        setupStartTimerButton()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    //// TASK 2 VIEW

    override fun displayTimerFinished() {
        if (!dialogFragment.isVisible) {
            dialogFragment.show(fragmentManager, Task2DialogFragment::class.java.simpleName)
        }
    }

    ////

    private fun setupStartTimerButton() {
        startTimerButton.setOnClickListener { presenter.startTimerClicked() }
    }
}