package com.example.signupusingdatabase

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.collection.LLRBNode
import com.google.firebase.firestore.auth.User

class SignUpPage : AppCompatActivity() {

    lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        val btnSignInIntent = findViewById<Button>(R.id.btnSignIn)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<TextInputEditText>(R.id.etname)
        val etMail = findViewById<TextInputEditText>(R.id.etmail)
        val userPassword = findViewById<TextInputEditText>(R.id.etpassword)
        val etUniqueId = findViewById<TextInputEditText>(R.id.etUniqueId)
        val checkbox = findViewById<CheckBox>(R.id.checkBox1)


        btnSignUp.setOnClickListener {

            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure ")
            builder1.setMessage("You want to submit the details? ")
            builder1.setIcon(R.drawable.sign_up_icon)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->

            val name = etName.text.toString()
            val mail = etMail.text.toString()
            val uniqueId = etUniqueId.text.toString()
            val password = userPassword.text.toString()

            val user = User(name, mail, password, uniqueId)

            database = FirebaseDatabase.getInstance().getReference("users")

            if (checkbox.isChecked) {
                database.child(uniqueId).setValue(user).addOnSuccessListener {
                    etName.text?.clear()
                    etMail.text?.clear()
                    userPassword.text?.clear()
                    etUniqueId.text?.clear()
                    checkbox.toggle()

                    Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                checkbox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, "Please Accept T&C", Toast.LENGTH_SHORT).show()

            }
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder1.show()
        }

            btnSignInIntent.setOnClickListener {

                intent = Intent(applicationContext, SignUpActivity::class.java)
                startActivity(intent)
            }



    }
}