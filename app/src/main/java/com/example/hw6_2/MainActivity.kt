package com.example.hw6_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.hw6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var flag=true
    var count=0
    @SuppressLint("SetTextI18n")
    var list=ArrayList<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list= arrayListOf(binding.editText1,binding.editText2,binding.editText3
            ,binding.editText4,binding.editText5,binding.editText6,binding.editText7
            ,binding.editText8,binding.editText9)


        binding.textView.text="Draw"

        for (button in list){
            button.setOnClickListener {
                onClick(button)
            }
        }

        binding.reset.setOnClickListener {
            reset()
        }

    }


    private fun reset(){
        for (button in list){
            button.text=""
            flag=true
            binding.textView.text="Draw"
            button.isClickable=true
            button.isEnabled=true
            count=0
        }
    }

    @SuppressLint("SetTextI18n")
    private fun onClick(button: Button){
        if (flag){
            button.text="X"
        }else{
            button.text="O"
        }
        count++
        flag=!flag
        button.isClickable=false
        if(winner()==1){
            list.forEach{it.isEnabled=false}
        }
        if(binding.textView.text=="Draw" && count==9){
            binding.textView.text="No Winner"
            list.forEach{it.isEnabled=false}
        }
    }



    @SuppressLint("SetTextI18n")
    fun winner():Int{

        if (binding.editText1.text==binding.editText2.text && binding.editText1.text==binding.editText3.text && binding.editText3.text!=""){
            binding.textView.text="player ${binding.editText4.text.toString()} winner"
            return 1
        }
        if (binding.editText4.text==binding.editText5.text && binding.editText5.text==binding.editText6.text && binding.editText6.text!=""){
            binding.textView.text="player ${binding.editText7.text.toString()} winner"
            return 1
        }
        if (binding.editText7.text==binding.editText8.text && binding.editText7.text==binding.editText9.text && binding.editText9.text!=""){
            binding.textView.text="player ${binding.editText7.text.toString()} winner"
            return 1
        }
        if (binding.editText1.text==binding.editText4.text && binding.editText1.text==binding.editText7.text && binding.editText7.text!=""){
            binding.textView.text="player ${binding.editText1.text.toString()} winner"
            return 1
        }
        if (binding.editText2.text==binding.editText5.text && binding.editText2.text==binding.editText8.text && binding.editText8.text!=""){
            binding.textView.text="player ${binding.editText2.text.toString()} winner"
            return 1
        }
        if (binding.editText3.text==binding.editText6.text && binding.editText3.text==binding.editText9.text && binding.editText9.text!=""){
            binding.textView.text="player ${binding.editText3.text.toString()} winner"
            return 1
        }
        if (binding.editText1.text==binding.editText5.text && binding.editText1.text==binding.editText9.text && binding.editText9.text!=""){
            binding.textView.text="player ${binding.editText1.text.toString()} winner"
            return 1
        }
        if (binding.editText3.text==binding.editText5.text && binding.editText3.text==binding.editText7.text && binding.editText7.text!=""){
            binding.textView.text="player ${binding.editText3.text.toString()} winner"
            return 1
        }
        return 0
    }
}
