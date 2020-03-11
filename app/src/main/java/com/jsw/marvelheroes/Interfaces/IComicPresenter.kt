package com.jsw.marvelheroes.Interfaces

interface IComicPresenter {
    interface Presenter : IPresenter.Presenter
    interface View : IPresenter.View<Presenter>
}