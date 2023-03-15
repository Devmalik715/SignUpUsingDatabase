package com.example.signupusingdatabase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class WelcomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        val name = intent.getStringExtra(SignUpActivity.KEY2)
        val mail = intent.getStringExtra(SignUpActivity.KEY1)
        val userId = intent.getStringExtra(SignUpActivity.KEY3)

        val welcomeText = findViewById<TextView>(R.id.tvWelcome)
        val mailText = findViewById<TextView>(R.id.tvMail)
        val idText =findViewById<TextView>(R.id.tvId)

        welcomeText.text= "Welcome $name"
        mailText.text = "Mail : $mail"
        idText.text = "User Id : $userId"

        val btnExam = findViewById<Button>(R.id.btnExam)
        val btnPhotoFrame =findViewById<Button>(R.id.btnPhotoFrame)
        val btnChat = findViewById<Button>(R.id.btnChat)


        btnExam.setOnClickListener{

            val intentExamActivity = Intent(this,ExamActivity1::class.java)
            Toast.makeText(this,"You clicked on 'Exam' ", Toast.LENGTH_SHORT).show()

            startActivity(intentExamActivity)
        }

        btnPhotoFrame.setOnClickListener{
            val intentPhotoFrameActivity = Intent(this,PhotoFrameActivity::class.java)
            Toast.makeText(this,"You clicked on 'Photo-Frame' ",Toast.LENGTH_SHORT).show()
            startActivity(intentPhotoFrameActivity)
        }

        btnChat.setOnClickListener {
            val intentChat = Intent(this,ListviewPage::class.java)
            startActivity(intentChat)
        }
    }
}