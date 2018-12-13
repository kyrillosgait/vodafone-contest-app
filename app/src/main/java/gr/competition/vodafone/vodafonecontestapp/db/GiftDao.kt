package gr.competition.vodafone.vodafonecontestapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gr.competition.vodafone.vodafonecontestapp.model.Gift

@Dao
interface GiftDao {

    @Query("SELECT name FROM Gift WHERE category = :categoryId ORDER BY RANDOM() LIMIT 1")
    fun selectRandoGiftFromCategory(categoryId: Int): String

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGifts(gifts: List<Gift>)

}