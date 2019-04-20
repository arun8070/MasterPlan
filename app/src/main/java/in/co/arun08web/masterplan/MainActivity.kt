package `in`.co.arun08web.masterplan

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
    *
    *  1 Means On Going Recycler view
    *  2 Means Coming Soon Recycler view
    *  3 Means Completed Recycler view
    *
     */

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_on_going -> {
                rec_view.adapter = RecyclerAdapter(1, this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_coming_soon -> {
                rec_view.adapter = RecyclerAdapter(2, this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_completed -> {
                rec_view.adapter = RecyclerAdapter(3, this)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayoutManager = LinearLayoutManager(this@MainActivity)
        rec_view.layoutManager = linearLayoutManager


        // Default is 1
        rec_view.adapter = RecyclerAdapter(1, this)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.add_to_database -> {
                startActivity(Intent(this@MainActivity, AddToDatabase::class.java))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
