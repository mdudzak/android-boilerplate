package sk.company.androidboilerplate.data.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel data class SimpleModel (
        val info: String?,
        val after: String?,
        val before: String?
) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelSimpleModel.CREATOR
    }
}
