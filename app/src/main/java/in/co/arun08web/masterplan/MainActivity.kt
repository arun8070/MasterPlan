package `in`.co.arun08web.masterplan

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_on_going -> {
                rec_view.adapter = RecyclerAdapter(12, this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_coming_soon -> {
                rec_view.adapter = RecyclerAdapter(14, this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_completed -> {
                rec_view.adapter = RecyclerAdapter(15, this)
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
        rec_view.adapter = RecyclerAdapter(3, this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
