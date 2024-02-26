package com.akliars.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.akliars.kisileruygulamasi.R
import com.akliars.kisileruygulamasi.data.entity.Kisiler
import com.akliars.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.akliars.kisileruygulamasi.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding : FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Zeynep","2222")
        val k3 = Kisiler(3,"Beyza","3333")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)


        val kisilerAdapter = KisilerAdapter(requireContext(),kisilerListesi)
        binding.kisilerRv.adapter = kisilerAdapter

        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())
     //   binding.kisilerRv.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        //Fab Butonu
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe çalışır
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Klavyedeki ara butonu ile çalışır
                ara(query)
                return true
            }
        })


        return binding.root
    }

    fun ara(aramaKelimesi : String) {
        Log.e("Kişi Ara",aramaKelimesi)
    }
}