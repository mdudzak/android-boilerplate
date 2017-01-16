package sk.company.androidboilerplate.data

import sk.company.androidboilerplate.data.local.PreferencesHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class DataManager @Inject constructor(val preferencesHelper: PreferencesHelper) {

}
