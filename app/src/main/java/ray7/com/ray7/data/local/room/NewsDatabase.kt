package ray7.com.ray7.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ray7.com.ray7.data.models.Articles


@Database(entities = arrayOf(Articles::class), version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticlesDao
}