package gr.competition.vodafone.vodafonecontestapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gift(
        @PrimaryKey(autoGenerate = true) val id: Int,
        val category: String,
        val name: String,
        val value: Int,
        val url: String
)