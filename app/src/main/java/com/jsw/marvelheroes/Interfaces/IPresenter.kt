package com.jsw.marvelheroes.Interfaces

interface IPresenter {
        interface View<T : Presenter?> {
            fun setPresenter(presenter: T)
        }

        interface Presenter {
            fun start()
            fun stop()
        }
}