package sk.company.androidboilerplate.ui.main

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import sk.company.androidboilerplate.R
import sk.company.androidboilerplate.injection.component.ActivityComponent
import sk.creanet.alexander.ui.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMvpView {

    @Inject lateinit var mPresenter: MainPresenter

    @BindView(R.id.recycler) lateinit var mRecyclerView: RecyclerView

    /*** METHODS ***/
    override fun getLayoutRes(): Int { return R.layout.activity_main }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this)

        disko()
    }

    override fun injectDependencies(activityComponent: ActivityComponent?) {
        activityComponent?.inject(this)
    }

    override fun onDestroy() {
        mPresenter.detachView(false)
        super.onDestroy()
    }

    override fun showLoadingProgress() {
        Timber.d("MVP VIEW")
    }

    fun disko() {
        Timber.d("ACTIVITY")
        mPresenter.disko()
    }
}
