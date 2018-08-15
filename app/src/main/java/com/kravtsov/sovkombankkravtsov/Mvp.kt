package com.kravtsov.sovkombankkravtsov

import io.reactivex.disposables.CompositeDisposable

abstract class MvpPresenter<T : MvpView> {

    protected var view: T? = null
    protected val rxSubscriptions = CompositeDisposable()

    ////

    fun attachView(view: T) {
        this.view = view
    }

    fun detachView() {
        this.view = null
        this.rxSubscriptions.clear()
    }
}

////

interface MvpView