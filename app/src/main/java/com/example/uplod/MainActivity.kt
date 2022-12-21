package com.example.uplod

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.uplod.databinding.ActivityMainBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.selects.select

class MainActivity : AppCompatActivity() {
    private lateinit var imageview:ImageView
    private lateinit var select:Button
    private lateinit var select2:Button
    private lateinit var binding:ActivityMainBinding
    private lateinit var uri:Uri
private var storageReference= Firebase.storage
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        imageview=binding.imge
storageReference= FirebaseStorage.getInstance()
     select2=binding.uplod2
        val imageGallery=registerForActivityResult(

            ActivityResultContracts.GetContent(),
        ActivityResultCallback{
imageview.setImageURI(it)
        uri= it!!;
        })
     binding.btn1.setOnClickListener {
         imageGallery.launch("image/*")



     }
        binding.uplod2.setOnClickListener{

storageReference.getReference("Images").child(System.currentTimeMillis().toString())
    .putFile(uri)
    .addOnSuccessListener {
        Toast.makeText(this,"Suuccessfuull",Toast.LENGTH_SHORT).show()


    }.addOnFailureListener{

        Toast.makeText(this,"fAIL",Toast.LENGTH_SHORT).show()

    }


        }








    }
}


