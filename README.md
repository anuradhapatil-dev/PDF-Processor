# PDF Processor Service

## Project Overview
This is a backend service for PDF operations like merge, split, compress, encrypt, and more. The service is designed to be scalable, maintainable, and ready for production environments.

## Technologies Used
- **Java 22**
- **Spring Boot 3**
- **Kafka**
- **PostgreSQL**
- **JUnit** (for unit testing)
- **SonarQube** (for code quality)

## Project Structure
```plaintext
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   ├── yourcompany/
│   │   │
# 📄 PDF Processor

> A professional-grade microservice to handle PDF file operations like merge, split, and event-driven processing, built using Spring Boot, Kafka, and PostgreSQL.

---

## ✨ Features
- Merge multiple PDF files into one.
- Split a PDF into multiple files.
- Track file actions via Kafka event streams.
- Store PDF operation logs in PostgreSQL.
- Scalable, event-driven, microservice-ready architecture.
- Industry-standard exception handling and logging.

---

## 🏗️ Tech Stack

| Technology  | Purpose  |
|:------------|:---------|
| **Java 22** | Core programming language |
| **Spring Boot** | Backend framework |
| **Apache Kafka** | Event-driven architecture |
| **PostgreSQL** | Database to store logs |
| **Maven** | Dependency management |
| **IntelliJ IDEA** | Development Environment |
| **Git** | Version control |
| **Postman** | API testing tool |
| **SonarQube** (Optional) | Code quality analysis |

---

## 📁 Project Directory Structure

```bash
pdf-processor/
├── src/main/java/
│   └── com/anuradha/pdfprocessor/
│       ├── controller/
│       ├── service/
│       ├── service/persistence/
│       ├── dto/
│       ├── entity/
│       ├── repository/
│       ├── events/
│       ├── exception/
│       ├── model/
│       ├── config/
│       ├── util/
│       └── PdfProcessorApplication.java
├── src/main/resources/
│   ├── application.properties
├── src/test/java/
│   └── (Test classes)
├── README.md
├── pom.xml
```

---

## 🛠️ Installation Guide

### 1. Prerequisites
- Java 22 installed
- Maven installed
- PostgreSQL server running
- Kafka server running locally or remotely
- IntelliJ IDEA (Community or Ultimate)

### 2. Setup

```bash
# Clone the repository
git clone https://github.com/your-username/pdf-processor.git
cd pdf-processor

# Install dependencies and build project
mvn clean install

# Run the application
mvn spring-boot:run
```

---

## ⚙️ Configuration

Set the following properties in `application.properties`:

```properties
# Server settings
server.port=8080

# PostgreSQL settings
spring.datasource.url=jdbc:postgresql://localhost:5432/pdf_processor
spring.datasource.username=your_username
spring.datasource.password=your_password

# Kafka settings
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer
```

---

## 📋 API Endpoints

| HTTP Method | Endpoint | Description |
|:------------|:---------|:------------|
| POST | `/api/pdf/merge` | Merge multiple PDF files |
| POST | `/api/pdf/split` | Split a PDF into parts |
| GET  | `/api/pdf/logs` | Fetch operation logs |

---

## 📈 Future Enhancements
- PDF encryption/decryption support.
- File compression.
- Email notifications on operation success/failure.
- WebSocket live updates for file operations.
- Admin dashboard (Spring Boot + React.js).
- Dockerization & CI/CD deployment pipeline.

---

## 🤝 Contributing
Contributions, issues, and feature requests are welcome!  
Feel free to check the [issues page](https://github.com/your-username/pdf-processor/issues).

---

## 📄 License
Distributed under the MIT License.  
See `LICENSE` for more information.

---

# 🔥 Professional Notes

- Project follows clean, layered architecture.
- Domain-Driven Design approach will be used wherever possible.
- Logging and Exception handling follow professional patterns.
- Test cases will be added during development phase.

---

