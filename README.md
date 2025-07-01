
# Spring MVC Calculator

A web calculator built using Java, Spring Boot, and Thymeleaf. It performs basic arithmetic operations between two numbers: addition, subtraction, multiplication, and division. Ideal as an introductory project to the Model-View-Controller (MVC) pattern in Spring Boot.

---

## Features

- Supported operations: `+`, `-`, `*`, `/`
- JavaScript used to capture input and submit forms
- Spring Boot backend using Thymeleaf to render the view

---

## Requirements

Before you begin, ensure you have the following installed:

- **Java 17** or higher
- **Maven 3.6** or higher
- **Git**

Check with:

```bash
java -version
mvn -version
```

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/Daniel-Aldana10/calculadoraspringmvc
cd calculadoraspringmvc
```

2. Build the project:

```bash
mvn clean package
```

3. Run the application:

```bash
mvn spring-boot:run
```

By default, it will be available at:  
`http://localhost:8080/`

---

## How to Use

1. Open your browser and go to `http://localhost:8080/`
2. Use the buttons to input two numbers and an operator
3. Press `=` to display the result
4. Press `AC` to reset

> The calculator performs **one operation at a time** (e.g., `5 + 3`). Chained expressions are not supported.

---


## Project Structure

```
src/
├── main/java/com/calculadora/
│   ├── CalculadoraApplication.java    # Main application class
│   └── CalculadoraController.java     # Controller with backend logic
├── main/resources/templates/
│   └── calculadora.html               # HTML UI with Thymeleaf and JS
├── main/resources/application.properties
```

---

## Design

- The user interacts with buttons in `calculadora.html`
- State (`operand`, `operator`, `current`) is handled in JavaScript
- When `=` is pressed, a `POST` request is sent to the backend
- Spring Boot processes the request and returns the result

---


## Author

Daniel Aldana — [GitHub](https://github.com/Daniel-Aldana10)

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
