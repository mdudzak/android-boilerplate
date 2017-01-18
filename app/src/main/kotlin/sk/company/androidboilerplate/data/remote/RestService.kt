package sk.company.androidboilerplate.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import sk.company.androidboilerplate.data.local.PreferencesHelper
import sk.company.androidboilerplate.data.model.PeopleObject

interface NetworkService {
    @GET("people")
    fun getCharacters() : Flowable<PeopleObject>

    companion object Builder {
        private val ENDPOINT = "http://swapi.co/api/"

        fun createDebugOkHttpClient(preferencesHelper: PreferencesHelper): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    //STETHO
                    //.addNetworkInterceptor(StethoInterceptor())
                    .addInterceptor { chain ->
                        val original = chain.request()

                        val request = original.newBuilder()
                                //.header("token", token)
                                .method(original.method(), original.body())
                                .build()

                        chain.proceed(request)
                    }
                    .build()
        }

        fun newNetworkService(helper: PreferencesHelper): NetworkService {

            val retrofit = Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .client(createDebugOkHttpClient(helper))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()

            return retrofit.create(NetworkService::class.java)
        }
    }
}
