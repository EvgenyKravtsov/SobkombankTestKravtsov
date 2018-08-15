package com.kravtsov.sovkombankkravtsov.task2

import com.kravtsov.sovkombankkravtsov.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Task2Presenter : MvpPresenter<Task2View>() {

    init {
        rxSubscriptions.add(
                Timer.timersSubject
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { view?.displayTimerFinished() }
        )
    }

    ////

    fun startTimerClicked() {
        Timer.start()
    }
}