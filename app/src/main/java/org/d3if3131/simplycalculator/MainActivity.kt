package org.d3if3131.simplycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import org.d3if3131.simplycalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var EditBilangan1: EditText
    private lateinit var EditBilangan2: EditText
    private lateinit var ViewHasil: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        EditBilangan1 = findViewById(R.id.edit_bilangan_pertama)
        EditBilangan2 = findViewById(R.id.edit_bilangan_kedua)
        ViewHasil = findViewById(R.id.hasil_perhitungan)
        val ButtonTambah: Button = findViewById(R.id.buttonTambah)
        val ButtonKurang: Button = findViewById(R.id.buttonKurang)
        val ButtonKali: Button = findViewById(R.id.buttonKali)
        val ButtonBagi: Button = findViewById(R.id.buttonBagi)

        ButtonTambah.setOnClickListener(this)
        ButtonKurang.setOnClickListener(this)
        ButtonKali.setOnClickListener(this)
        ButtonBagi.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        val bilanganPertama = binding.editBilanganPertama.text.toString()
        if (TextUtils.isEmpty(bilanganPertama)) {
            Toast.makeText(this, R.string.bilangan_pertama_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val bilanganKedua = binding.editBilanganKedua.text.toString()
        if (TextUtils.isEmpty(bilanganKedua)) {
            Toast.makeText(this, R.string.bilangan_kedua_invalid, Toast.LENGTH_LONG).show()
            return
        }
        if (v != null) {
            when (v.id) {
                R.id.buttonTambah -> {
                    val HasilTambah = EditBilangan1.text.toString().trim()
                        .toDouble() + EditBilangan2.text.toString().toDouble()
                    ViewHasil.text = HasilTambah.toString()
                }
                R.id.buttonKurang -> {
                    val HasilKurang = EditBilangan1.text.toString().trim()
                        .toDouble() - EditBilangan2.text.toString().toDouble()
                    ViewHasil.text = HasilKurang.toString()
                }
                R.id.buttonKali -> {
                    val HasilKali = EditBilangan1.text.toString().trim()
                        .toDouble() * EditBilangan2.text.toString().toDouble()
                    ViewHasil.text = HasilKali.toString()
                }
                R.id.buttonBagi -> {
                    val HasilBagi = EditBilangan1.text.toString().trim()
                        .toDouble() / EditBilangan2.text.toString().toDouble()
                    ViewHasil.text = HasilBagi.toString()
                }
            }
        }
    }
}

