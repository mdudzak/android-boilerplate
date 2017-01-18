package sk.company.androidboilerplate.ui.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import sk.company.androidboilerplate.data.DataManager
import sk.company.androidboilerplate.ui.base.BasePresenter
import timber.log.Timber
import javax.inject.Inject

class MainPresenter @Inject constructor(private val dataManager: DataManager) : BasePresenter<MainMvpView>() {

    var mSubscriptions : CompositeDisposable? = null

    init {
        mSubscriptions = CompositeDisposable()
    }

    fun disko() {
        mSubscriptions?.add(dataManager.getCharacters()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    character -> Timber.d("%s", character)
                }, {
                    error -> Timber.e("%s", error)
                })
        )
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        mSubscriptions?.clear()
    }
}
