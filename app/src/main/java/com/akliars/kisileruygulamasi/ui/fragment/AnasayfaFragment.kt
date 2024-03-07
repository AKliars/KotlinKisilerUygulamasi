package com.akliars.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.akliars.kisileruygulamasi.R
import com.akliars.kisileruygulamasi.data.entity.Kisiler
import com.akliars.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.akliars.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.akliars.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.akliars.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import com.akliars.kisileruygulamasi.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding : FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

       viewModel.kisilerListesi.observe(viewLifecycleOwner){
           val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
           binding.kisilerRv.adapter = kisilerAdapter
       }



        binding.kisilerRv.layoutManager = LinearLayoutManager(requireContext())
     //   binding.kisilerRv.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        //Fab Butonu
        binding.fab.setOnClickListener {
         //   Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
            Navigation.gecis(it,R.id.kisiKayitGecis) // Navigation sınıfını kendi yazdığımız gecis fonksiyonu ile genişletmiş olduk. Yani özetler burada extension kullanmış olduk.
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe çalışır
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Klavyedeki ara butonu ile çalışır
                viewModel.ara(query)
                return true
            }
        })


        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }
}