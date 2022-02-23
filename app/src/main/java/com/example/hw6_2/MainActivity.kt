package com.example.hw6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.hw6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView.text="Draw"
        
        binding.editText1.doOnTextChanged { text, start, before, count ->  }

        if (binding.editText1.text==binding.editText2.text && binding.editText1.text==binding.editText3.text){
            binding.textView.text="player ${binding.editText1.text.toString()} winner"
        }
        if (binding.editText4.text==binding.editText5.text && binding.editText4.text==binding.editText6.text){
            binding.textView.text="player ${binding.editText4.text.toString()} winner"
        }
        if (binding.editText7.text==binding.editText8.text && binding.editText7.text==binding.editText9.text){
            binding.textView.text="player ${binding.editText7.text.toString()} winner"
        }
        if (binding.editText1.text==binding.editText4.text && binding.editText1.text==binding.editText7.text){
            binding.textView.text="player ${binding.editText1.text.toString()} winner"
        }
        if (binding.editText2.text==binding.editText5.text && binding.editText2.text==binding.editText8.text){
            binding.textView.text="player ${binding.editText2.text.toString()} winner"
        }
        if (binding.editText3.text==binding.editText6.text && binding.editText3.text==binding.editText9.text){
            binding.textView.text="player ${binding.editText3.text.toString()} winner"
        }
        if (binding.editText1.text==binding.editText5.text && binding.editText1.text==binding.editText9.text){
            binding.textView.text="player ${binding.editText1.text.toString()} winner"
        }

        if (binding.editText3.text==binding.editText5.text && binding.editText3.text==binding.editText7.text){
            binding.textView.text="player ${binding.editText3.text.toString()} winner"
        }



    }
}