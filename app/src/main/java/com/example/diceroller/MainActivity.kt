package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        val initialDiceImage: ImageView = findViewById(R.id.imageView)

        initialDiceImage.setImageResource(R.drawable.dice_4)
        rollButton.setOnClickListener{ rolldice() }
    }

    private fun rolldice() {
        val dice = Dice(6)

        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_4
        }
        diceImage.setImageResource(drawableResource)
    }
}
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}