package sk.company.androidboilerplate.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import sk.company.androidboilerplate.R
import sk.company.androidboilerplate.data.model.Character
import sk.company.androidboilerplate.injection.component.ActivityComponent
import sk.company.androidboilerplate.ui.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMvpView {

    @Inject lateinit var mPresenter: MainPresenter
    private val mAdapter : MainAdapter = MainAdapter()

    /*** ACTIVITY METHODS ***/
    override fun getLayoutRes(): Int { return R.layout.activity_main }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = mAdapter

    }

    override fun onStart() {
        super.onStart()
        mPresenter.loadCharacters()
    }

    override fun onDestroy() {
        mPresenter.detachView(false)
        super.onDestroy()
    }

    /**** MVP VIEW METHODS IMPLEMENTATION ****/
    override fun showLoadingProgress(show: Boolean) {
        if (show) {
            progress.visibility = View.VISIBLE
        } else {
            progress.visibility = View.GONE
        }
    }

    override fun injectDependencies(activityComponent: ActivityComponent?) {
        activityComponent?.inject(this)
    }

    override fun showCharacters(characterList: List<Character>) {
        mAdapter.setList(characterList)
    }
}
