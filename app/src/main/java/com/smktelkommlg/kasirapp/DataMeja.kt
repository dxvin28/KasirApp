package com.smktelkommlg.kasirapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class DataMeja : AppCompatActivity() {
    private lateinit var binding : ActivityDataMejaBinding
    private lateinit var mejaViewModel: MejaViewModel
    private var table = ArrayList<Meja>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataMejaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        mejaViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[MejaViewModel::class.java]

        initTableRv()

        binding.dataTableIbBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.dataTableFabAdd.setOnClickListener {
            startActivity(Intent(this, AddMeja::class.java))
            finish()
        }
    }

    private fun initTableRv(){


        val adapterMeja = AdapterMeja(this, table, mejaViewModel = mejaViewModel)

        val rvTable = binding.dataTableRv
        rvTable.setHasFixedSize(true)
        rvTable.layoutManager = LinearLayoutManager(this)
        rvTable.adapter = adapterMeja

        mejaViewModel.getTable.observe(this) { list ->
            list?.let {
                table = it as ArrayList<Meja>
                adapterMeja.updateTable(table)
            }
        }
    }
}