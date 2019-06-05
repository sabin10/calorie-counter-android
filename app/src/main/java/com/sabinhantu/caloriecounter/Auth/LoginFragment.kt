package com.sabinhantu.caloriecounter.Auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.R

class LoginFragment : Fragment() {

    private lateinit var emailView: EditText
    private lateinit var passwordView: EditText
    private lateinit var loginButton: Button
    private lateinit var toRegisterText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        emailView = view.findViewById(R.id.login_email_view)
        passwordView = view.findViewById(R.id.login_password_view)
        loginButton = view.findViewById(R.id.login_button_view)
        toRegisterText = view.findViewById(R.id.to_register_text)

        toRegisterText.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registerFragment)
        )

        return view
    }


}
