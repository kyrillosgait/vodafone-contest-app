package gr.competition.vodafone.vodafonecontestapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Reward(
        @PrimaryKey(autoGenerate = true) val id: Int,
        val giftId: Int,
        var redeemCode: String,
        var redeemUntil: Date
)