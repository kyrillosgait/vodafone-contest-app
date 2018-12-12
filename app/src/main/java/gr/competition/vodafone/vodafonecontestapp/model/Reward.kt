package gr.competition.vodafone.vodafonecontestapp.model

import java.util.*

data class Reward(
        val id: Int,
        val giftId: Int,
        var redeemCode: String,
        var redeemUntil: Date
)