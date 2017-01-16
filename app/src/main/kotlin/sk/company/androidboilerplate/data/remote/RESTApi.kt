package sk.company.androidboilerplate.data.remote

import io.reactivex.Observable
import retrofit2.http.GET
import sk.company.androidboilerplate.data.model.SimpleModel

interface RESTApi {
    @GET("/api.json")
    fun getAPI() : Observable<SimpleModel>
}
