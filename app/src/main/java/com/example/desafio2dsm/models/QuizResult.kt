package com.example.desafio2dsm.models

import android.os.Parcel
import android.os.Parcelable

data class QuizResult(
    val language: String,
    val difficulty: String,
    val selectedAnswers: MutableMap<Int, Int>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        mutableMapOf<Int, Int>().apply {
            val size = parcel.readInt()
            repeat(size) {
                val key = parcel.readInt()
                val value = parcel.readInt()
                put(key, value)
            }
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(language)
        parcel.writeString(difficulty)
        parcel.writeInt(selectedAnswers.size)
        selectedAnswers.forEach { (key, value) ->
            parcel.writeInt(key)
            parcel.writeInt(value)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<QuizResult> {
        override fun createFromParcel(parcel: Parcel): QuizResult = QuizResult(parcel)
        override fun newArray(size: Int): Array<QuizResult?> = arrayOfNulls(size)
    }
}
