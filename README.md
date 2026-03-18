# Kodilla Tester Course

Multi-module Java/Gradle project covering core testing and development topics.

## Tech Stack

- Java 17
- Gradle 8.12
- JUnit 5 + Mockito
- Spring Boot 3.2
- Selenium 4.17 + WebDriverManager
- REST Assured 5.4

## Modules

| Module | Description |
|--------|-------------|
| `kodilla-intro` | Java fundamentals: types, loops, arrays, OOP basics |
| `kodilla-basic-tests` | Unit testing: assertions, abstract classes, inheritance |
| `kodilla-collections` | Collections framework: lists, sets, interfaces |
| `kodilla-collections-advanced` | Maps, immutables, records, advanced collections |
| `kodilla-advanced-tests` | Parameterized tests, Mockito, execution model |
| `kodilla-stream` | Streams, Optional, exception handling |
| `kodilla-rest-api` | Spring Boot REST API with validation and tests |
| `kodilla-selenium` | Selenium WebDriver with Page Object pattern |
| `kodilla-spring-basic` | Spring DI, @Bean configuration, bean scopes |

## Build & Test

```bash
./gradlew clean build
```

## Test Reports

After build, HTML reports are available at:
```
<module>/build/reports/tests/test/index.html
```

Coverage reports (Jacoco):
```
<module>/build/reports/jacoco/test/html/index.html
```
