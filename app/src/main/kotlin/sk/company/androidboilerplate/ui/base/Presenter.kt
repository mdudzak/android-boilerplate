package sk.creanet.alexander.ui.base

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
internal interface Presenter<in V : MvpView> {
    fun attachView(mvpView: V)
    fun detachView(retainInstance: Boolean)
}