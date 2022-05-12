package com.temicanada.navigationcomponentdemo.fragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.temicanada.navigationcomponentdemo.R
import com.temicanada.navigationcomponentdemo.model.Money
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(R.layout.fragment_specify_amount), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var input_amount: TextInputEditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        input_amount = view.findViewById(R.id.input_amount)

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(input_amount.text.toString())) {
                    navController.navigate(R.id.action_specifyAmountFragment_to_conformationFragment)
                } else {
                    Toast.makeText(activity, "Please enter amount ", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }
}