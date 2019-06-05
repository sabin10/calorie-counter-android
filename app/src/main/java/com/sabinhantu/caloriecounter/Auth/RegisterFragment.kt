package com.sabinhantu.caloriecounter.Auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.sabinhantu.caloriecounter.R

class RegisterFragment : Fragment() {

    private lateinit var emailView: EditText
    private lateinit var passwordView: EditText
    private lateinit var passwordConfView: EditText
    private lateinit var registerButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        emailView = view.findViewById(R.id.register_email_view)
        passwordView = view.findViewById(R.id.register_password_view)
        passwordConfView = view.findViewById(R.id.register_passwordconf_view)
        registerButton = view.findViewById(R.id.register_passwordconf_view)

        return view
    }


}
