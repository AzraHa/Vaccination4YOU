package com.example.projekat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.projekat.databinding.FragmentVaccineBinding


class VaccineFragment : Fragment() {

    /*U zavisnosti od odgovora sa ovog fragmenta imamo dvije mogucnosti:
    * data fragment ili end fragment */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentVaccineBinding>(
            inflater, R.layout.fragment_vaccine, container, false)

        binding.covidNextBId.setOnClickListener{view : View ->
            val checkedId = binding.covidQRadioId.checkedRadioButtonId;

            if (-1 != checkedId) {

                var odgovor = 0

                when (checkedId) {

                    R.id.covid_da_id-> odgovor = 1
                    R.id.covid_ne_id -> odgovor = 2

                }

                if(odgovor == 1 ){

                    view.findNavController().navigate(R.id.action_vaccineFragment_to_endFragment)

                }else {

                    view.findNavController().navigate(R.id.action_vaccineFragment_to_dataFragment)

                }
            }
        }
        return binding.root
    }
}