package com.babarehner.planetsquizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChooseAnswerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChooseAnswerFragment : Fragment() {

    private var question: Int = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val questionID = arguments?.getInt(QUESTION_ID, 1) ?: 1
        setQuestionData(questionID)
    }


    fun setQuestionData(questionID: Int) { question = questionID }

    companion object {
        private const val QUESTION_ID = "QUESTION_ID"
        fun newInstance(questionID: Int) = ChooseAnswerFragment().apply {
            arguments = Bundle().apply {
                putInt(QUESTION_ID, questionID)
            }
        }
    }

}