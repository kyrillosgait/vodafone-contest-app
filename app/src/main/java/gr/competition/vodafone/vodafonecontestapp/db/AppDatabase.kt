package gr.competition.vodafone.vodafonecontestapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gr.competition.vodafone.vodafonecontestapp.model.Gift
import gr.competition.vodafone.vodafonecontestapp.model.Reward

@Database(
        entities = [Gift::class, Reward::class],
        version = 1,
        exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun giftDao(): GiftDao
    abstract fun rewardDao(): RewardDao

    companion object {
        private val lock = Any()
        private const val DATABASE_NAME = "App.db"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            DATABASE_NAME
                    )
                            .allowMainThreadQueries()
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}