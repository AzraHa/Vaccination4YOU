package com.example.projekat

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.projekat.databinding.FragmentEndBinding
import java.text.SimpleDateFormat
import java.util.*


class EndFragment : Fragment() {

    private var firstName : String = ""
    private var lastNAme : String = ""
    private var name : String = ""
    private var pozitivan : String = ""
    private var birthDate : String = ""
    private var covidPositive : Boolean = false
    private var rCategories : String = ""
    private var vaccine : String = ""

    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        val binding = DataBindingUtil.inflate<FragmentEndBinding>(
            inflater, R.layout.fragment_end, container, false
        )

        val args = EndFragmentArgs.fromBundle(requireArguments())

        firstName = args.firstName
        lastNAme = args.lastName
        birthDate = args.birthDate
        covidPositive = args.covidPositive
        rCategories = args.rCategories
        vaccine = args.vaccine

        name = "$firstName $lastNAme"


        val date = Date()
        var df = SimpleDateFormat("dd/MM/yyy")
        val c1 = Calendar.getInstance()
        val currentDate = df.format(date)
        pozitivan = if(covidPositive){
            c1.add(Calendar.DAY_OF_YEAR, 90)
            "Pozitivan"
        } else{
            c1.add(Calendar.DAY_OF_YEAR, 30)
            "Negativan"
        }

        df = SimpleDateFormat("dd/MM/yyy")
        val resultDate = c1.time
        val dueDate = df.format(resultDate)

        binding.imeText.text = this.name
        binding.datumRText.text = this.birthDate
        binding.pozitivanTextId.text = this.pozitivan
        binding.rizicneKategorijeText.text = this.rCategories
        binding.vakcinaText.text = this.vaccine
        binding.datumId.text = dueDate
        binding.datumText.text = currentDate.toString()



        return binding.root
    }



}