package com.example.projekat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.projekat.databinding.FragmentDataBinding


class DataFragment : Fragment() {
    /*Na ovaj fragment dolazimo sa  vaccine fragmenta ,
    * zatim prelazimo na covid fragment */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentDataBinding>(
            inflater, R.layout.fragment_data, container, false)

        binding.dataFButtonId.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_dataFragment_to_covidFragment)}

        return binding.root
    }


}