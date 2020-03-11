package com.jsw.marvelheroes.Interfaces

interface IHomePresenter {
    interface Presenter : IPresenter.Presenter
    interface View : IPresenter.View<Presenter>
}