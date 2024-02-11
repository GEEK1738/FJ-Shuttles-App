package com.example.shuttle

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shuttle.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityRegisterBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    //progress dialog

    private lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        //init progress dialog, will show while creating account | Register user
        progressDialog = ProgressDialog( this)
        progressDialog.setTitle("please wait")
        progressDialog.setCanceledOnTouchOutside(false)
        // Hide the Action Bar
        supportActionBar?.hide()


        //handle click, begin register
        binding.registerbtn.setOnClickListener {
            val email= binding.emailTxt.text.toString()
            val pass= binding.passTxt.text.toString()
            val cpass= binding.cpassTxt.text.toString()
            if(email.isNotEmpty() && pass.isNotEmpty() && cpass.isNotEmpty()){
                if(pass.equals(cpass)){
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent= Intent( this,LoginActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty Field Are Not Allowed!", Toast.LENGTH_SHORT).show()
            }

        }
        binding.rloginbtn.setOnClickListener {

            setContentView(R.layout.activity_login)
            startActivity(Intent( this, LoginActivity::class.java))
        }
    }

}