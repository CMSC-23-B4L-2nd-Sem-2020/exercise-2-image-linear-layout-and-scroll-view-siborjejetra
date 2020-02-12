package com.android.example.exer2_sibor_b4l

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var currentImg : ImageView
    lateinit var currentText : TextView
    lateinit var currentCharacter : TextView
    lateinit var currentDescription : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //sets the content in the interface
        setContentView(R.layout.activity_main)

        currentImg = findViewById(R.id.character_image)
        currentText = findViewById(R.id.header)
        currentCharacter = findViewById(R.id.character_name)
        currentDescription = findViewById(R.id.description)

        //calls the proper functions every time a button is clicked
        val startButton: Button = findViewById(R.id.start_button)
        startButton.setOnClickListener { startGame() }

        val retryButton: Button = findViewById(R.id.retry_button)
        retryButton.setOnClickListener { resetGame() }
    }

    private fun startGame() {
        currentText.setText(R.string.start_header)
        val randomInt = (1..11).random()

        //draws the proper image depending on the random character chosen
        val drawableResource = when (randomInt) {
            1 -> R.drawable.ariel
            2 -> R.drawable.aurora
            3 -> R.drawable.belle
            4 -> R.drawable.cinderella
            5 -> R.drawable.elsa
            6 -> R.drawable.jasmine
            7 -> R.drawable.merida
            8 -> R.drawable.mulan
            9 -> R.drawable.pocahontas
            10 -> R.drawable.rapunzel
            else -> R.drawable.snowwhite
        }

        //displays the image
        currentImg.setImageResource(drawableResource)

        //gets the proper character name depending on the random character chosen
        val charResource = when (randomInt) {
            1 -> R.string.ariel_name
            2 -> R.string.aurora_name
            3 -> R.string.belle_name
            4 -> R.string.cinderella_name
            5 -> R.string.elsa_name
            6 -> R.string.jasmine_name
            7 -> R.string.merida_name
            8 -> R.string.mulan_name
            9 -> R.string.pocahontas_name
            10 -> R.string.rapunzel_name
            else -> R.string.snow_white_name
        }

        //displays the name of the character chosen
        currentCharacter.setText(charResource)

        //gets the proper description of the chosen random character
        val stringResource = when (randomInt) {
            1 -> R.string.ariel_char
            2 -> R.string.aurora_char
            3 -> R.string.belle_char
            4 -> R.string.cinderella_char
            5 -> R.string.elsa_char
            6 -> R.string.jasmine_char
            7 -> R.string.merida_char
            8 -> R.string.mulan_char
            9 -> R.string.pocahontas_char
            10 -> R.string.rapunzel_char
            else -> R.string.snow_white_char
        }
        //displays the description of the character
        currentDescription.setText(stringResource)
    }

    //resets the displayed text and image
    private fun resetGame() {
        currentText.setText(R.string.app_header)
        currentImg.setImageResource(R.drawable.disney)
        currentCharacter.setText(null)
        currentDescription.setText(R.string.scroll_view)
    }
}