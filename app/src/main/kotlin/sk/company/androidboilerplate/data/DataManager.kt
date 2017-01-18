package sk.company.androidboilerplate.data

import io.reactivex.Flowable
import sk.company.androidboilerplate.data.local.PreferencesHelper
import sk.company.androidboilerplate.data.model.Character
import sk.company.androidboilerplate.data.remote.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class DataManager @Inject constructor(val networkService: NetworkService, val preferencesHelper: PreferencesHelper) {
    fun getCharacters() : Flowable<List<Character>> {
        return networkService.getCharacters().flatMap { it -> Flowable.just(it.results) }
    }
}
