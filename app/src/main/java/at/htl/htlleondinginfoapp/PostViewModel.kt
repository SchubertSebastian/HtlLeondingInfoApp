package at.htl.htlleondinginfoapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>();

    public val posts: LiveData<List<Post>>
        get() {
            return _posts;
        }

    init {
        getPosts();
    }

    private fun getPosts() {
        viewModelScope.launch {
            try {
                val result = WordpressApi.retrofitService.getPosts("2021-02-01T00:00:00");

                _posts.value = result.toList();

                Log.d("Posts: ", result.size.toString());
            } catch (e: Exception) {
                Log.d("Posts: ", e.toString());
            }

        }
    }
}