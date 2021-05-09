package com.example.projekat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.projekat.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var first_name : String = ""
    private var last_name : String = ""
    private var birth_date : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentSecondBinding>(
            inflater, R.layout.fragment_second, container, false)

        binding.secondFButtonId.setOnClickListener{view : View ->

            first_name = binding.firstNameId.text.toString()
            last_name = binding.lastNameId.text.toString()
            birth_date = binding.birthDateId.text.toString()

            view.findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToVaccineFragment(first_name,last_name,birth_date))

        }
        return binding.root
    }
}