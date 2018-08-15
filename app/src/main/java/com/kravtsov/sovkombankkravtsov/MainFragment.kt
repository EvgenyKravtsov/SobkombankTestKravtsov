package com.kravtsov.sovkombankkravtsov

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kravtsov.sovkombankkravtsov.task1.Task1Fragment
import com.kravtsov.sovkombankkravtsov.task2.Task2Fragment
import com.kravtsov.sovkombankkravtsov.task3.Task3Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainView {

    private lateinit var presenter: MainPresenter

    //// FRAGMENT

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter = MainPresenter()
        presenter.attachView(this)
        setupButtons()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    //// MAIN VIEW

    override fun navigateToTask1() {
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerFrameLayout, Task1Fragment(), Task1Fragment::class.java.simpleName)
                .addToBackStack(Task1Fragment::class.java.simpleName)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commitAllowingStateLoss()
    }

    override fun navigateToTask2() {
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerFrameLayout, Task2Fragment(), Task2Fragment::class.java.simpleName)
                .addToBackStack(Task2Fragment::class.java.simpleName)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commitAllowingStateLoss()
    }

    override fun navigateToTask3() {
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerFrameLayout, Task3Fragment(), Task3Fragment::class.java.simpleName)
                .addToBackStack(Task3Fragment::class.java.simpleName)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commitAllowingStateLoss()
    }

    ////

    private fun setupButtons() {
        task1Button.setOnClickListener { presenter.task1Clicked() }
        task2Button.setOnClickListener { presenter.task2Clicked() }
        task3Button.setOnClickListener { presenter.task3Clicked() }
    }
}

















