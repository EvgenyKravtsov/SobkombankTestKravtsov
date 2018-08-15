package com.kravtsov.sovkombankkravtsov.task1

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.kravtsov.sovkombankkravtsov.R
import kotlinx.android.synthetic.main.fragment_task1.*

class Task1Fragment : Fragment(), Task1View {

    lateinit var presenter: Task1Presenter

    //// FRAGMENT

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_task1, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter = Task1Presenter()
        presenter.attachView(this)
        setupTextViews()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    //// TASK 1 VIEW

    override fun displayTextAppended(appendedText: String) {
        textView1.append(appendedText)

        val text1Weight: Float = textView2.text.length.toFloat()
        val text2Weight: Float = textView1.text.length.toFloat()

        textView1.layoutParams =
                LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        text1Weight
                )

        textView2.layoutParams =
                LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        text2Weight
                )
    }

    ////

    private fun setupTextViews() {
        val text1Weight: Float = textView2.text.length.toFloat()
        val text2Weight: Float = textView1.text.length.toFloat()

        textView1.layoutParams =
                LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        text1Weight
                )

        textView2.layoutParams =
                LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        text2Weight
                )
    }
}

















