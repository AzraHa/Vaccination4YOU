package com.example.projekat

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.projekat.databinding.FragmentTitleBinding
import timber.log.Timber
import java.text.NumberFormat
import kotlin.random.Random


class TitleFragment : Fragment() {

    private var randomNUM = Random.nextInt(100000,10000000)
    private lateinit var randomTV : TextView
    var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable : Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title, container, false
        )

        binding.startId.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_secondFragment)
        }
        setHasOptionsMenu(true)

        randomTV = binding.regVakcinaid
        increase()

        return binding.root
    }

    private fun increase(){
        randomNUM += Random.nextInt(0,10)
        randomTV.text = NumberFormat.getIntegerInstance().format(randomNUM)
        refresh()
    }

    private fun refresh() {
        runnable = Runnable {
            kotlin.run { increase() }
        }
        handler.postDelayed(runnable, 1000)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }
    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }
    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }
    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(runnable)
        Timber.i("onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Timber.i("onDetach called")
    }


}