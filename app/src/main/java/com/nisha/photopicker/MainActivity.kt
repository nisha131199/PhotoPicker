package com.nisha.photopicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageOnly
import kotlinx.android.synthetic.main.activity_main.tvTapMe
import com.nisha.photopicker.R.layout.activity_main

class MainActivity : AppCompatActivity() {

    private val pickMultipleMedia =
        registerForActivityResult(PickVisualMedia()) { uri ->
            if (uri != null) d("PhotoPicker", uri.toString())
            else d("PhotoPicker", "No media selected")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        tvTapMe.setOnClickListener {
            pickMultipleMedia.launch(PickVisualMediaRequest(ImageOnly))
        }
    }
}