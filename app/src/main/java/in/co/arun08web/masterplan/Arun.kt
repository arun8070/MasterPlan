package `in`.co.arun08web.masterplan

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Arun constructor(header: String, desc:String, ts: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "header")
    var header: String = header

    @ColumnInfo(name = "desc")
    var desc: String = desc

    @ColumnInfo(name = "ts")
    var ts: String = ts
}