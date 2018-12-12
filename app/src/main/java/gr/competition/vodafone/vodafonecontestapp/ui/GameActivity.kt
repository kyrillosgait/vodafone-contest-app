package gr.competition.vodafone.vodafonecontestapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gr.competition.vodafone.vodafonecontestapp.R
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    var selectedBox: Int = 0
    var boxes = mutableSetOf(1, 2, 3, 4, 5, 6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        firstBox.setOnClickListener { selectBox(1) }
        secondBox.setOnClickListener { selectBox(2) }
        thirdBox.setOnClickListener { selectBox(3) }
        fourthBox.setOnClickListener { selectBox(4) }
        fifthBox.setOnClickListener { selectBox(5) }
        sixthBox.setOnClickListener { selectBox(6) }
    }

    private fun selectBox(boxNumber: Int) {
        if (boxes.size == 6) {
            selectedBox = boxNumber
            boxes.remove(boxNumber)
            when (boxNumber) {
                1 -> firstBox.isEnabled = false
                2 -> secondBox.isEnabled = false
                3 -> thirdBox.isEnabled = false
                4 -> fourthBox.isEnabled = false
                5 -> fifthBox.isEnabled = false
                6 -> sixthBox.isEnabled = false
            }

        } else {

        }
    }


}


