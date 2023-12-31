package com.example.eventsconferencespj.Fragments.Payments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.eventsconferencespj.Activities.Home.Home_Screen
import com.example.eventsconferencespj.MySQL.DatabaseHelper.DbHelper
import com.example.eventsconferencespj.R


class Payments_Cash_Fragment : Fragment() {
    private var emailFromConfeDetail: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val cashPopup = inflater.inflate(R.layout.payments_cash_popup, container, false)
        val buttonFinish = cashPopup.findViewById<Button>(R.id.finishBtnCash)

        emailFromConfeDetail = arguments?.getString("email")

        buttonFinish.setOnClickListener {
//             activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            val intent = Intent(activity, Home_Screen::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("email", emailFromConfeDetail)
            startActivity(intent)
        }
        return cashPopup
    }
}