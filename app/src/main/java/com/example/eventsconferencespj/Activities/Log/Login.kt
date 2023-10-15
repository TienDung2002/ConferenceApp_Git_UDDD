package com.example.eventsconferencespj.Activities.Log

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.eventsconferencespj.Activities.Home.Home_Screen
import com.example.eventsconferencespj.R
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {
    private var isShowPassword = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val goToHomeScreen = findViewById<Button>(R.id.finishedLogin_Btn)
        val goToRegisterBtn = findViewById<TextView>(R.id.goToRegister)
        // Trường EditText
        val emailEditText = findViewById<EditText>(R.id.ET_email_login)
        val passwordEditText = findViewById<EditText>(R.id.logPass)
        // Icon show/hide pass
        val passwordToggleBtn = findViewById<ImageButton>(R.id.ShowPassBtn)

        val emailTextInputLayout = findViewById<TextInputLayout>(R.id.emailTextInputLayout)
        val passwordTextInputLayout = findViewById<TextInputLayout>(R.id.passwordTextInputLayout)

        goToRegisterBtn.setOnClickListener {
            // Thực hiện chuyển đến màn hình đăng ký
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        // Truy cập vào home screen, check trường trống
        goToHomeScreen.setOnClickListener {
//            val email = emailEditText.text.toString()
//            val password = passwordEditText.text.toString()
//
//            if (email.isEmpty()) {
//                emailTextInputLayout.error = "Vui lòng nhập email"
//            } else {
//                emailTextInputLayout.error = null
//            }
//
//            if (password.isEmpty()) {
//                passwordTextInputLayout.error = "Vui lòng nhập mật khẩu"
//            } else {
//                passwordTextInputLayout.error = null
//            }
//
//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                // Sau khi đăng nhập thành công, bạn có thể chuyển đến màn hình chính
//                val intent = Intent(this, Home_Screen::class.java)
//                startActivity(intent)
//                finish()
//            }
            val intent = Intent(this, Home_Screen::class.java)
            startActivity(intent)
            finish()
        }

        // show/hide pass
        passwordToggleBtn.setOnClickListener {
            if (!isShowPassword) {
                isShowPassword = true
                passwordEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                passwordToggleBtn.setImageResource(R.drawable.eye_slash)
                passwordEditText.setSelection(passwordEditText.text.length)
                passwordEditText.requestFocus()
            } else {
                isShowPassword = false
                if (isShowPassword) {
                    // Pass đang ẩn thì hiện
                    passwordEditText.inputType =
                        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    passwordToggleBtn.setImageResource(R.drawable.eye_slash)
                } else {
                    // Pass đang hiện thì ẩn
                    passwordEditText.inputType =
                        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    passwordToggleBtn.setImageResource(R.drawable.eye_open)
                }
                // Di chuyển con trỏ đến kí tự cuối của password => trải nghiệm tốt hơn
                passwordEditText.setSelection(passwordEditText.text.length)
            }
        }
    }
}