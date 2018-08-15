package com.kravtsov.sovkombankkravtsov.task3

import com.kravtsov.sovkombankkravtsov.MvpPresenter

class Task3Presenter : MvpPresenter<Task3View>() {

    private var text: String? = null

    ////

    fun textChanged(text: String) {
        this.text = text

        if (text.length >= 4) {
            view?.displaySubmitEnabled()
        }
        else {
            view?.displaySubmitDisabled()
        }
    }

    fun submitClicked() {
        text?.let { view?.displayText(it) }
    }
}