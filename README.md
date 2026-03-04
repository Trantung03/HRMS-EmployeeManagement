#  HRMS - Employee Management System

###  Project Overview
This is a comprehensive Human Resource Management System (HRMS) developed for **ELTS Vina Company** — a manufacturer of electronic components for mobile phones. The system is designed to streamline employee data management, payroll, and administrative workflows.

---

### 🛠 Tech Stack
- **Backend:** Java 17 (OpenJDK), Spring Boot 3.2.5
- **Frameworks:** Spring Data JPA, Spring Security, Spring Web
- **Database:** Mysql-8.0.36
- **Document Processing:** Apache POI (Excel), PDFBox
- **Advanced Features:** OCR with Tess4J & Google Cloud Vision

---

###  Key Features
- [x] **Personnel Management:** Full CRUD operations for employee profiles.
- [x] **Security:** Secure authentication and authorization using Spring Security.
- [x] **Data Export:** Export payroll and employee lists to Excel/PDF formats.
- [x] **Intelligent Processing:** OCR integration for scanning identification documents.

---

###  Installation & Setup

1. **Prerequisites:**
   - Java JDK 17
   - MySQL Server 8.x
   - Maven

2. **Database Configuration:**
   Create a schema in MySQL and update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/hrms_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
