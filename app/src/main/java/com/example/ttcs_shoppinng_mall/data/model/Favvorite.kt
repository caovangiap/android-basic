package com.example.ttcs_shoppinng_mall.data.model

class Favvorite ( val product_id: String,
                  val product_name: String,
                  val product_price: Float,
                  val product_size: String,
    // tình trạng còn hàng hay k
                  val product_condition: Boolean,
                  val product_type: String,
                  val product_color: Int,
                  val product_image: Int)
