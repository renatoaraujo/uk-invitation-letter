package io.ukinvitationletter

import com.google.gson.Gson
import io.ukinvitationletter.model.InvitationDetails
import io.ukinvitationletter.service.LetterGenerator
import java.io.FileReader

fun main(args: Array<String>) {
    val gson = Gson()

    var configPath: String? = null
    var outputPath: String? = null

    // Parse command-line arguments
    for (i in args.indices) {
        when (args[i]) {
            "-c" -> configPath = args.getOrNull(i + 1)
            "-o" -> outputPath = args.getOrNull(i + 1)
        }
    }

    if (configPath == null || outputPath == null) {
        throw IllegalArgumentException("Both -c (configPath) and -o (outputPath) must be provided.")
    }

    val configReader = FileReader(configPath)
    val invitationDetails = gson.fromJson(configReader, InvitationDetails::class.java)

    val letterGenerator = LetterGenerator()
    letterGenerator.asPDF(invitationDetails, outputPath)
}
