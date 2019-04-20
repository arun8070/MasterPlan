package `in`.co.arun08web.masterplan

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_on_going -> {
                message.setText(R.string.on_going)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_coming_soon -> {
                message.setText(R.string.coming_soon)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_completed -> {
                message.setText(R.string.completed)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
