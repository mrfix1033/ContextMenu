package ru.mrfix1033.contextmenu.managers

import android.graphics.Color
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.mrfix1033.contextmenu.MainActivity
import ru.mrfix1033.contextmenu.R
import ru.mrfix1033.contextmenu.enumeration.COLOR_QUALITY
import ru.mrfix1033.contextmenu.enumeration.EXIT

class ContextMenus(private val app: MainActivity) : AppCompatActivity() {
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        if (v == null) return
        when (v.id) {
            R.id.editText -> {
                menu?.add(
                    Menu.NONE,
                    COLOR_QUALITY,
                    Menu.NONE,
                    R.string.color_quality_action  // вот здесь не удаётся получить ресурс getString(R.string.color_quality_action)
                )
                menu?.add(Menu.NONE, EXIT, Menu.NONE, R.string.exit_action)  // и здесь аналогично
            }

            else -> super.onCreateContextMenu(menu, v, menuInfo)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        app.run {
            when (item.itemId) {
                COLOR_QUALITY -> {
                    val editText = views.editText
                    editText.text.toString().toIntOrNull()?.let {
                        run {
                            if (editTextIsGenerated) {
                                editTextIsGenerated = false
                                when (it) {
                                    in 0..10 -> "#ff0000"
                                    in 11..20 -> "#ffa500"
                                    in 21..30 -> "#ffff00"
                                    in 31..40 -> "#00ff00"
                                    in 41..50 -> "#0000ff"
                                    else -> null
                                }
                            } else when (it) {
                                1 -> "#ffa500"
                                2 -> "#ffff00"
                                3 -> "#00ff00"
                                4 -> "#0000ff"
                                5 -> "#ff0000"
                                else -> null
                            }
                        }?.let(Color::parseColor)
                            ?.let(editText::setBackgroundColor)
                    }
                }

                EXIT -> {
                    finish()
                    Toast.makeText(applicationContext, R.string.exit_label, Toast.LENGTH_SHORT)
                        .show()
                }

                else -> {}
            }
        }
        return super.onContextItemSelected(item)
    }
}