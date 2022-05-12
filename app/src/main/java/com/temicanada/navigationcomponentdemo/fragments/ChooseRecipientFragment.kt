package com.temicanada.navigationcomponentdemo.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.temicanada.navigationcomponentdemo.R


class ChooseRecipientFragment : Fragment(R.layout.fragment_choose_recipient), View.OnClickListener {

    lateinit var navController: NavController
    private lateinit var input_recipient: TextInputEditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        input_recipient = view.findViewById(R.id.input_recipient)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.next_btn -> {

                if (!TextUtils.isEmpty(input_recipient.text.toString())) {
                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment)
                } else {
                    Toast.makeText(activity, "Please enter recipient", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }
}