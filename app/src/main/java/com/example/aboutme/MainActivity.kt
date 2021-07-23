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
    private lateinit var binding:ActivityMainBinding
    private lateinit var nickNameEditText: EditText
    private lateinit var nickNameTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView( this ,R.layout.activity_main)
        nickNameTextView = findViewById(R.id.nick_name_text)
        nickNameEditText = findViewById(R.id.nickname_edit_text)
        findViewById<Button>(R.id.done_buttom).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(it: View?) {
        // Hide the keyboard.
        nickNameTextView.text = nickNameEditText.text
        nickNameTextView.visibility = View.VISIBLE
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it!!.windowToken, 0)
        nickNameEditText.text.clear()
    }
}