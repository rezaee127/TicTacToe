package com.example.hw6_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hw6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var flag=true
    private var count=0
    @SuppressLint("SetTextI18n")
    var listOfButtons=ArrayList<Button>()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listOfButtons= arrayListOf(binding.button1,binding.button2,binding.button3
            ,binding.button4,binding.button5,binding.button6,binding.button7
            ,binding.button8,binding.button9)


        binding.textView.text="Draw"

        for (button in listOfButtons){
            button.setOnClickListener {
                onClick(button)
            }
        }

        binding.reset.setOnClickListener {
            reset()
        }

    }


    @SuppressLint("SetTextI18n")
    private fun reset(){
        for (button in listOfButtons){
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
            listOfButtons.forEach{it.isClickable=false}
        }
        if(binding.textView.text=="Draw" && count==9){
            binding.textView.text="No Winner"
            listOfButtons.forEach{it.isClickable=false}
        }
    }



    @SuppressLint("SetTextI18n")
    fun winner():Int {
        if (count >= 5) {
            if (binding.button1.text == binding.button2.text && binding.button1.text == binding.button3.text && binding.button3.text != "") {
                binding.textView.text = "player ${binding.button1.text} winner"
                return 1
            }
            if (binding.button4.text == binding.button5.text && binding.button4.text == binding.button6.text && binding.button6.text != "") {
                binding.textView.text = "player ${binding.button4.text} winner"
                return 1
            }
            if (binding.button7.text == binding.button8.text && binding.button7.text == binding.button9.text && binding.button9.text != "") {
                binding.textView.text = "player ${binding.button7.text} winner"
                return 1
            }
            if (binding.button1.text == binding.button4.text && binding.button1.text == binding.button7.text && binding.button7.text != "") {
                binding.textView.text = "player ${binding.button1.text} winner"
                return 1
            }
            if (binding.button2.text == binding.button5.text && binding.button2.text == binding.button8.text && binding.button8.text != "") {
                binding.textView.text = "player ${binding.button2.text} winner"
                return 1
            }
            if (binding.button3.text == binding.button6.text && binding.button3.text == binding.button9.text && binding.button9.text != "") {
                binding.textView.text = "player ${binding.button3.text} winner"
                return 1
            }
            if (binding.button1.text == binding.button5.text && binding.button1.text == binding.button9.text && binding.button9.text != "") {
                binding.textView.text = "player ${binding.button1.text} winner"
                return 1
            }
            if (binding.button3.text == binding.button5.text && binding.button3.text == binding.button7.text && binding.button7.text != "") {
                binding.textView.text = "player ${binding.button3.text} winner"
                return 1
            }
        }
        return 0
    }
}
