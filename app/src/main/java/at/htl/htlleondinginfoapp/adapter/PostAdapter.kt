package at.htl.htlleondinginfoapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import at.htl.htlleondinginfoapp.R
import at.htl.htlleondinginfoapp.viewmodel.PostViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat

class PostAdapter(private val postViewModel: PostViewModel) : RecyclerView.Adapter<PostAdapter.ViewHolder>()
{
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view);

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.posts_card,parent,false);

        //val viewHolder = ;

        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val post = postViewModel.posts.value?.get(position);

        if (post != null) {

            with(holder.view) {
                val tvContent = findViewById<TextView>(R.id.tvContent)
                val fromDateFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss")
                val toDateFormat = SimpleDateFormat("dd.MM.yyyy")
                val fromDate = fromDateFormat.parse(post.date)
                val toDate = toDateFormat.format(fromDate)
                tvContent.text = "${post.title.rendered} ${toDate}"

                val media = post._embedded.media
                if (media.isNotEmpty()) {
                    val firstInformation = media.get(0)

                    Log.d("ooo", firstInformation.media_details.sizes.thumbnail.source_url)
                    bindImage(
                        findViewById(R.id.imageView),
                        firstInformation.media_details.sizes.thumbnail.source_url
                    )
                }

                setOnClickListener {
                    postViewModel.currentPost = post
                    it.findNavController()
                        .navigate(R.id.action_postListFragment_to_postDetailFragment)
                }
            }

        }
    }

    override fun getItemCount(): Int = if (postViewModel.posts.value == null)
    {
        0;
    } else {
        postViewModel.posts.value!!.size;
    }

    private fun bindImage(imageView: ImageView, url: String) {
        val imgUri = url.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imageView)
    }
}