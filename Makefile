.PHONY: build letter

test:
	./gradlew test

build:
	./gradlew build

letter: build
	./gradlew run -PconfigPath=$(firstword $(filter-out $@,$(MAKECMDGOALS))) -PoutputPath=$(word 2, $(filter-out $@,$(MAKECMDGOALS)))

%:
	@:
