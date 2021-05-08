package com.example.projekat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        first_name = binding.firstNameId.toString();
        last_name = binding.lastNameId.toString();
        birth_date = binding.birthDateId.toString();

        binding.secondFButtonId.setOnClickListener{view : View ->
            view.findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToVaccineFragment(first_name,last_name,birth_date))}

        return binding.root

    }
}