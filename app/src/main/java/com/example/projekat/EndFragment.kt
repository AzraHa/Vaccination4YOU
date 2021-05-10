package com.example.projekat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.projekat.databinding.FragmentEndBinding
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class EndFragment : Fragment() {

    private var name : String = ""
    private var birthDate : String = ""
    private var covidPositive : String = ""
    private var rCategories : String = ""
    private var vaccine : String = ""
    private var datum : String = ""
    private var datumFile : String = ""
    private var nameFile : String = ""
    private var contentsFile : String = ""
    private var currentDate : String = ""

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setHasOptionsMenu(true)

        val binding = DataBindingUtil.inflate<FragmentEndBinding>(
            inflater, R.layout.fragment_end, container, false
        )

        val args = EndFragmentArgs.fromBundle(requireArguments())

        name = args.name
        birthDate = args.birthDate
        covidPositive = args.covidPositive
        rCategories = args.rCategories
        vaccine = args.vaccine
        datum = args.datum


        val date = Date()
        val df = SimpleDateFormat("dd/MM/yyy")
        currentDate = df.format(date).toString()

        nameFile = name.replace(" ", "_")
        val fileDate = SimpleDateFormat("dd_MM_yyy")
        datumFile = fileDate.format(Calendar.getInstance().time).toString()

        binding.imeText.text = this.name
        binding.datumRText.text = this.birthDate
        binding.pozitivanTextId.text = this.covidPositive
        binding.rizicneKategorijeText.text = this.rCategories
        binding.vakcinaText.text = this.vaccine
        binding.datumId.text = datum
        binding.datumText.text = currentDate

        return binding.root

    }

    @SuppressLint("StringFormatMatches")
    private fun getShareIntent() : Intent {

        val args = EndFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_data,args.name,args.vaccine,args.datum))
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }


    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
            menu.findItem(R.id.savefile_id)?.isVisible = true
        }
    }
    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
            R.id.savefile_id -> saveFile()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveFile() {

        try {
            contentsFile = getString(R.string.ime) + " " + name + "\n" +
                    getString(R.string.datum_r) + " " + birthDate + "\n" +
                    getString(R.string.boluje_covid) + " " + covidPositive + "\n" +
                    getString(R.string.Kategorije_rizika) + " " + "\n" + rCategories + "\n" +
                    getString(R.string.datum_vakcine) + " " + datum + "\n" +
                    getString(R.string.Vakcina) + " " + vaccine + "\n" +
                    getString(R.string.datum) + " " + currentDate
            val path = context!!.getExternalFilesDir(null)
            val file = File(path, getString(R.string.app_name) + "_" + nameFile + "_" + datumFile + ".txt")
            FileOutputStream(file).use {
                it.write(contentsFile.toByteArray())
            }
            Toast.makeText(context, getString(R.string.toastF_success, path), Toast.LENGTH_LONG).show()
        }catch (ex : Exception) {
            Toast.makeText(context, getString(R.string.toastF_fail), Toast.LENGTH_SHORT).show()
        }
    }


}