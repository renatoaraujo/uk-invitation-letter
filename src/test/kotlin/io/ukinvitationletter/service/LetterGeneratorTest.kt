package io.ukinvitationletter.service

import io.ukinvitationletter.model.GuestInfo
import io.ukinvitationletter.model.HostInfo
import io.ukinvitationletter.model.InvitationDetails
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

class LetterGeneratorTest {

    private lateinit var letterGenerator: LetterGenerator
    private lateinit var sampleInvitationDetails: InvitationDetails

    @BeforeEach
    fun setUp() {
        letterGenerator = LetterGenerator()

        val hostInfo = HostInfo(
            "John Smith",
            "Senior Developer",
            "Some Company",
            "Skilled Worker Visa",
            "ABC123",
            "123 Some Street",
            "1234567890"
        )

        val guests = listOf(
            GuestInfo("Jane Smith", "XYZ123", "1990-01-01")
        )

        sampleInvitationDetails = InvitationDetails(
            hostInfo,
            guests,
            "wife",
            "London",
            "UK",
            "2023-12-01",
            "2023-12-15",
            null
        )
    }

    @Test
    fun `generateLetter should produce expected output`() {
        val actualOutput = letterGenerator.generateLetter(sampleInvitationDetails)

        val expectedOutput = """
            |Invitation Letter for Visiting London
            |
            |To Whom It May Concern,
            |
            |I, John Smith, am writing this formal invitation letter to request the pleasure of a visit from my wife, Jane Smith
            |- Passport number: XYZ123
            |- Date of Birth: 1990-01-01, to London, in UK.
            |
            |The visit is scheduled from 2023-12-01 to 2023-12-15. During this period, Jane Smith
            |- Passport number: XYZ123
            |- Date of Birth: 1990-01-01 will be staying with me at my residence.
            |
            |Details of the Host:
            |
            |I am currently employed as a Senior Developer at Some Company and am a holder of a Skilled Worker Visa. My identification number is ABC123. I will be providing accommodation for the guests at my privately rented residence located at 123 Some Street.
            |
            |Should you require additional information or clarification, please do not hesitate to get in touch with me at 1234567890.
            |
            |Yours sincerely,
            |John Smith
            |1234567890
        """.trimMargin()

        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `generatePdf should create a PDF file`() {
        val outputPath = "test_output.pdf"
        val letter = letterGenerator.generateLetter(sampleInvitationDetails)

        letterGenerator.generatePdf(letter, outputPath)

        val fileExists = Files.exists(Paths.get(outputPath))
        assertEquals(true, fileExists)

        Files.deleteIfExists(Paths.get(outputPath))
    }
}
