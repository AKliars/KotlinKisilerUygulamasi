package com.akliars.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.akliars.kisileruygulamasi.data.entity.Kisiler
import com.akliars.kisileruygulamasi.databinding.CardTasarimBinding
import com.akliars.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.akliars.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.akliars.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.akliars.kisileruygulamasi.utils.gecis
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(
                     var mContext: Context,
                     var kisilerListesi:List<Kisiler>,
                     var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {//0,1,2
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim

        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi=kisi)
          //  Navigation.findNavController(it).navigate(gecis)
            Navigation.gecis(it,gecis)
        }

        t.imageViewSil.setOnClickListener{
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.sil(kisi.kisi_id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }


}