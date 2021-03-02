package at.htl.htlleondinginfoapp

import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView


class PostAdapter(private val posts: LiveData<List<Post>>) : RecyclerView.Adapter<PostAdapter.ViewHolder>()
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
        val post = posts.value?.get(position);

        with(holder.view) {
            findViewById<TextView>(R.id.tvTitle).text = post?.title.toString();
            findViewById<TextView>(R.id.tvDate).text = post?.date.toString();

            //val download =
        }
    }

    override fun getItemCount(): Int = if (posts.value == null)
    {
        0;
    } else {
        posts.value!!.size;
    }
}