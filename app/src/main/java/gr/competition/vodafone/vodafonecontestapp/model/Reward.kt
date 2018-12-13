package gr.competition.vodafone.vodafonecontestapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Reward(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @Embedded val gift: Gift,
        var redeemCode: String,
        var redeemUntil: Date
)