package com.example.signupusingdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    lateinit var databaseReference : DatabaseReference
    companion object{
        const val KEY1 = "com.example.signupUsingDatabase.mail"
        const val KEY2 = "com.example.signupUsingDatabase.name"
        const val KEY3 = "com.example.signupUsingDatabase.id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignIn = findViewById<Button>(R.id.btnSignIn)
        val userName = findViewById<TextInputEditText>(R.id.username)
        val btnSignUpIntent = findViewById<Button>(R.id.btnSignUp)

        btnSignUpIntent.setOnClickListener{

            intent = Intent(applicationContext,SignUpPage::class.java)
            startActivity(intent)
        }
        btnSignIn.setOnClickListener{
            val uniqueId = userName.text.toString()
            if (uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this,"Please enter the username",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(uniqueId : String) {
        databaseReference =FirebaseDatabase.getInstance().getReference("users")

        databaseReference.child(uniqueId).get().addOnSuccessListener {
            //if user exists
            if (it.exists()){

                val mail = it.child("mail").value
                val name = it.child("name").value
                val userId = it.child("uniqueId").value

                val intentWelcomePage = Intent(this,WelcomePage::class.java)
                intentWelcomePage.putExtra(KEY1,mail.toString())
                intentWelcomePage.putExtra(KEY2,name.toString())
                intentWelcomePage.putExtra(KEY3,userId.toString())
                startActivity(intentWelcomePage)


            }else{
                Toast.makeText(this,"User does not exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Failed ,Error in DB,Try again !",Toast.LENGTH_SHORT).show()
        }

    }
}