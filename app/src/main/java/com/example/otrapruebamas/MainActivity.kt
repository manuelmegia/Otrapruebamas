package com.example.otrapruebamas

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = FirebaseDatabase.getInstance().getReference("Personajes")
        database.child("942").get().addOnSuccessListener {
            if (it.exists()){
                findViewById<TextView>(R.id.textView).text =  it.child("nombre").value.toString() + " " + it.child("raza").value.toString() + " " + it.child("clase").value.toString()
                Toast.makeText(this,"Bien", Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            var nombre = Random.nextInt(1000).toString()
            database = FirebaseDatabase.getInstance().getReference("Personajes")
            val User = Personaje(nombre, "", "")
            database.child(nombre).setValue(User).addOnSuccessListener {
                Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
/*
        val database = FirebaseDatabase.getInstance()
        val personajeRef = database.getReference("Personajes").child("personaje1")

        val personaje = Personaje("Jose Paco", "Enano", "Ladron")
        personajeRef.setValue(personaje)
    }

 */
    }
}