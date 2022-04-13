package com.example.midtermandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.midtermandroid.databinding.ActivityMainBinding

class FeedbackPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm: FeedbackViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        observeData()
    }

    private fun setListeners() {
        binding.sendButton.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        with(binding) {
            vm.checkEmptyField(
                nameEditText.text.toString(),
                lastNameEditText.text.toString(),
                textEditText.text.toString()
            )
        }
    }

    private fun observeData() {
        vm.errorLiveData.observe(this, {
            Toast.makeText(this, getString(it), Toast.LENGTH_SHORT).show()
        })
        vm.successLiveData.observe(this, {
            Toast.makeText(this, getString(it), Toast.LENGTH_SHORT).show()
        })
    }
}