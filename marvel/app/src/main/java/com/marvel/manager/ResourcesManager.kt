package com.marvel.manager

import com.marvel.BuildConfig
import java.io.File

object ResourcesManager {
    var publicKey: String = ""
    var privateKey: String = ""

    private const val PATH = "src/main/resources/"

    fun loadResource(path: String): String {
        return File(
            PATH,
            path
        ).readText()
    }

    fun loadKeyAPI() {
        privateKey = BuildConfig.marvel_api_private
        publicKey = BuildConfig.marvel_api_public
    }
}