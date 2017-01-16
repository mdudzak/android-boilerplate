package sk.company.androidboilerplate.data.local

import android.content.Context
import android.content.SharedPreferences
import sk.company.androidboilerplate.injection.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesHelper {
    internal var PREF_FILE_NAME = "chatrtv_pref_file"
    private val mPref: SharedPreferences

    @Inject constructor(@ApplicationContext context: Context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun clear() {
        mPref.edit().clear().apply()
    }

}