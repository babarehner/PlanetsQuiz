package com.babarehner.planetsquizz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment(), View.OnClickListener {
    private lateinit var questionListener: QuestionListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is QuestionListener) {
            questionListener = context
        } else {
            throw RuntimeException("must implementQuestionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState:Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val questions = listOf<View>(
            view.findViewById(R.id.q1),
            view.findViewById(R.id.q2),
            view.findViewById(R.id.q3)
        )
        questions.forEach {
            it.setOnClickListener(this)
        }
    }

    override  fun onClick(v: View?) {
        v?.let { question ->
            questionListener.onSelected(question.id)
        }
    }

//    companion object {
//        private const val QUESTION_ID = "QUESTION_ID"
//        fun newInstance(questionID: Int) = QuestionFragment().apply {
//            arguments = Bundle().apply {
//                putInt(QUESTION_ID, questionID)
//            }
//        }
//    }
}