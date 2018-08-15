package com.kravtsov.sovkombankkravtsov.task3

import android.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kravtsov.sovkombankkravtsov.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_task3.*

class Task3Fragment : Fragment(), Task3View {

    private lateinit var presenter: Task3Presenter

    //// FRAGMENT

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_task3, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter = Task3Presenter()
        presenter.attachView(this)
        setupEditText()
        setupSubmitButton()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    //// TASK 3 VIEW

    override fun displaySubmitEnabled() {
        submitButton.isEnabled = true
    }

    override fun displaySubmitDisabled() {
        submitButton.isEnabled = false
    }

    override fun displayText(text: String) {
        textView.text = ""
        textView.text = text
    }

    ////

    private fun setupEditText() {
        presenter.textChanged(editText.text.toString())
        Observable.create<String> { subscriber ->
            editText.addTextChangedListener(
                    object : TextWatcher {
                        override fun afterTextChanged(s: Editable?) {}

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                            subscriber.onNext(s.toString())
                        }
                    }
            )
        }.subscribe { text -> presenter.textChanged(text) }
    }

    private fun setupSubmitButton() {
        submitButton.setOnClickListener { presenter.submitClicked() }
    }
}









