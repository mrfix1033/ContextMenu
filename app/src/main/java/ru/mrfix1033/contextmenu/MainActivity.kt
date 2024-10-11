package ru.mrfix1033.contextmenu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.mrfix1033.contextmenu.managers.ButtonClick
import ru.mrfix1033.contextmenu.managers.ContextMenus
import ru.mrfix1033.contextmenu.managers.Views

class MainActivity : AppCompatActivity() {

    lateinit var views: Views
    private lateinit var contextMenus: ContextMenus
    var editTextIsGenerated: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        views = Views(this)
        ButtonClick(this)
        contextMenus = ContextMenus(this)
        registerForContextMenu(views.editText)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        contextMenus.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem) = contextMenus.onContextItemSelected(item)
}
