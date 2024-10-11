package ru.mrfix1033.contextmenu.managers

import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import ru.mrfix1033.contextmenu.R

class Views(app: AppCompatActivity) {
    var editText: EditText

    init {
        app.run {
            editText = findViewById(R.id.editText)
        }
    }
}