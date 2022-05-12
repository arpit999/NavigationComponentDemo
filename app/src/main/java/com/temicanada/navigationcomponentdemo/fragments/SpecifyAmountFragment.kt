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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputEditText
import com.temicanada.navigationcomponentdemo.R
import com.temicanada.navigationcomponentdemo.model.Money
import org.w3c.dom.Text
import java.math.BigDecimal


class SpecifyAmountFragment : Fragment(R.layout.fragment_specify_amount), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var input_amount: TextInputEditText
    private lateinit var recipientTextView: TextView

    private val args: SpecifyAmountFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
        input_amount = view.findViewById(R.id.input_amount)
        recipientTextView = view.findViewById(R.id.recipient)

        recipientTextView.text = "Send money to ${args.recipient}"

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(input_amount.text.toString())) {
                    val action =
                        SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConformationFragment(
                            args.recipient,
                            Money(input_amount.text.toString().toBigDecimal())
                        )
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(activity, "Please enter amount ", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }
}