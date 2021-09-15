package com.babarehner.planetsquizz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible


/**
 * A simple [Fragment] subclass.
 * */

class ChooseAnswerFragment : Fragment(),  View.OnClickListener{
    // Custom getter- for Fragments have to use !! on the view property. Null safety gone
    private val questionAsked: TextView?
        get() = view?.findViewById(R.id.question_asked)

    private var questionId = NO_QUESTION_SET

    private val answer: TextView?
        get() = view?.findViewById(R.id.check_answer_text)




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_answer, container, false)
    }

    // at this stage the layout of the fragment has been generated
    // the arguments of the fragment are stored in a Bubblle()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        // getquestionId from passed in arguments -see arguments in companion object factory
        // sets a default of 0
        // questionId = arguments?.getInt(QUESTION_ID, 0) ?: NO_QUESTION_SET
        // what is the difference between the above and the below
        questionId = arguments?.getInt(QUESTION_ID) ?: NO_QUESTION_SET
        setQuestionData(questionId)


        val answersPicked = listOf<View>(
                view.findViewById(R.id.mercury),
                view.findViewById(R.id.venus),
                view.findViewById(R.id.earth),
                view.findViewById(R.id.mars),
                view.findViewById(R.id.jupiter),
                view.findViewById(R.id.saturn),
                view.findViewById(R.id.uranus),
                view.findViewById(R.id.neptune)
        )
        // set a click listener for each item above
        answersPicked.forEach {
            it.setOnClickListener(this)
        }

    }


    //handle View.OnClickLIstener
    override fun onClick(v: View?) {
        Log.d(TAG, questionId.toString() )
        when (questionId){
            R.id.q1 -> {
                if (v?.id == R.id.jupiter){
                    answer?.text = getString(R.string.answer_text1, "Correct")
                    Log.d(TAG, questionId.toString() )
                } else {
                    answer?.text = getString(R.string.answer_text1, "Wrong")
                }
            }
            R.id.q2 -> {
                if (v?.id == R.id.saturn) {
                    answer?.text = getString(R.string.answer_text2, "Correct")
                } else {
                    answer?.text = getString(R.string.answer_text2, "Wrong")
                }
            }
            R.id.q3 -> {
                if (v?.id == R.id.  uranus) {
                    answer?.text = getString(R.string.answer_text3, "Correct")
                } else {
                    answer?.text = getString(R.string.answer_text3, "Wrong")
                }
            }
            else -> { answer?.text = "OOPs, Something is crazy screwy"}

        }



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
        private const val NO_QUESTION_SET = 0
        private const val TAG = "AnswerFragement"
        // newInstance method initializes fragments - not legal to use parameterized constructor
        // for fragments
        fun newInstance(questionId: Int) = ChooseAnswerFragment().apply {
            // arguments are retrieved in onViewCreated
            arguments = Bundle().apply {
                putInt(QUESTION_ID, questionId)
            }
        }
    }

}