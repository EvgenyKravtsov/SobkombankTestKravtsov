package com.kravtsov.sovkombankkravtsov.task2

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.concurrent.TimeUnit

class Timer private constructor() {

    private val timerCompletable =
            Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS)
                    .ignoreElements()

    ////

    companion object {

        val timersSubject: Subject<Event> = PublishSubject.create()

        ////

        fun start() {
            val timer = Timer()
            timer.timerCompletable.subscribe { timersSubject.onNext(Event.TIMER_FINISHED) }
        }
    }

    ////

    enum class Event { TIMER_FINISHED }
}