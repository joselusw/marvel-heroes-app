package com.jsw.marvelheroes.Model

import com.google.gson.annotations.SerializedName

class Hero {
    @SerializedName("id")
    private var id: String? = null

    @SerializedName("name")
    private var name: String? = null

    @SerializedName("description")
    private var description: String? = null

    @SerializedName("thumbnail")
    private var thumbnail: Thumbnail? = null

    @SerializedName("resourceURI")
    private var resourceURI: String? = null

    @SerializedName("modified")
    private var modified: String? = null

    @SerializedName("urls")
    private lateinit var urls: Array<Urls>

    @SerializedName("series")
    private var series: Any? = null

    @SerializedName("stories")
    private var stories: Any? = null

    @SerializedName("events")
    private var events: Any? = null

    @SerializedName("comics")
    private var comics: Any? = null

    fun Results() {}

    fun Results(
        id: String?,
        name: String?,
        description: String?,
        thumbnail: Thumbnail?,
        resourceURI: String?,
        modified: String?,
        urls: Array<Urls>,
        series: Any?,
        stories: Any?,
        events: Any?,
        comics: Any?
    ) {
        this.id = id
        this.name = name
        this.description = description
        this.thumbnail = thumbnail
        this.resourceURI = resourceURI
        this.modified = modified
        this.urls = urls
        this.series = series
        this.stories = stories
        this.events = events
        this.comics = comics
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getThumbnail(): Thumbnail? {
        return thumbnail
    }

    fun setThumbnail(thumbnail: Thumbnail?) {
        this.thumbnail = thumbnail
    }

    fun getResourceURI(): String? {
        return resourceURI
    }

    fun setResourceURI(resourceURI: String?) {
        this.resourceURI = resourceURI
    }

    fun getModified(): String? {
        return modified
    }

    fun setModified(modified: String?) {
        this.modified = modified
    }

    fun getUrls(): Array<Urls>? {
        return urls
    }

    fun setUrls(urls: Array<Urls>) {
        this.urls = urls
    }

    fun getSeries(): Any? {
        return series
    }

    fun setSeries(series: Any?) {
        this.series = series
    }

    fun getStories(): Any? {
        return stories
    }

    fun setStories(stories: Any?) {
        this.stories = stories
    }

    fun getEvents(): Any? {
        return events
    }

    fun setEvents(events: Any?) {
        this.events = events
    }

    fun getComics(): Any? {
        return comics
    }

    fun setComics(comics: Any?) {
        this.comics = comics
    }
}