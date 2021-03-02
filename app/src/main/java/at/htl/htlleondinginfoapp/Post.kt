package at.htl.htlleondinginfoapp

data class Post
    (
    val id: Long,
    val date: String,
    val title: Rendered,
    val link: String
    )