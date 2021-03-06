package com.example.projekat

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.projekat.databinding.FragmentCovidBinding
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class CovidFragment : Fragment() {

    private var name : String = ""
    private var birthDate : String = ""
    private var covidPositive : Boolean = false
    private var rCategories : String = ""
    private var vaccine : String = ""
    private var pozitivan : String = ""
    private var datum : String = ""

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCovidBinding>(
            inflater, R.layout.fragment_covid, container, false)

        val args = CovidFragmentArgs.fromBundle(requireArguments())

        name = args.firstName + " " + args.lastName
        birthDate = args.birthDate
        covidPositive = args.covidPositive
        rCategories = args.rCategories

        binding.covidFButtonId.setOnClickListener{view : View ->

            /*https://stackoverflow.com/questions/56440762/how-add-30-days-in-current-date*/
            val c1 = Calendar.getInstance()

            pozitivan = if (covidPositive) {
                c1.add(Calendar.DAY_OF_YEAR, 90)
                getString(R.string.pozitivan)
            } else {
                c1.add(Calendar.DAY_OF_YEAR, 30)
                getString(R.string.negativan)
            }

            val df = SimpleDateFormat("dd/MM/yyy")
            val resultDate = c1.time
            val dueDate = df.format(resultDate)
            datum = dueDate.toString()

            val checkedId = binding.covidQRadioId.checkedRadioButtonId;

            if (-1 != checkedId) {

                var odgovor = 0

                when (checkedId) {
                    R.id.pfizer -> odgovor = 1
                    R.id.moderna -> odgovor = 2
                    R.id.johnson -> odgovor = 3
                    R.id.sinopharm -> odgovor = 4
                    R.id.sputnik -> odgovor = 5
                    R.id.astraZeneca -> odgovor = 6
                }

                vaccine = if(odgovor == 1){
                    getString(R.string.Pfizer_BioNTech)
                }else if(odgovor == 2){
                    getString(R.string.Moderna)
                }else if(odgovor == 3){
                    getString(R.string.Johnson)
                }else if(odgovor == 4) {
                    getString(R.string.Sinopharm)
                } else if(odgovor == 5){
                    getString(R.string.Sputnik)
                } else {
                    getString(R.string.AstraZeneca)
                }
            }

            view.findNavController().navigate(CovidFragmentDirections.actionCovidFragmentToEndFragment(name,birthDate,pozitivan,rCategories,vaccine,datum))

        }

        return binding.root
    }
}