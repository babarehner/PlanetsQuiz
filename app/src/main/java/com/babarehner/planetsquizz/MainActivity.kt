package com.babarehner.planetsquizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val WHICH_QUESTION_ID = "WHICH_QuESTION_ID"

interface whichQuestionListener{ fun onSelected(id: Int)}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}