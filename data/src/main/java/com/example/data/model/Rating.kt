package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val Source: String,
    val Value: String
)