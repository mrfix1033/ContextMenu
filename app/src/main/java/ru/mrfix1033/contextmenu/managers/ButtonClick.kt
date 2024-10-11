package ru.mrfix1033.contextmenu.managers

import android.widget.Button
import android.widget.Toast
import ru.mrfix1033.contextmenu.MainActivity
import ru.mrfix1033.contextmenu.R
import kotlin.random.Random

class ButtonClick(app: MainActivity) {

    init {
        app.run {
            findViewById<Button>(R.id.buttonGenerateNumber).setOnClickListener {
                editTextIsGenerated = true
                views.editText.setText(Random.nextInt(1, 50).toString())
                Toast.makeText(
                    applicationContext,
                    R.string.number_generated_label,
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}