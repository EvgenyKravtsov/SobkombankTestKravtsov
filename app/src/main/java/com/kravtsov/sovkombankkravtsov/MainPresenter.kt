package com.kravtsov.sovkombankkravtsov

class MainPresenter : MvpPresenter<MainView>() {

    fun task1Clicked() {
        view?.navigateToTask1()
    }

    fun task2Clicked() {
        view?.navigateToTask2()
    }

    fun task3Clicked() {
        view?.navigateToTask3()
    }
}