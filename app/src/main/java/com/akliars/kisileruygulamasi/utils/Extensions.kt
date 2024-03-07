package com.akliars.kisileruygulamasi.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.akliars.kisileruygulamasi.R


//Extensions kullanımı
fun Navigation.gecis(it:View, id:Int){
    Navigation.findNavController(it).navigate(id)
}
//Overloading
fun Navigation.gecis(it:View, id:NavDirections){
    Navigation.findNavController(it).navigate(id)
}