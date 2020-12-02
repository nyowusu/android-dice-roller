package com.nbyapps.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.nbyapps.diceroller.utils.DICE_FACES
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById<TextView>(R.id.rolled_value)
        val rollButton: Button = findViewById<Button>(R.id.button_roll)
        val diceFace: ImageView = findViewById<ImageView>(R.id.image_view_dice_face)

        val initialFace = Random.nextInt(1, 7)
        textView.text = initialFace.toString()
        diceFace.setImageResource(DICE_FACES[initialFace])

        rollButton.text = "let's roll!"
        rollButton.setOnClickListener { _ ->
            rollDice(textView, diceFace)
        }
    }

    private fun rollDice(textView: TextView, diceFace: ImageView) {
        val nextNumber = Random.nextInt(1,7)

        textView.text = nextNumber.toString()
        diceFace.setImageResource(DICE_FACES[nextNumber])
    }
}