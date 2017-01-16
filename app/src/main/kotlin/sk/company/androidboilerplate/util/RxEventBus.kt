package sk.company.androidboilerplate.util

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * A simple event bus built with RxJava2
 */

@Singleton
class RxEventBus
@Inject
internal constructor() {

    private var mBusSubject = PublishSubject.create<Any>()

    /**
     * Posts an object (usually an Event) to the bus
     */
    fun post(event: Any) {
        mBusSubject.onNext(event)
    }

    /**
     * Observable that will emmit everything posted to the event bus.
     */
    fun observable(): Observable<Any> {
        return mBusSubject
    }

    /**
     * Observable that only emits events of a specific class.
     * Use this if you only want to subscribe to one type of events.
     */

    fun <T> filteredObservable(eventClass: Class<T>): Observable<T> {
        return mBusSubject.ofType(eventClass)
    }
}
