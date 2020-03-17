package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName
import java.util.*

class ComicDate {
    @SerializedName("type")
    private var type : String? = null
    @SerializedName("date")
    private var date: String? = null

    constructor(type: String?, date: String?) {
        this.type = type
        this.date = date
    }

    fun getDate(): String? {return date}
}