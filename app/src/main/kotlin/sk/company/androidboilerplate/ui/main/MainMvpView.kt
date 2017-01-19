package sk.company.androidboilerplate.ui.main

import sk.company.androidboilerplate.data.model.Character
import sk.creanet.alexander.ui.base.MvpView

interface MainMvpView : MvpView {
    fun showLoadingProgress(show: Boolean)
    fun showCharacters(characterList: List<Character>)
}
