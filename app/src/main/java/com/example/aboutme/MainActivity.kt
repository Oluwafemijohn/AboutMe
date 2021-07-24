package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var myName: MyName = MyName("Oluwafemi")

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView( this ,R.layout.activity_main)

        binding.myName = myName
        binding.doneButtom.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(it: View?) {
        // Hide the keyboard.


        binding.apply {
            myName?.nickName = binding.nicknameEditText.text.toString()
            invalidateAll()
            nickNameText.visibility = View.VISIBLE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it!!.windowToken, 0)
        binding.nicknameEditText.text.clear()
    }
}