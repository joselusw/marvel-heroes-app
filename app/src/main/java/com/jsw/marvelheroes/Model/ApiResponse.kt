package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName

class ApiResponse {
    @SerializedName("code")
    private var code = 0

    @SerializedName("status")
    private var status: String? = null

    @SerializedName("attributionText")
    private var attributionText: String? = null

    @SerializedName("etag")
    private var eTag: String? = null

    @SerializedName("copyright")
    private var copyright: String? = null

    @SerializedName("attributionHTML")
    private var attributionHTML: String? = null

    @SerializedName("data")
    private var data: DataResponse? = null

    fun CharactersResponse() {}

    fun CharactersResponse(
        code: Int,
        status: String?,
        attributionText: String?,
        eTag: String?,
        copyright: String?,
        attributionHTML: String?,
        data: DataResponse?
    ) {
        this.code = code
        this.status = status
        this.attributionText = attributionText
        this.eTag = eTag
        this.copyright = copyright
        this.attributionHTML = attributionHTML
        this.data = data
    }

    fun getCode(): Int {
        return code
    }

    fun setCode(code: Int) {
        this.code = code
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getAttributionText(): String? {
        return attributionText
    }

    fun setAttributionText(attributionText: String?) {
        this.attributionText = attributionText
    }

    fun geteTag(): String? {
        return eTag
    }

    fun seteTag(eTag: String?) {
        this.eTag = eTag
    }

    fun getCopyright(): String? {
        return copyright
    }

    fun setCopyright(copyright: String?) {
        this.copyright = copyright
    }

    fun getAttributionHTML(): String? {
        return attributionHTML
    }

    fun setAttributionHTML(attributionHTML: String?) {
        this.attributionHTML = attributionHTML
    }

    fun getData(): DataResponse? {
        return data
    }

    fun setData(data: DataResponse?) {
        this.data = data
    }
}