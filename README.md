<img width="1920" height="1080" alt="Screenshot (519)" src="https://github.com/user-attachments/assets/849d84d6-652c-4d76-ad3a-9a25c322b4f5" /># 💳 Banking REST API

## 📌 Project Overview
This project is a **Banking REST API** built using **Spring Boot**.  
It follows a **Layered Architecture** and performs **CRUD operations** on bank data.  

The application uses:
- DTO pattern for request/response
- Global exception handling
- RESTful APIs for communication
- Basic frontend using HTML, CSS, and JavaScript

---

## 🚀 Tech Stack
- Java
- Spring Boot
- Maven
- REST API
- HTML, CSS, JavaScript

---

## 🏗️ Architecture
The project follows **Layered Architecture**:

Controller → Service → Repository → Database

- **Controller** → Handles HTTP requests  
- **Service** → Business logic  
- **Repository** → Database operations  
- **DTO** → Data transfer between layers  

---

## ✨ Features
- Create Bank
- View All Banks
- Get Bank by ID
- Update Bank Details
- Delete Bank
- Exception Handling using GlobalExceptionHandler
- DTO-based clean data handling

---

## 📡 API Endpoints

| Method | Endpoint       | Description            |
|--------|---------------|------------------------|
| POST   | /banks        | Create a new bank      |
| GET    | /banks        | Get all banks          |
| GET    | /banks/{id}   | Get bank by ID         |
| PUT    | /banks/{id}   | Update bank details    |
| DELETE | /banks/{id}   | Delete bank            |

---

## ▶️ How to Run the Project

```bash
git clone https://github.com/DnyaneshwariGarole/BankingRESTAPI.git
cd BankingRESTAPI
mvn spring-boot:run



