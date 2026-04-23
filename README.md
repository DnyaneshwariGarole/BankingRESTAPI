<img width="1898" height="966" alt="Screenshot (519)" src="https://github.com/user-attachments/assets/9d276877-f93f-4e7b-a101-a913bfbded96" /> # 💳 Banking REST API

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




