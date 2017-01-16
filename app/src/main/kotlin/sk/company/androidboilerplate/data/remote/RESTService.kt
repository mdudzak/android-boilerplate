package sk.company.androidboilerplate.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Singleton
open class RESTService {
    private val restApi: RESTApi
    private var ENDPOINT: String = "https://www.reddit.com"

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        restApi = retrofit.create(RESTApi::class.java)
    }
}