package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName


/**
 * Created by Mohsen on 20/10/2016.
 */
class DataResponse {
    @SerializedName("total")
    var total = 0

    @SerializedName("limit")
    var limit = 0

    @SerializedName("results")
    private lateinit var results: Array<Hero>

    @SerializedName("count")
    var count = 0

    @SerializedName("offset")
    var offset = 0

    constructor() {}
    constructor(total: Int, limit: Int, results: Array<Hero>, count: Int, offset: Int) {
        this.total = total
        this.limit = limit
        this.results = results
        this.count = count
        this.offset = offset
    }

    fun getResults(): Array<Hero> {
        return results
    }

    fun setResults(results: Array<Hero>) {
        this.results = results
    }

}