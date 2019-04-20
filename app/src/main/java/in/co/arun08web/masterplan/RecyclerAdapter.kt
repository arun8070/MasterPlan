package `in`.co.arun08web.masterplan

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecyclerAdapter(internal var itemSize:Int,private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rec_child, p0, false))
    }

    override fun getItemCount(): Int {
        return itemSize
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_txt = itemView.findViewById(R.id.img_txt) as TextView
        val header_txt = itemView.findViewById(R.id.header_txt) as TextView
        val desc_txt = itemView.findViewById(R.id.desc_txt) as TextView
    }
}