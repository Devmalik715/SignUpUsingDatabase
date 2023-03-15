package com.example.signupusingdatabase

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ExamActivity1 : AppCompatActivity() {

    lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam1)

        val btnQ1 = findViewById<Button>(R.id.btnQ1)
        val btnQ2 = findViewById<Button>(R.id.btnQ2)
        val btnQ3 = findViewById<Button>(R.id.btnQ3)
        val btnQ4 = findViewById<Button>(R.id.btnQ4)
        val btnQ5 = findViewById<Button>(R.id.btnQ5)
        val btnQ6 = findViewById<Button>(R.id.btnQ6)


        btnQ1.setOnClickListener{
            val options = arrayOf("C","C++","Python","Java","kotlin")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Which is your Favourite Programming Language ?")
            builder1.setSingleChoiceItems(options,-1, DialogInterface.OnClickListener { dialog, which ->

                Toast.makeText(this,"You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder1.setPositiveButton("Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->

                    Toast.makeText(this,"Submitted Successfully", Toast.LENGTH_SHORT).show()
            })
            builder1.setNegativeButton("Declined",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this,"You Declined", Toast.LENGTH_SHORT).show()

            })
            builder1.show()
        }

        btnQ2.setOnClickListener{
            val options = arrayOf("Machine Learning","Artificial Intelligence","Blockchain","App Development", "Web Developmewnt")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Which is your Favourite Technology ?")
            builder1.setSingleChoiceItems(options,-1, DialogInterface.OnClickListener { dialog, which ->

                Toast.makeText(this,"You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder1.setPositiveButton("Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->

                    Toast.makeText(this,"Submitted Successfully", Toast.LENGTH_SHORT).show()
                })
            builder1.setNegativeButton("Declined",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this,"You Declined", Toast.LENGTH_SHORT).show()
                })
            builder1.show()
        }

        btnQ3.setOnClickListener{
            val options = arrayOf("Computer Science Engineering","Information Technology","Electronic Engineering","Mechanical Engineering","Civil Engineering")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("You are from which branch of B.tech ?")
            builder1.setSingleChoiceItems(options,-1, DialogInterface.OnClickListener { dialog, which ->

                Toast.makeText(this,"You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder1.setPositiveButton("Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->

                    Toast.makeText(this,"Submitted Successfully", Toast.LENGTH_SHORT).show()
                })
            builder1.setNegativeButton("Declined",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this,"You Declined", Toast.LENGTH_SHORT).show()
                })
            builder1.show()
        }

        btnQ4.setOnClickListener{
            val options = arrayOf("Rust","C++","Python","Java","kotlin")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Which is your Favourite Programming Language for App Development ?")
            builder1.setMultiChoiceItems(options, null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()
            })

            builder1.setPositiveButton("Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->

                    Toast.makeText(this,"Submitted Successfully", Toast.LENGTH_SHORT).show()
                })
            builder1.setNegativeButton("Declined",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this,"You Declined", Toast.LENGTH_SHORT).show()
                })
            builder1.show()
        }

        btnQ5.setOnClickListener{
            val options = arrayOf("C#","Go","Python","Java","PHP")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Which is/are your preferred language for Backk-end development ?")
            builder1.setMultiChoiceItems(options, null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()
            })

            builder1.setPositiveButton("Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->

                    Toast.makeText(this,"Submitted Successfully", Toast.LENGTH_SHORT).show()
                })
            builder1.setNegativeButton("Declined",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this,"You Declined", Toast.LENGTH_SHORT).show()
                })
            builder1.show()
        }
        btnQ6.setOnClickListener{
            val options = arrayOf("Javascript","python + django","ReactJs","Angular")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Which is/are your preferred language for front-end development ?")
            builder1.setMultiChoiceItems(options, null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You clicked on ${options[which]}",Toast.LENGTH_SHORT).show()
            })

            builder1.setPositiveButton("Submit",
                DialogInterface.OnClickListener { dialogInterface, i ->

                    Toast.makeText(this,"Submitted Successfully", Toast.LENGTH_SHORT).show()
                })
            builder1.setNegativeButton("Declined",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this,"You Declined", Toast.LENGTH_SHORT).show()
                })
            builder1.show()
        }
        //this button submit variable which is on exam page
        val btnSub = findViewById<Button>(R.id.btnSub)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.dialogue_box_bg))
        //below are the variable declaration of yes and no button which are on custom dialogue intent

        val btnYes = dialog.findViewById<Button>(R.id.btnYes)
        val btnNo = dialog.findViewById<Button>(R.id.btnNo)

        btnYes.setOnClickListener{
            Toast.makeText(this,"You clicked on 'Yes' ",Toast.LENGTH_SHORT).show()
            val intentWelcomePage2= Intent(this,welcomeActivity2::class.java)
            startActivity(intentWelcomePage2)
        }

        btnNo.setOnClickListener {
            Toast.makeText(this,"You clicked on 'No' ",Toast.LENGTH_SHORT).show()
            dialog.dismiss()

        }
        btnSub.setOnClickListener {
            dialog.show()
        }

    }
}