UK Invitation Letter Generator
===

This is a Kotlin-based application designed to generate invitation letters for visitors to the UK. It reads a JSON configuration file to gather details about the host, guests, and other relevant information. It then generates an invitation letter in PDF format based on these details.

## Features

- Reads host, guest, and visit details from a JSON configuration file.
- Generates a formal invitation letter based on the provided details.
- Outputs the generated letter as a PDF file.

## Requirements
- JDK 8 or higher
- Gradle

## Setup and Running
### Clone the Repository
```bash
git clone https://github.com/renatoaraujo/UKInvitationLetter.git
cd UKInvitationLetter
```

### Build with Gradle
```bash
./gradlew build
```

### Running the Application
You can run the application using the following command:
```bash
./gradlew run -DconfigPath=/path/to/config.json -DoutputPath=/path/to/invitation-letter.pdf
```
Here,
- `configPath`: The path to the JSON file that contains configuration details.
- `outputPath`: The path where the generated PDF will be saved.

By default, the program will use the `config.json` located in the root dir and output the PDF file named `invitation-letter.pdf` in the root dir.

Alternatively you can just change the configuration in the `gradle.properties` and execute:
```bash
./gradlew run
```

### Running the tests
You can run the tests using the following command:
```bash
./gradlew test
```

### Example JSON Configuration (config.json)

Here's an example structure for the config.json:

```json
{
  "startDate": "04/08/2023",
  "endDate": "04/10/2023",
  "outputPdfPath": "invitation-letter.pdf",
  "hostInfo": {
    "fullName": "Alice Johnson",
    "jobTitle": "Rockstar Java Engineer",
    "companyName": "My Amazing Employer",
    "visaType": "Skilled Worker Visa",
    "idNumber": "IAMNOWAKOTLINDEVELOPER",
    "address": "Buckingham Palace, SW1A 1AA, London",
    "contactNumber": "+44 (0) 789654218"
  },
  "guests": [
    {
      "fullName": "John Doe",
      "passportNumber": "KT352238",
      "dateOfBirth": "23/11/1977"
    },
    {
      "fullName": "Jane Doe",
      "passportNumber": "KT352239",
      "dateOfBirth": "23/09/1988"
    }
  ],
  "relationship": "parents",
  "location": "London",
  "country": "United Kingdom",
  "additionalGuests": null
}
```
