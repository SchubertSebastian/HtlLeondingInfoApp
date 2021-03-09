package at.htl.htlleondinginfoapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import at.htl.htlleondinginfoapp.model.Post
import at.htl.htlleondinginfoapp.service.WordpressApi
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>();

    public val posts: LiveData<List<Post>>
        get() = _posts;


    var currentPost: Post? = null

    init {
        refresh();
    }

    public fun refresh() {
        viewModelScope.launch {
            val result = WordpressApi.retrofitService.getPosts("2021-02-01T00:00:00", "wp:featuredmedia")
            _posts.value = result.toList()
        }
    }


}