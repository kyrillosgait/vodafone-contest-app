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
            gifts.add(Gift(1, "fun", 1, "1+1 Skydive", "https://www.vodafonecu.gr/cu-around/offer/skydive-athens"))
            gifts.add(Gift(2, "fun", 1, "1+1 EXIT NOW", "https://www.vodafonecu.gr/cu-around/offer/exit-now"))
            gifts.add(Gift(3, "fun", 1, "1+1 Adventure Rooms", "https://www.vodafonecu.gr/cu-around/offer/adventure-rooms"))
            gifts.add(Gift(4, "food", 2, "1+1 Simply Burgers", "https://thankyou.vodafone.gr/offer/46"))
            gifts.add(Gift(5, "food", 2, "1+1 Mikel Coffee", "https://thankyou.vodafone.gr/offer/152"))
            gifts.add(Gift(6, "food", 2, "1+1 Dominos Pizza", "https://thankyou.vodafone.gr/offer/48"))
            gifts.add(Gift(7, "shopping", 3, "15% έκπτωση Adidas", "https://www.vodafonecu.gr/cu-around/offer/adidas"))
            gifts.add(Gift(8, "shopping", 3, "15% έκπτωση Funky Buddha", "https://www.vodafonecu.gr/cu-around/offer/funky-buddha"))
            gifts.add(Gift(9, "shopping", 3, "15% έκπτωση Forever 21", "https://www.vodafonecu.gr/cu-around/offer/forever21"))
            gifts.add(Gift(10, "data", 4, "500 MB", "https://www.vodafone.gr"))
            gifts.add(Gift(11, "data", 4, "1 GB", "https://www.vodafone.gr"))
            gifts.add(Gift(12, "data", 4, "2 GB", "https://www.vodafone.gr"))
            gifts.add(Gift(13, "trip", 5, "1+1 Μπαλί", "https://www.vodafonecu.gr/cu-around/offer/travel-and-more-bali"))
            db.giftDao().insertGifts(gifts)
        }

    }

}