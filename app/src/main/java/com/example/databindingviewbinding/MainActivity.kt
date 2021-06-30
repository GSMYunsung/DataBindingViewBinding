package com.example.databindingviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.BaseObservable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.example.databindingviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{

        private lateinit var binding : ActivityMainBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // DataBinding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.user = User("최윤성","010-6546-4107",18)

        binding.testData = ObservableUser()

    }

    class ObservableUser : BaseObservable(){
        val name = ObservableField("김길동")
        val callnumber = ObservableField("010-1234-5678")
        val age = ObservableInt(22)

        fun onclickSetValue(){
            name.set(binding.editEdit.text.toString())
        }
    }
}


class User(var name : String, var callnumber : String, var age : Int){

    init {
        this.name = name
        this.callnumber = callnumber
        this.age = age
    }
}