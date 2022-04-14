package com.ajgroup.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ajgroup.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.btnIncrease.setOnClickListener {
            viewModel.increaseNumber()
            binding.tvNumber.text = viewModel.number.toString()
//            var currentNumber = binding.tvNumber.text.toString().toInt()
//            currentNumber++
//
//            binding.tvNumber.text = currentNumber.toString()
        }
        viewModel.number.observe(this, Observer {
            binding.tvNumber.text = it.toString()
        })
    }
}