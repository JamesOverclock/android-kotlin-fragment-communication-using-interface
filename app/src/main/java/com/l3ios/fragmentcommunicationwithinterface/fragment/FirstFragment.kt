package com.l3ios.fragmentcommunicationwithinterface.fragment


import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.l3ios.fragmentcommunicationwithinterface.R
import kotlinx.android.synthetic.main.fragment_first.*
import java.lang.RuntimeException

class FirstFragment : Fragment() {

    private var mListener: OnFragmentCommunicationListener? = null

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity
     */

    interface OnFragmentCommunicationListener {

        fun onNameChange(name: String)

        fun onEmailChange(email: String)

    }

    fun newInstance(): FirstFragment {
        return FirstFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mListener?.onNameChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        emailEditText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mListener?.onEmailChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentCommunicationListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentCommunicationListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }


}
