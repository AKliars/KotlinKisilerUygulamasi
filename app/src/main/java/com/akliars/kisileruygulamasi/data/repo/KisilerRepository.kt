package com.akliars.kisileruygulamasi.data.repo

import com.akliars.kisileruygulamasi.data.datasource.KisilerDataSource
import com.akliars.kisileruygulamasi.data.entity.Kisiler

class KisilerRepository(var kds:KisilerDataSource) {
//    var kds = KisilerDataSource()

    suspend fun kaydet(kisi_ad:String,kisi_tel:String) = kds.kaydet(kisi_ad,kisi_tel)

    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String) = kds.guncelle(kisi_id, kisi_ad, kisi_tel)

    suspend fun sil(kisi_id:Int) = kds.sil(kisi_id)

    suspend fun kisilerYukle() : List<Kisiler> = kds.kisilerYukle()

    suspend fun ara(aramaKelimesi : String) : List<Kisiler> = kds.ara(aramaKelimesi)

}