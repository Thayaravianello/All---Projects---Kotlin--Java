package com.criattussolution.contactlist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.criattussolution.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val recyclerView = binding.rvContact
        recyclerView.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO

        val adapter = ContactListAdapter()
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)



        //MUDANÃ DO LAYOUT AO CLICAR NO GRID ICON

        val gridIcon = binding.gridIcon
        val listIcon =  binding.listIncon

        gridIcon.setOnClickListener {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        //MUDANÇÃ DO LAYOUT AO CLICAR NO LIST

        listIcon.setOnClickListener {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener{contact->

            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("nome", contact.nome)
            intent.putExtra("telefone", contact.telefone)
            intent.putExtra("imagem", contact.iconeImagem)
            startActivity(intent)


        }
    }


}





val contacts = listOf(
    Contact(
        "Thayara",
        "(55)983456987",
        R.drawable.sample1
    ),
    Contact(
        "Carlos",
        "(55)983456981",
        R.drawable.sample2
    ),
    Contact(
        "Barbara",
        "(55)983456985",
        R.drawable.sample3
    ),
    Contact(
        "Carol",
        "(55)983456984",
        R.drawable.sample4
    ),
    Contact(
        "Michele",
        "(55)983456983",
        R.drawable.sample5
    ),
    Contact(
        "Paola",
        "(55)983456988",
        R.drawable.sample6
    ),
    Contact(
        "Meire",
        "(55)983456955",
        R.drawable.sample7
    ),
    Contact(
        "Nicholas",
        "(55)983456966",
        R.drawable.sample8
    ),
    Contact(
        "Bruno",
        "(55)983456985",
        R.drawable.sample9
    ),
    Contact(
        "Fernando",
        "(55)983456996",
        R.drawable.sample10
    ),
    Contact(
        "Fernanda",
        "(55)983456981",
        R.drawable.sample11
    ),
    Contact(
        "Felipe",
        "(55)983456964",
        R.drawable.sample12
    ),
    Contact(
        "Debora",
        "(55)983456964",
        R.drawable.sample13
    ),
    Contact(
        "Sebastian",
        "(55)983456998",
        R.drawable.sample14
    ),
    Contact(
        "Federica",
        "(55)983456956",
        R.drawable.sample15
    ),
    Contact(
        "Francine",
        "(55)983456933",
        R.drawable.sample16
    ),

    )