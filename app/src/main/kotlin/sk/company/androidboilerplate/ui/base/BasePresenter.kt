package sk.company.androidboilerplate.ui.base

import sk.creanet.alexander.ui.base.MvpView
import sk.creanet.alexander.ui.base.Presenter
import java.lang.ref.WeakReference


/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
open class BasePresenter<T : MvpView> : Presenter<T> {

    var mMvpView: WeakReference<T>? = null

    override fun attachView(mvpView: T) {
        mMvpView = WeakReference(mvpView)
    }

    override fun detachView(retainInstance: Boolean) {
        if (mMvpView != null) {
            mMvpView!!.clear()
            mMvpView = null
        }
    }

    protected val isViewAttached: Boolean
        get() = mMvpView != null && mMvpView!!.get() != null

    val mvpView: T?
        get() = if (mMvpView == null) null else mMvpView!!.get()

    protected fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    private class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")
}

