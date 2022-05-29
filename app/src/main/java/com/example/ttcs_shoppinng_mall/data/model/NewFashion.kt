package com.example.ttcs_shoppinng_mall.data.model


import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName


@Parcelize
data class NewFashion(
    @SerializedName("Image")
    val Image: String? = null,
    @SerializedName("Title")
    val Titel: String? = null,
    @SerializedName("URL")
    val URL: String? = null,
) : Parcelable {

    fun NewFashion(){

    }

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Image" to Image,
            "Titel" to Titel,
            "URL" to URL
        )
    }
}
