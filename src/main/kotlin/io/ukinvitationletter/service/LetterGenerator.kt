package io.ukinvitationletter.service

import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import io.ukinvitationletter.model.GuestInfo
import io.ukinvitationletter.model.HostInfo
import io.ukinvitationletter.model.InvitationDetails

class LetterGenerator {

    fun generateLetter(details: InvitationDetails): String {
        val hostInfo = formatHostInfo(details.hostInfo)
        val guestInfo = formatGuestInfo(details.guests)

        return """
            |Invitation Letter for Visiting ${details.location}
            |
            |To Whom It May Concern,
            |
            |I, ${details.hostInfo.fullName}, am writing this formal invitation letter to request the pleasure of a visit from my ${details.relationship}, ${guestInfo}, to ${details.location}, in ${details.country}.
            |
            |The visit is scheduled from ${details.startDate} to ${details.endDate}. During this period, ${guestInfo} will be staying with me at my residence${details.additionalGuests?.let { ", accompanied by $it" } ?: ""}.
            |
            |$hostInfo
            |
            |Should you require additional information or clarification, please do not hesitate to get in touch with me at ${details.hostInfo.contactNumber}.
            |
            |Yours sincerely,
            |${details.hostInfo.fullName}
            |${details.hostInfo.contactNumber}
        """.trimMargin()
    }

    fun generatePdf(letter: String, outputPath: String) {
        val pdfWriter = PdfWriter(outputPath)
        val pdfDocument = PdfDocument(pdfWriter)
        val document = Document(pdfDocument)

        letter.lines().forEach { line ->
            document.add(Paragraph(line))
        }

        document.close()
    }

    private fun formatGuestInfo(guests: List<GuestInfo>): String {
        return guests.joinToString(separator = "\n") { guest ->
            """
            |${guest.fullName}
            |- Passport number: ${guest.passportNumber}
            |- Date of Birth: ${guest.dateOfBirth}
            """.trimMargin()
        }
    }

    private fun formatHostInfo(host: HostInfo): String {
        return """
        |Details of the Host:
        |
        |I am currently employed as a ${host.jobTitle} at ${host.companyName} and am a holder of a ${host.visaType}. My identification number is ${host.idNumber}. I will be providing accommodation for the guests at my privately rented residence located at ${host.address}.
        """.trimMargin()
    }
}
