package com.babarehner.planetsquizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 * */

class ChooseAnswerFragment : Fragment() {

    private val questionAsked: TextView?
        get() = view?.findViewById(R.id.question_asked)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val questionId = arguments?.getInt(QUESTION_ID, 0) ?: 0
        setQuestionData(questionId)
    }

    private fun setQuestionData(questionId: Int) {
        when (questionId) {
            R.id.q1 -> { questionAsked?.text = getString(R.string.q1) }
            R.id.q2 -> {questionAsked?.text = getString(R.string.q2)}
            R.id.q3 -> { questionAsked?.text = getString(R.string.q3) }
            else -> { Toast.makeText(context, "Unknown Question", Toast.LENGTH_LONG).show()}
        }
    }



    companion object {
        private const val QUESTION_ID = "QUESTION_ID"
        fun newInstance(questionId: Int) = ChooseAnswerFragment().apply {
            arguments = Bundle().apply {
                putInt(QUESTION_ID, questionId)
            }
        }
    }

}