package com.example.signupusingdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class welcomeActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome2)

        val btnExam = findViewById<Button>(R.id.btnExam)
        val btnPhotoFrame =findViewById<Button>(R.id.btnPhotoFrame)


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
    }
}