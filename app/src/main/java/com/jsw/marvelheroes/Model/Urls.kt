package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName


class Urls {
    @SerializedName("type")
    var type: String? = null

    @SerializedName("url")
    var url: String? = null

    constructor() {}
    constructor(type: String?, url: String?) {
        this.type = type
        this.url = url
    }
}