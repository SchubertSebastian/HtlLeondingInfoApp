package at.htl.htlleondinginfoapp.model

import com.squareup.moshi.Json

data class FeatureMedia(@Json(name = "wp:featuredmedia") val media: List<Media>)