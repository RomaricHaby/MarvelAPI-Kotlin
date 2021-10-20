package com.marvel.manager

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.*

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
        val file = File(PATH + "resources/marvel_api_key.properties")
        try {
            FileInputStream(file).use { input ->
                val prop = Properties()

                prop.load(input)

                privateKey = prop.getProperty("private")
                publicKey = prop.getProperty("public")
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}