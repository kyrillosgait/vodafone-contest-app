package gr.competition.vodafone.vodafonecontestapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gr.competition.vodafone.vodafonecontestapp.model.Reward

@Dao
interface RewardDao {

    @Query("SELECT * FROM reward")
    fun loadAllRewards(): LiveData<List<Reward>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertReward(reward: Reward)

}