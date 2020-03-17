package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

class Comic {
    @SerializedName("id")
    private var id : Int? = null

    @SerializedName("digitalId")
    private var digitalId : Int? = null

    @SerializedName("title")
    private var title : String? = null

    @SerializedName("issueNumber")
    private var issueNumber : Double? = null

    @SerializedName("variantDescription")
    private var variantDescription : String? = null

    @SerializedName("description")
    private var description : String? = null

    @SerializedName("modified")
    private var modified : String? = null

    @SerializedName("isbn")
    private var isbn : String? = null

    @SerializedName("upc")
    private var upc : String? = null

    @SerializedName("diamondCode")
    private var diamondCode : String? = null

    @SerializedName("ean")
    private var ean : String? = null

    @SerializedName("issn")
    private var issn : String? = null

    @SerializedName("format")
    private var format : String? = null

    @SerializedName("pageCount")
    private var pageCount : Int? = null

    @SerializedName("textObjects")
    private var textObjects : Any? = null

    @SerializedName("resourceURI")
    private var resourceURI : String? = null

    @SerializedName("urls")
    private var urls : Any? = null

    @SerializedName("series")
    private var series : Any? = null

    @SerializedName("variants")
    private var variants : Any? = null

    @SerializedName("collections")
    private var collections : Any? = null

    @SerializedName("collectedIssues")
    private var collectedIssues : Any? = null

    @SerializedName("dates")
    private var dates : ArrayList<ComicDate>? = null

    @SerializedName("prices")
    private var prices : Any? = null

    @SerializedName("thumbnail")
    private var thumbnail : Thumbnail? = null

    @SerializedName("images")
    private var images : Any? = null

    @SerializedName("creators")
    private var creators : Any? = null

    @SerializedName("characters")
    private var characters : Any? = null

    @SerializedName("stories")
    private var stories : Any? = null

    @SerializedName("events")
    private var events : Any? = null

    constructor()
    constructor(
        id: Int?,
        digitalId: Int?,
        title: String?,
        issueNumber: Double?,
        variantDescription: String?,
        description: String?,
        modified: String?,
        isbn: String?,
        upc: String?,
        diamondCode: String?,
        ean: String?,
        issn: String?,
        format: String?,
        pageCount: Int?,
        textObjects: Any?,
        resourceURI: String?,
        urls: Any?,
        series: Any?,
        variants: Any?,
        collections: Any?,
        collectedIssues: Any?,
        dates: ArrayList<ComicDate>?,
        prices: Any?,
        thumbnail: Thumbnail?,
        images: Any?,
        creators: Any?,
        characters: Any?,
        stories: Any?,
        events: Any?
    ) {
        this.id = id
        this.digitalId = digitalId
        this.title = title
        this.issueNumber = issueNumber
        this.variantDescription = variantDescription
        this.description = description
        this.modified = modified
        this.isbn = isbn
        this.upc = upc
        this.diamondCode = diamondCode
        this.ean = ean
        this.issn = issn
        this.format = format
        this.pageCount = pageCount
        this.textObjects = textObjects
        this.resourceURI = resourceURI
        this.urls = urls
        this.series = series
        this.variants = variants
        this.collections = collections
        this.collectedIssues = collectedIssues
        this.dates = dates
        this.prices = prices
        this.thumbnail = thumbnail
        this.images = images
        this.creators = creators
        this.characters = characters
        this.stories = stories
        this.events = events
    }

    fun geTitle(): String? {return title}
    fun getDescription() : String? {return description}
    fun getThumbnail() : Thumbnail? {return thumbnail}
    fun getDates() : ArrayList<ComicDate>? {return dates}

}