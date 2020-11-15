package com.customtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNormal.setOnClickListener {
            showToast(ButtonType.BTN_NORMAL)
        }

        btnSuccess.setOnClickListener {
            showToast(ButtonType.BTN_SUCCESS)
        }

        btnError.setOnClickListener {
            showToast(ButtonType.BTN_ERROR)
        }
    }

    private fun showToast(type: ButtonType) {
        val toastView = layoutInflater.inflate(R.layout.layout_toast, findViewById(R.id.layoutToastContainer))

        val toastContainer = toastView.findViewById<LinearLayout>(R.id.layoutToastContainer)
        val icon = toastView.findViewById<ImageView>(R.id.ivIcon)
        val message = toastView.findViewById<TextView>(R.id.tvMessage)

        when(type) {
            ButtonType.BTN_NORMAL -> {
                toastContainer.setBackgroundResource(R.drawable.normal_toast)
                icon.setImageResource(R.drawable.ic_android)
                message.text = "Normal message"
            }
            ButtonType.BTN_SUCCESS -> {
                toastContainer.setBackgroundResource(R.drawable.success_toast)
                icon.setImageResource(R.drawable.ic_success)
                message.text = "Success message"
            }
            ButtonType.BTN_ERROR -> {
                toastContainer.setBackgroundResource(R.drawable.error_toast)
                icon.setImageResource(R.drawable.ic_error)
                message.text = "Error message"
            }
        }

        with(Toast(applicationContext)) {
            duration = Toast.LENGTH_SHORT
            view = toastView
            show()
        }
    }

    enum class ButtonType {
        BTN_NORMAL,
        BTN_SUCCESS,
        BTN_ERROR
    }
}