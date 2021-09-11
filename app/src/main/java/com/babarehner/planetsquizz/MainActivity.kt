package com.babarehner.planetsquizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.babarehner.planetsquizz.AnswerFragment.Companion.newInstance
// import com.babarehner.planetsquizz.ChooseAnswerFragment.Companion.newInstance

const val QUESTION_ID = "QUESTION_ID"

interface QuestionListener{
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), QuestionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // if first time around
        if (savedInstanceState == null) {
            // add the QuestionFragment to the fragment_container
            findViewById<FragmentContainerView>(R.id.fragment_container)?.let{
                frameLayout -> val questionFragment = QuestionFragment()
                supportFragmentManager.beginTransaction().add(frameLayout.id, questionFragment)
                    .commit()
            }
        }
    }

    override fun onSelected(questionID: Int){
        findViewById<FragmentContainerView>(R.id.fragment_container)?.let{ frameLayout ->
            val chooseAnswerFragment = ChooseAnswerFragment.newInstance(questionID)
            //replace one fragment with another
            supportFragmentManager.beginTransaction().replace(frameLayout.id, chooseAnswerFragment)
                // addToBackStack null stops app from exiting when back button pressed
                .addToBackStack(null).commit()
            // app will now go back to ListFragment when back button pressed
        }
    }
}