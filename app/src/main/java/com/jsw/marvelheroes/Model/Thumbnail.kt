package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName


class Thumbnail {
    @SerializedName("path")
    var path: String? = null

    @SerializedName("extension")
    var extension: String? = null

    constructor() {}
    constructor(path: String?, extension: String?) {
        this.extension = extension
        this.path = path
    }

    fun getURL() : String {
        path = path?.replace("http", "https")
        return String.format("%s.%s", path, extension)
    }

}