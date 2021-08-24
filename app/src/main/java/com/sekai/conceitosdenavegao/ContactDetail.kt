package com.sekai.conceitosdenavegao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_contact_detail.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class ContactDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        initToolbar()
    }

    private fun initToolbar() {
        val toolbar = include_toolbar as Toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitle("Contato")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


}