package com.sekai.conceitosdenavegao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_layout.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity(), ContactItemClickListener {
    private val rv_list : RecyclerView by lazy{
        rv_list_item_list
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_layout)

        bindView()
        initDrawer()
    }

    private fun bindView() {
       val adapter = ContactAdapter(this)
        adapter.updateList(
            arrayListOf(
                Contact(
                "felipe",
                "(83)98165-8791",
                "img"
            ),Contact(
                "jose",
                "(83)98165-8791",
                "img"
            ),Contact(
                "maria",
                "(83)98165-8791",
                "img"
            ),
            )
        )

        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = adapter
    }
// menuInflater
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       val inflater = menuInflater
       inflater.inflate(R.menu.menu, menu)
        return true
    }
//menu click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            //R.id.item1 ->{}
            else-> {super.onOptionsItemSelected(item)}
        }

    }

    //drawer navigation
   fun initDrawer(){
        val drawerLayout = drawer_nav_layout
        val toolbar = toolbar_app
       setSupportActionBar(toolbar)
        //toogle this, layout, toolbar e dois arquivos de string abrir e fechar
       val toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar,
           R.string.open_drawer,
           R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun contactItemClickListener(contato: Contact) {
        startActivity(Intent (this, ContactDetail::class.java))
    }

}