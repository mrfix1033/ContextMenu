package ru.mrfix1033.contextmenu

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.pow
import kotlin.math.pow
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
//    companion object {
//        const val ITEM_ON = 111
//        const val ITEM_OFF = 112
//    }

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        registerForContextMenu(editText)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
//        menu?.add(Menu.NONE, ITEM_ON, Menu.NONE, "Удалить данные")
//        menu?.add(Menu.NONE, ITEM_OFF, Menu.NONE, "Выйти")
        menuInflater.inflate(R.menu.menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        lateinit var message: String
        when (item.itemId) {
//            ITEM_ON -> {
//                message = "Текст очищен"
//                editText.text.clear()
//            }
//
//            ITEM_OFF -> {
//                message = "Выход..."
//                finish()
//            }
            R.id.menu_change_color -> {
                message = "Цвет изменён"
                editText.setBackgroundColor(Color.rgb(Random.nextInt(0, 256), Random.nextInt(0, 256), Random.nextInt(0, 256)))
            }

            R.id.menu_change_font_size -> {
                message = "Размер шрифта изменён"
                editText.textSize = Random.nextInt(10, 20).toFloat()
            }

            else -> return super.onContextItemSelected(item)
        }
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        return true
    }
}
