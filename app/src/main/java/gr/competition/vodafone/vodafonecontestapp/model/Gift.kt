package gr.competition.vodafone.vodafonecontestapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gift(
        @PrimaryKey val id: Int,
        val category: String,
        val categoryId: Int,
        val name: String,
        val url: String
)