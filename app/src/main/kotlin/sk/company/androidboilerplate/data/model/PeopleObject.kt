package sk.company.androidboilerplate.data.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel data class PeopleObject (
        val results: List<Character>,
        val count: Int?,
        val next: String?,
        val previous: String?
) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelPeopleObject.CREATOR
    }
}
