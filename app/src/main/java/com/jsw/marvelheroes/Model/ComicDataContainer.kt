package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName

class ComicDataContainer {
    @SerializedName("offset")
    private var offset: Int? = null

    @SerializedName("limit")
    private var limit: Int? = null

    @SerializedName("total")
    private var total: Int? = null

    @SerializedName("count")
    private var count: Int? = null

    @SerializedName("results")
    private var results: ArrayList<Comic>? = null

    constructor(offset: Int?, limit: Int?, total: Int?, count: Int?, results: ArrayList<Comic>?) {
        this.offset = offset
        this.limit = limit
        this.total = total
        this.count = count
        this.results = results
    }

    fun getComics(): ArrayList<Comic>? {
        return results
    }
}