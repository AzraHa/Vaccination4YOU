package com.example.projekat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.projekat.databinding.FragmentCovidBinding


class CovidFragment : Fragment() {

    private var first_name : String = ""
    private var last_name : String = ""
    private var birth_date : String = ""
    private var covid_positive : Boolean = false
    private var r_categories : String = ""
    private var vaccine : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCovidBinding>(
            inflater, R.layout.fragment_covid, container, false)

        val args = CovidFragmentArgs.fromBundle(requireArguments())

        first_name = args.firstName
        last_name = args.lastName
        birth_date = args.birthDate
        covid_positive = args.covidPositive
        r_categories = args.rCategories



        binding.covidFButtonId.setOnClickListener{view : View ->

            val checkedId = binding.covidQRadioId.checkedRadioButtonId;

            if (-1 != checkedId) {

                var odgovor = 0

                when (checkedId) {
                    R.id.pfizer-> odgovor = 1
                    R.id.moderna -> odgovor = 2
                    R.id.johnson-> odgovor = 3
                    R.id.sinopharm -> odgovor = 4
                    R.id.sputnik-> odgovor = 5
                }

                if(odgovor == 1){
                    vaccine = "Pfizer "
                }else if(odgovor == 2){
                    vaccine = "Moderna "
                }else if(odgovor == 3){
                    vaccine = "Johnson "
                }else if(odgovor == 4) {
                    vaccine = "Sinopharm "
                } else{
                    vaccine = "Sputnik V"
                }
            }
            view.findNavController().navigate(CovidFragmentDirections.actionCovidFragmentToEndFragment(first_name,last_name,birth_date,covid_positive,r_categories,vaccine))
        }

        return binding.root
    }
}