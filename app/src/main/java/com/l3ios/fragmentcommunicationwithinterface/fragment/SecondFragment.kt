package com.l3ios.fragmentcommunicationwithinterface.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.l3ios.fragmentcommunicationwithinterface.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    private val TAG = SecondFragment::class.java.simpleName

    fun newInstance(): SecondFragment {
        return SecondFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    fun onNameChange(name: String) {
        txtName.text = name
        Log.d(TAG, "onNameChange() returned: $name")
    }

    fun onEmailChange(email: String) {
        txtEmail.text = email
        Log.d(TAG, "onEmailChange() returned: $email")
    }

}
