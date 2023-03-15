package com.example.signupusingdatabase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class PhotoFrameActivity : AppCompatActivity() {

    var currentImage =0
    lateinit var image : ImageView
    var names = arrayOf("Virat Kohli","Rishabh Pant","Surya Kumar Yadav", "AB de Villiers")

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_frame)

        val prev = findViewById<ImageButton>(R.id.prevImg)
        val next =findViewById<ImageButton>(R.id.nextImg)
        val text = findViewById<TextView>(R.id.textVirat)

        prev.setOnClickListener {
            val idCurrentImgString = "pic$currentImage"
            //this is the string address of current id
            //in the next line , above string address will be converted into integer address
            //bcz in findViewById method , after R.id ,the value is integer

            val idCurrentImgInt = this.resources.getIdentifier(idCurrentImgString,"id",packageName)
            image = findViewById(idCurrentImgInt)
            image.alpha = 0f

            currentImage = (4+currentImage-1)%4
            val idImageToShowString = "pic$currentImage"
            // convert above string address associated with the image to int below
            val idImgToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImgToShowInt)
            image.alpha =1f
            text.text =names[currentImage]

        }

        next.setOnClickListener {
            val idCurrentImgString = "pic$currentImage"
            //this is the string address of current id
            //in the next line , above string address will be converted into integer address
            //bcz in findViewById method , after R.id ,the value is integer

            val idCurrentImgInt = this.resources.getIdentifier(idCurrentImgString,"id",packageName)
            image = findViewById(idCurrentImgInt)
            image.alpha = 0f

            currentImage = (4+currentImage+1)%4
            val idImageToShowString = "pic$currentImage"
            // convert above string address associated with the image to int below
            val idImgToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImgToShowInt)
            image.alpha =1f
            text.text =names[currentImage]


        }
        val btnMainMenu = findViewById<Button>(R.id.btnMainMenu)

        btnMainMenu.setOnClickListener{
            Toast.makeText(this,"You clicked on 'Main Menu' ", Toast.LENGTH_SHORT).show()
            val intentWelcomePage2= Intent(this,welcomeActivity2::class.java)
            startActivity(intentWelcomePage2)
        }


    }



}