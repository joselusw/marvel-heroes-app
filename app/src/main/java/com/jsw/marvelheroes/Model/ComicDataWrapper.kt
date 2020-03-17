package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName

class ComicDataWrapper {

    @SerializedName("code")
    private var code: Int? = null

    @SerializedName("status")
    private var status: String? = null

    @SerializedName("copyright")
    private var copyright: String? = null

    @SerializedName("attributionText")
    private var attributionText: String? = null

    @SerializedName("attributionHTML")
    private var attributionHTML: String? = null

    @SerializedName("data")
    private var data: ComicDataContainer? = null

    @SerializedName("etag")
    private var etag: String? = null

    constructor(
        code: Int?,
        status: String?,
        copyright: String?,
        attributionText: String?,
        attributionHTML: String?,
        data: ComicDataContainer?,
        etag: String?
    ) {
        this.code = code
        this.status = status
        this.copyright = copyright
        this.attributionText = attributionText
        this.attributionHTML = attributionHTML
        this.data = data
        this.etag = etag
    }

    fun getData(): ComicDataContainer? {
        return data
    }
}