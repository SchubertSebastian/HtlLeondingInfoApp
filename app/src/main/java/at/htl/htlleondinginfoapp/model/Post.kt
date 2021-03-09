package at.htl.htlleondinginfoapp.model




data class Post
    (
    val id: Long,
    val date: String,
    val title: Title,
    val link: String,
    var _embedded: FeatureMedia
    )