package com.example.projekat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.projekat.databinding.FragmentDataBinding


class DataFragment : Fragment() {
    /*Na ovaj fragment dolazimo sa  vaccine fragmenta ,
    * zatim prelazimo na covid fragment */

    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    private lateinit var checkbox3: CheckBox
    private lateinit var checkbox4: CheckBox
    private lateinit var checkbox5: CheckBox
    private lateinit var checkbox6: CheckBox
    private var first_name : String = ""
    private var last_name : String = ""
    private var birth_date : String = ""
    private var covid_positive : Boolean = false
    private var r_categories : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentDataBinding>(
            inflater, R.layout.fragment_data, container, false
        )

        val args = DataFragmentArgs.fromBundle(requireArguments())

        first_name = args.firstName
        last_name = args.lastName
        birth_date = args.birthDate
        covid_positive = args.covidPositive

        binding.dataFButtonId.setOnClickListener{ view: View ->

            checkbox1 = binding.dijabeticarCheckboxId
            checkbox2 = binding.trudnocaCheckboxId
            checkbox3 = binding.hemodijalizaCheckboxId
            checkbox4 = binding.respiratorneId
            checkbox5 = binding.onkoloskiId
            checkbox6 = binding.nistaCheckboxId

            if(checkbox1.isChecked){
                r_categories += "Dijabeticar\n"
            }
            if(checkbox2.isChecked){
                r_categories += "Trudnica\n"
            }
            if(checkbox3.isChecked){
                r_categories += "Hemodijalizni pacijent\n"
            }
            if(checkbox4.isChecked){
                r_categories += "Pacijent sa respiratornim smetnjama\n"
            }
            if(checkbox5.isChecked){
                r_categories += "Onkoloski pacijent\n"
            }
            if(checkbox6.isChecked){
                r_categories += "Ne spadate u kategoriju rizicno ugrozenih pacijenata"
            }

            view.findNavController().navigate(DataFragmentDirections.actionDataFragmentToCovidFragment(first_name,last_name,birth_date,covid_positive,r_categories))
        }

        return binding.root
    }



}