package com.example.projekat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.projekat.databinding.FragmentEndBinding


class EndFragment : Fragment() {

    /*Na ovaj fragment mozemo doci sa vaccine fragmenta ili sa covid fragmenta
    * ovisno o tome ispisujemo podatke (termin vakcinacije,podatke i sl)
    * imamo mogucnost dijeljenja tih rezultata pomocu share opcije*/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)

        val binding = DataBindingUtil.inflate<FragmentEndBinding>(
            inflater, R.layout.fragment_end, container, false)


        return binding.root
    }


}