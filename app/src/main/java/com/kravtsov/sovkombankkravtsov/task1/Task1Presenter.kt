package com.kravtsov.sovkombankkravtsov.task1

import com.kravtsov.sovkombankkravtsov.MvpPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

class Task1Presenter : MvpPresenter<Task1View>() {

    private val text =
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих." +
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих. " +
            "Каждый наш поступок продолжает создавать нас самих."

    ////

    init {
        Observable.fromIterable(text.toCharArray().asIterable())
                .delay(1, TimeUnit.SECONDS)
                .map { char -> char.toString() }
                .zipWith(
                        Observable.interval(50, TimeUnit.MILLISECONDS),
                        BiFunction { text: String, _: Long ->  text }
                )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { text -> view?.displayTextAppended(text) }
    }
}