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

    private var first_name : String = ""
    private var last_name : String = ""
    private var birth_date : String = ""
    private var suffer_from : Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentVaccineBinding>(
            inflater, R.layout.fragment_vaccine, container, false)

        val args = VaccineFragmentArgs.fromBundle(requireArguments())

        binding.covidNextBId.setOnClickListener{view : View ->

            first_name = args.firstName
            last_name = args.lastName
            birth_date = args.birthDate

            val checkedId = binding.covidQRadioId.checkedRadioButtonId;

            if (-1 != checkedId) {

                var odgovor = 0

                when (checkedId) {
                    R.id.covid_da_id-> odgovor = 1
                    R.id.covid_ne_id -> odgovor = 2
                }
                if(odgovor == 1){
                    suffer_from = true
                }
                view.findNavController().navigate(VaccineFragmentDirections.actionVaccineFragmentToDataFragment(first_name,last_name,birth_date,suffer_from))
            }
        }


        return binding.root
    }
}