package at.htl.htlleondinginfoapp.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.activityViewModels
import at.htl.htlleondinginfoapp.viewmodel.PostViewModel
import at.htl.htlleondinginfoapp.R

class PostDetailFragment : Fragment(R.layout.fragment_post_detail) {
    private val viewModel: PostViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.web_view)
        webView.loadUrl(viewModel.currentPost!!.link)
    }

}