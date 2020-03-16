package com.raylle.deuruim

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

class Evento (var descricao: String, var nota: Int, var foto:Bitmap) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readParcelable(Bitmap::class.java.classLoader)!!
    ) {
    }

    override fun toString(): String {
        return "${descricao} - ${nota}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(descricao)
        parcel.writeInt(nota)
        parcel.writeParcelable(foto, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Evento> {
        override fun createFromParcel(parcel: Parcel): Evento {
            return Evento(parcel)
        }

        override fun newArray(size: Int): Array<Evento?> {
            return arrayOfNulls(size)
        }
    }

}