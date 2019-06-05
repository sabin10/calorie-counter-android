package com.sabinhantu.caloriecounter.Auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sabinhantu.caloriecounter.R

class LoginFragment : Fragment() {

    private lateinit var registerButton: Button
    private lateinit var toRegisterText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        registerButton = view.findViewById(R.id.to_register_btn)
        registerButton.setOnClickListener {
            Toast.makeText(activity, "button clicked", Toast.LENGTH_SHORT).show()
        }

        toRegisterText = view.findViewById(R.id.to_register_text)
        toRegisterText.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registerFragment)
        )

        return view
    }


}
