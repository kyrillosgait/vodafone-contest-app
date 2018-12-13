package gr.competition.vodafone.vodafonecontestapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
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
        //        private val lock = Any()
        private const val DATABASE_NAME = "App.db"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = createInstance(context)
                }
                return INSTANCE!!
            }
        }

        private fun createInstance(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                )
                        .allowMainThreadQueries()
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Thread(Runnable { prepopulateDb(getInstance(context)) }).start()
                            }
                        })
                        .build()

        private fun prepopulateDb(db: AppDatabase) {
            var gifts = mutableListOf<Gift>()
            gifts.add(Gift(1, "fun", 1, "1+1 Skydive", ""))
            gifts.add(Gift(2, "fun", 1, "1+1 EXIT NOW", ""))
            gifts.add(Gift(3, "fun", 1, "1+1 Adventure Rooms", ""))
            gifts.add(Gift(4, "food", 2, "1+1 Simply Burgers", ""))
            gifts.add(Gift(5, "food", 2, "1+1 Mikel Coffee", ""))
            gifts.add(Gift(6, "food", 2, "1+1 Dominos Pizza", ""))
            gifts.add(Gift(7, "shopping", 3, "15% έκπτωση Adidas", ""))
            gifts.add(Gift(8, "shopping", 3, "15% έκπτωση Funky Buddha", ""))
            gifts.add(Gift(9, "shopping", 3, "15% έκπτωση Forever 21", ""))
            gifts.add(Gift(10, "data", 4, "500 MB", ""))
            gifts.add(Gift(11, "data", 4, "1 GB", ""))
            gifts.add(Gift(12, "data", 4, "2 GB", ""))
            gifts.add(Gift(13, "trip", 5, "1+1 Μπαλί", ""))
            db.giftDao().insertGifts(gifts)
        }

    }

}