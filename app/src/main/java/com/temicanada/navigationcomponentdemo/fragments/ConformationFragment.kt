package com.temicanada.navigationcomponentdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.temicanada.navigationcomponentdemo.R


class ConformationFragment : Fragment(R.layout.fragment_conformation) {

    val args:ConformationFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.confirmation_message).text = "$${args.amount.amount} was sent to ${args.recipient}"
    }

}