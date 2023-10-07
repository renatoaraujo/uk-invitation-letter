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
    fun `generatePdf should create a PDF file`() {
        val outputPath = "test_output.pdf"
        letterGenerator.asPDF(sampleInvitationDetails, outputPath)

        val fileExists = Files.exists(Paths.get(outputPath))
        assertEquals(true, fileExists)

        Files.deleteIfExists(Paths.get(outputPath))
    }
}
