package gr.competition.vodafone.vodafonecontestapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import gr.competition.vodafone.vodafonecontestapp.R
import gr.competition.vodafone.vodafonecontestapp.db.AppDatabase
import gr.competition.vodafone.vodafonecontestapp.db.GiftDao
import gr.competition.vodafone.vodafonecontestapp.model.Box
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var selectedBox: Int = 0
    private var boxes = mutableSetOf(1, 2, 3, 4, 5, 6)
    private lateinit var giftDao: GiftDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        giftDao = AppDatabase.getInstance(this).giftDao()
//        database = AppDatabase.getInstance(this)

        selectRandomGifts()

        firstBox.setOnClickListener { onBoxClicked(1) }
        secondBox.setOnClickListener { onBoxClicked(2) }
        thirdBox.setOnClickListener { onBoxClicked(3) }
        fourthBox.setOnClickListener { onBoxClicked(4) }
        fifthBox.setOnClickListener { onBoxClicked(5) }
        sixthBox.setOnClickListener { onBoxClicked(6) }
    }

    private fun selectRandomGifts() {

        var boxesSet = boxes
        var boxesList = mutableListOf<Box>()

        // Add boxes
        for (i in 1..6) {
            val box = Box(i)
            boxesList.add(box)
        }

        // Assign gifts to 4 random out of 6 boxes
        for (i in 1..4) {
            val randomBox = boxesSet.random()
            for (box in boxesList) {
                if (box.id == randomBox) {
                    box.name = giftDao.selectRandomGiftFromCategory(i)
                }
            }
            boxesSet.remove(randomBox)
        }
    }

    private fun onBoxClicked(boxNumber: Int) {
        if (selectedBox == 0) {
            selectedBox = boxNumber
            boxes.remove(boxNumber)
            disableBox(boxNumber)

            for (box in boxes) {
                changeBoxNumberTitleToQuestionMark(box)
            }

        } else {

        }
    }

    private fun changeBoxNumberTitleToQuestionMark(box: Int) {
        when (box) {
            1 -> firstBox.text = "?"
            2 -> secondBox.text = "?"
            3 -> thirdBox.text = "?"
            4 -> fourthBox.text = "?"
            5 -> fifthBox.text = "?"
            6 -> sixthBox.text = "?"
        }
    }

    private fun disableBox(boxNumber: Int) {
        when (boxNumber) {
            1 -> firstBox.isEnabled = false
            2 -> secondBox.isEnabled = false
            3 -> thirdBox.isEnabled = false
            4 -> fourthBox.isEnabled = false
            5 -> fifthBox.isEnabled = false
            6 -> sixthBox.isEnabled = false
        }
    }


}


