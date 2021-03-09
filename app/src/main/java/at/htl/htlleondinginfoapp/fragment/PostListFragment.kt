package at.htl.htlleondinginfoapp.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.htl.htlleondinginfoapp.R
import at.htl.htlleondinginfoapp.adapter.PostAdapter
import at.htl.htlleondinginfoapp.viewmodel.PostViewModel

class PostListFragment : Fragment(R.layout.fragment_post_list) {
    private val viewModel: PostViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val posts = view.findViewById<RecyclerView>(R.id.rvPosts)

        viewModel.posts.observeForever {
            posts.layoutManager = LinearLayoutManager(context)
            posts.adapter = PostAdapter(viewModel)
            posts.adapter!!.notifyDataSetChanged()
        }
    }
}