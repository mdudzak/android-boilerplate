package sk.company.androidboilerplate.data.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel data class PeopleObject (
        val count: Int?,
        val next: String?,
        val previous: String?,
        val results: List<Character>
) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelPeopleObject.CREATOR
    }
}
