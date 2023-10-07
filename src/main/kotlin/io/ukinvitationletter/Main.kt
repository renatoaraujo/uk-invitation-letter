package io.ukinvitationletter

import com.google.gson.Gson
import io.ukinvitationletter.model.InvitationDetails
import io.ukinvitationletter.service.LetterGenerator
import java.io.FileReader

fun main() {
    val gson = Gson()

    val configPath = System.getProperty("configPath")
        ?: throw IllegalArgumentException("System property 'configPath' must be set.")

    val outputPath = System.getProperty("outputPath")
        ?: throw IllegalArgumentException("System property 'outputPath' must be set.")

    val configReader = FileReader(configPath)
    val invitationDetails = gson.fromJson(configReader, InvitationDetails::class.java)

    val letterGenerator = LetterGenerator()
    letterGenerator.asPDF(invitationDetails, outputPath)
}
