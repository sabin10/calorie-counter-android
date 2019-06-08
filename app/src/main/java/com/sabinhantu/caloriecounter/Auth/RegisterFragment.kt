package com.sabinhantu.caloriecounter.Auth


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.sabinhantu.caloriecounter.MainActivity
import com.sabinhantu.caloriecounter.R

class RegisterFragment : Fragment() {

    private lateinit var emailView: EditText
    private lateinit var passwordView: EditText
    private lateinit var passwordConfView: EditText
    private lateinit var registerButton: Button

    private var mAuth: FirebaseAuth? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        emailView = view.findViewById(R.id.register_email_view)
        passwordView = view.findViewById(R.id.register_password_view)
        passwordConfView = view.findViewById(R.id.register_passwordconf_view)
        registerButton = view.findViewById(R.id.register_button_view)

        mAuth = FirebaseAuth.getInstance()

        registerButton.setOnClickListener {
            var email = emailView.text.toString()
            var password = passwordView.text.toString()
            var passwordConfirm = passwordConfView.text.toString()

            if (!password.equals(passwordConfirm)) {
                Toast.makeText(activity, "Passwords doesn't match", Toast.LENGTH_LONG).show()
            } else if (!email.isEmpty() && !password.isEmpty() && !passwordConfirm.isEmpty()){
                register(email, password)
            }
        }

        return view
    }

    fun register(email: String, password: String) {
        mAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity!!) { task ->
            if (task.isSuccessful) {
                // Register: succes
                intentToMainActivity()
            } else {
                // Register: fail
                Toast.makeText(activity, "Register fail", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun intentToMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        // remove initial MainActivity from backstackm
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        activity!!.startActivity(intent)
    }



}
