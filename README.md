UK Invitation Letter Generator
===

This is a Kotlin-based application designed to generate invitation letters for visitors to the UK. 
It reads a JSON configuration file to gather details about the host, guests, and other relevant information. 
It then generates an invitation letter in PDF format based on these details.

## Motivation

In recent years, I found myself writing more invitation letters for friends and family visiting me in the UK than 
actual lines of code. While crafting these letters is tied to the exciting prospect of welcoming a loved one, it's a 
tedious task, especially when the original template goes missing.

So, I decided to create this small service both as a way to practice Kotlin and to streamline the invitation letter 
generation for my future guests.

## Features

- Reads host, guest, and visit details from a JSON configuration file.
- Generates a formal invitation letter based on the provided details.
- Outputs the generated letter as a PDF file.

## Requirements
- JDK 8 or higher
- Gradle
- Make (optional, for simplified command execution)

## Usage
### Configuration
Refer to the provided `config.sample.json` for an overview of the configuration options.

### Using Make for Simplified Execution (recommended)
With the provided `Makefile`, you can easily build and generate the letter using:
```bash
make letter /path/to/my-custom-config.json /path/to/invitation-letter.pdf
```

### Using Gradle
Build the with Gradle
```bash
./gradlew build
```
Run the application using the following command:
```bash
./gradlew run -PconfigPath=/path/to/config.sample.json -PoutputPath=/path/to/invitation-letter.pdf
```
Here,
- `configPath`: The path to the JSON file that contains configuration details.
- `outputPath`: The path where the generated PDF will be saved.

By default, the program will use the [`config.sample.json`](config.sample.json) located in the root dir and output the PDF file named `invitation-letter.pdf` in the root dir.

Alternatively you can just change the configuration in the `gradle.properties` and execute:
```bash
./gradlew run
```

### Running the tests
You can run the tests using the following command:
```bash
./gradlew test
```

## Credits

* [Renato Araujo](https://www.linkedin.com/in/renatoraraujo/)

## License

The MIT License (MIT) - see [`LICENSE`](LICENSE) for more details