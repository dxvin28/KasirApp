package com.smktelkommlg.kasirapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProvider
import com.smktelkommlg.kasirapp.databinding.ActivityAddMejaBinding

class AddMeja : AppCompatActivity() {
    private lateinit var binding : ActivityAddMejaBinding
    private lateinit var mejaViewModel: MejaViewModel
    private var variety = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMejaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        mejaViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[MejaViewModel::class.java]

        binding.addTableIbBack.setOnClickListener {
            startActivity(Intent(this, DataMeja::class.java ))
            finish()
        }


        binding.addTableBtnSave.setOnClickListener{
            val noMeja = binding.addTableEtName.text.toString()

            when{

                noMeja.isEmpty() -> alert()
                else -> {
                    mejaViewModel.insertTable(Meja(number = noMeja.toInt()))
                    startActivity(Intent(this, DataMeja::class.java))
                    finish()
                }
            }
        }
    }


    private fun alert(){
        Toast.makeText(this, "Enter The Right Value", Toast.LENGTH_SHORT).show()
    }
}