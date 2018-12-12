package gr.competition.vodafone.vodafonecontestapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gr.competition.vodafone.vodafonecontestapp.R

const val TOTAL_TRIES: String = "TOTAL_TRIES"

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }



}
