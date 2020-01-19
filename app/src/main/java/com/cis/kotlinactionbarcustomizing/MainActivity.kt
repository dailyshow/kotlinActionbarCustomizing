package com.cis.kotlinactionbarcustomizing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // 액션바 커스터마이징을 허용한다.
        supportActionBar?.setDisplayShowCustomEnabled(true)

        // 기존 액션바의 요소들을 숨겨준다.
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)

        val actionView = layoutInflater.inflate(R.layout.custom_actionbar, null)
        supportActionBar?.customView = actionView

        val actionText = actionView.findViewById<TextView>(R.id.tv)
        actionText.text = "커스텀 액션바"
        actionText.setTextColor(Color.WHITE)

        val actionBtn = actionView.findViewById<Button>(R.id.btn)
        actionBtn.setOnClickListener {
            Toast.makeText(this, "버튼 눌림!!!", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}
