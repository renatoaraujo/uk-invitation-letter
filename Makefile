.PHONY: build letter test

# Run tests
test:
	./gradlew test

# Build the project
build:
	./gradlew build

# Generate the invitation letter PDF
letter: build
	if [ -z "$(CONFIG_PATH)" ] || [ -z "$(OUTPUT_PATH)" ]; then \
		echo "Usage: make letter CONFIG_PATH=your-config.json OUTPUT_PATH=output/invitation-letter.pdf"; \
	else \
		./gradlew run --args="-c '$(CONFIG_PATH)' -o '$(OUTPUT_PATH)'"; \
	fi
