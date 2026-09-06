package com.example.desafio2dsm.models

import android.os.Parcel
import android.os.Parcelable

data class Question(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        mutableListOf<String>().apply {
            val size = parcel.readInt()
            repeat(size) { add(parcel.readString() ?: "") }
        },
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(text)
        parcel.writeInt(options.size)
        options.forEach { parcel.writeString(it) }
        parcel.writeInt(correctAnswerIndex)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question = Question(parcel)
        override fun newArray(size: Int): Array<Question?> = arrayOfNulls(size)
    }
}
