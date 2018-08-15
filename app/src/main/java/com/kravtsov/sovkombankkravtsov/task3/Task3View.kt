package com.kravtsov.sovkombankkravtsov.task3

import com.kravtsov.sovkombankkravtsov.MvpView

interface Task3View : MvpView {

    fun displaySubmitEnabled()

    fun displaySubmitDisabled()

    fun displayText(text: String)
}