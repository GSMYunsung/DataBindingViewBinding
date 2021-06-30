package com.example.databindingviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.example.databindingviewbinding.databinding.ActivityViewBindingMainBinding

class ViewBindingMainActivity : AppCompatActivity() {
    private var viewbinding : ActivityViewBindingMainBinding? = null

    //매번 null 체크를 할 필요없이 편의성을 위해 바인딩 변수 재선언
    private val binding get() = viewbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //객체 생성
        viewbinding = ActivityViewBindingMainBinding.inflate(layoutInflater)

        //getRoot 메서드로 레이아웃 내부의 최상위 위치뷰의 인스턴스를 활용,
        // 엑티비티에서 활용하여 생성된 뷰 엑티비티에 표시함!
        setContentView(binding.root)

        binding.testText.setText("Viewbinding 성공!")
    }

    //엑티비티가 종료될 때 같이 종료시켜주어야 한다.
    override fun onDestroy() {
        viewbinding = null
        super.onDestroy()
    }

}