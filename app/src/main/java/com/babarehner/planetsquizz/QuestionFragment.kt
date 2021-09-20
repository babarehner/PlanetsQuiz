package com.babarehner.planetsquizz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
**/


class QuestionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val answers = listOf<View>(
                view.findViewById(R.id.q1),
                view.findViewById(R.id.q2),
                view.findViewById(R.id.q3)
        )

        answers.forEach { answer ->  val fragmentBundle = Bundle()
            fragmentBundle.putInt(QUESTION_ID, answer.id)
            answer.setOnClickListener(
                    // R.id.question_id_action is in nav_graph
                    // Go to ChooseAnserFragment per nav_graph with fragmentBundle
                    Navigation.createNavigateOnClickListener(R.id.question_id_action,
                                                                fragmentBundle
                    )
            )
        }
    }



}