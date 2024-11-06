package com.example.serializableparcelablebookadres

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar
    private lateinit var nameTV: TextView
    private lateinit var familyTV: TextView
    private lateinit var adresTV: TextView
    private lateinit var phoneTV: TextView
    private lateinit var buttonBackBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        var user: Person? = null
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarMain = findViewById(R.id.toolbarMain)
        nameTV = findViewById(R.id.nameTV)
        familyTV = findViewById(R.id.familyTV)
        adresTV = findViewById(R.id.adresTV)
        phoneTV = findViewById(R.id.phoneTV)
        buttonBackBTN = findViewById(R.id.buttonBackBTN)

        setSupportActionBar(toolbarMain)
        title = "Книга адресов"
        toolbarMain.subtitle = "by Rocky"

        user = intent.extras?.getParcelable(Person::class.java.simpleName) as Person?
        val name = user?.name.toString()
        val family = user?.family.toString()
        val adres = user?.adres.toString()
        val phone = user?.phone.toString()

        nameTV.text = name
        familyTV.text = family
        adresTV.text = adres
        phoneTV.text = phone

        buttonBackBTN.setOnClickListener { view ->
            finish()
        }
    }
}