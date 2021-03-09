package at.htl.htlleondinginfoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import at.htl.htlleondinginfoapp.adapter.PostAdapter
import at.htl.htlleondinginfoapp.databinding.ActivityMainBinding
import at.htl.htlleondinginfoapp.viewmodel.PostViewModel

class MainActivity : AppCompatActivity()
{
    private val viewModel: PostViewModel by viewModels();

    //TODO: Aktualiesierungs Menu Punkt
    //     ;)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.refresh -> {
                viewModel.refresh();
            }
        }

        return super.onOptionsItemSelected(item)
    }
}