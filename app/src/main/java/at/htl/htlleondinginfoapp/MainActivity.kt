package at.htl.htlleondinginfoapp

import android.database.DefaultDatabaseErrorHandler
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Script
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import at.htl.htlleondinginfoapp.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.math.log

class MainActivity : AppCompatActivity()
{
    private val viewModel: PostViewModel by viewModels();

    //TODO: Fragmente erstellen;
    //TODO: Web View verwenden;
    //TODO: excerpt eventiuell;
    //TODO: Detail View;
    //TODO: Navgraf erstellen;
    //TODO: Aktualiesierungs Menu Punkt
    //     ;)


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        val binding = DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main);

        binding.rvPosts.layoutManager = LinearLayoutManager(this);
        binding.rvPosts.adapter = PostAdapter(viewModel.posts);

        viewModel.posts.observeForever{
            binding.rvPosts.adapter?.notifyDataSetChanged();
        }

        viewModel.posts;




    }
}