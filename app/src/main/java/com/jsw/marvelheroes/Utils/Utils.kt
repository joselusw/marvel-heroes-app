package com.jsw.marvelheroes.Utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.security.MessageDigest

class Utils {
    var private_key = "0e1daa77fd293f9f7050475e1925540e9d2e2d7c"
    var public_key = "9cb2af5b08a272722e93f49c15eead15"

    fun MD5(string: String): String {
        val bytes = MessageDigest.getInstance("MD5").digest(string.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}