package sk.company.androidboilerplate.data.model

import com.squareup.moshi.Json
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel data class Character (
        val name: String?,
        val height: String?,
        val mass: String?,
        @Json(name = "hair_color") val hairColor: String?,
        @Json(name = "skin_color") val skinColor: String?,
        @Json(name = "eye_color") val eyeColor: String?,
        @Json(name = "birth_year") val birthYear: String?,
        val gender: String?,
        val homeworld: String?,
        val films: List<String>?,
        val species: List<String>?,
        val vehicles: List<String>?,
        val starships: List<String>?,
        val created: String?,
        val edited: String?,
        val url: String?
) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelCharacter.CREATOR
    }
}