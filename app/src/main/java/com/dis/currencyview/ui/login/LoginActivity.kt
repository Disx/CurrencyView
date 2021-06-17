package com.dis.currencyview.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.dis.currencyview.R
import com.dis.currencyview.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            binding.button.alpha = 0f
//            Handler(this.mainLooper).postDelayed({
//                binding.progressBar.visibility = View.GONE
////                binding.button.alpha = 1f
////                Snackbar.make(view, "Login data submitted", Snackbar.LENGTH_SHORT).show()
//                this.finish()
//            }, 1000)
        }
    }

}