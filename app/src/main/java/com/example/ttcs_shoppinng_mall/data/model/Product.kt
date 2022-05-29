package com.example.ttcs_shoppinng_mall.data.model

import android.os.Parcelable
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import kotlinx.parcelize.Parcelize

@Parcelize
@IgnoreExtraProperties
data class Product(
    var productId: String,
    var product_name: String ,
    var product_price: String,
    var product_size: String ,
    var product_condition: Boolean ,
    var product_type : String ,
    var product_color : Int ,
    var product_image : Int
) : Parcelable{

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "ID" to productId,
            "Name" to product_name,
            "Price" to product_price,
            "Size" to product_size,
            "Condition" to product_condition,
            "Type" to product_type,
            "image" to product_image,
            "color" to product_color
        )
    }
}



