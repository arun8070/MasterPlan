package `in`.co.arun08web.masterplan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_to_database.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class AddToDatabase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_database)

        add_btn.setOnClickListener {
            val headerTxt = header_edt.text.toString()
            val descTxt = desc_edt.text.toString()
            val tsTxt = ts_edt.text.toString()

            if (headerTxt != "") {
                if (descTxt != "") {
                    if (tsTxt != "") {
                        saveToDatabase(headerTxt, descTxt, tsTxt)
                    } else {
                        showToast("please enter time")
                    }
                } else {
                    showToast("please enter plan description text")
                }
            } else {
                showToast("please enter plan tittle text")
            }
        }
    }

    private fun  saveToDatabase(header: String, desc: String, ts: String) {
        doAsync {
            val arun = Arun(header, desc, ts)
            AppDatabase.getInstance(this@AddToDatabase).arunDoa().insert(arun)

            doAsync {
                val aruns = AppDatabase.getInstance(this@AddToDatabase).arunDoa().all

                uiThread {
                    for (s in aruns)
                        Log.d("data_test", s.header)
                }
            }

            finish()
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}
