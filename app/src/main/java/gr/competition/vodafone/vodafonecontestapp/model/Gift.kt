package gr.competition.vodafone.vodafonecontestapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gift(
        @PrimaryKey(autoGenerate = true) val giftId: Int,
        val category: String,
        val categoryId: Int,
        val name: String,
        val url: String
)