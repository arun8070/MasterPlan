package `in`.co.arun08web.masterplan

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ArunDao {

    @get:Query("SELECT * FROM arun")
    val all: List<Arun>

    @Insert
    fun insertAll(aruns: List<Arun>)

    @Insert
    fun insert(arun: Arun)

    @Delete
    fun delete(arun: Arun)
}