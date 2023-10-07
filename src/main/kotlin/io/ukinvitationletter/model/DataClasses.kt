package io.ukinvitationletter.model

data class GuestInfo(
    val fullName: String,
    val passportNumber: String,
    val dateOfBirth: String
)

data class HostInfo(
    val fullName: String,
    val jobTitle: String,
    val companyName: String,
    val visaType: String,
    val idNumber: String,
    val address: String,
    val contactNumber: String
)

data class InvitationDetails(
    val hostInfo: HostInfo,
    val guests: List<GuestInfo>,
    val relationship: String,
    val location: String,
    val country: String,
    val startDate: String,
    val endDate: String,
    val additionalGuests: String?
)
