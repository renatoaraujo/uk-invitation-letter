package io.ukinvitationletter.service

import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Text
import io.ukinvitationletter.model.InvitationDetails

class LetterGenerator {
    fun asPDF(details: InvitationDetails, outputPath: String) {
        val pdfWriter = PdfWriter(outputPath)
        val pdfDocument = PdfDocument(pdfWriter)
        pdfDocument.defaultPageSize = PageSize.A4

        val document = Document(pdfDocument)

        val title = Paragraph("Invitation Letter for Visiting ${details.location}, ${details.country}")
        title.setBold()
        title.setFontSize(20.0f)
        document.add(title)

        val space = Paragraph("\n")
        document.add(space)

        document.add(Paragraph("Dear Sir / Madam,"))

        val intro = Paragraph()

        intro.add("I, ${details.hostInfo.fullName}, am writing this formal invitation letter to invite my ${details.relationship}, ")

        details.guests.forEachIndexed { index, guest ->
            if (index > 0 && index == details.guests.size - 1) {
                intro.add(" and ")
            } else if (index > 0) {
                intro.add(", ")
            }
            val guestName = Text(guest.fullName).setBold()
            intro.add(guestName)
        }

        intro.add(", to ${details.location}, in ${details.country}. ")
        intro.add("The visit is scheduled from ${details.startDate} to ${details.endDate}. During this period, " +
                "${if (details.guests.size > 1) "they" else "my guest"} will be staying with me at my " +
                "residence${details.additionalGuests?.let { ", accompanied by $it" } ?: ""}.")
        document.add(intro)

        document.add(Paragraph("Their personal details are as follows:").setMarginBottom(20f))

        details.guests.forEach { guest ->
            val guestName = Paragraph().add(guest.fullName).setBold()
            document.add(guestName)

            val passport = Paragraph("Passport number: ${guest.passportNumber}")
            document.add(passport)

            val dateOfBirth = Paragraph("Date of birth: ${guest.dateOfBirth}").setMarginBottom(20f)
            document.add(dateOfBirth)
        }

        val hostParagraph = Paragraph()
        hostParagraph.add(
            "I currently hold a ${details.hostInfo.visaType}, working as a " +
                    "${details.hostInfo.jobTitle} at ${details.hostInfo.companyName}. My identification number is " +
                    "${details.hostInfo.idNumber}. I am providing accommodation for my ${details.relationship} during " +
                    "their stay at my address ${details.hostInfo.address}."
        )
        document.add(hostParagraph)

        document.add(
            Paragraph("If further information is required, please do not hesitate to contact me.").setMarginBottom(
                30f
            )
        )
        document.add(Paragraph("Yours sincerely,"))
        document.add(Paragraph(details.hostInfo.fullName).setBold())
        document.add(Paragraph("Contact number: ${details.hostInfo.contactNumber}"))
        document.close()
    }
}
