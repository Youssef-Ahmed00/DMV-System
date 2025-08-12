# 🚗 DMV Management System (JavaFX + SQLite)

[![Java](https://img.shields.io/badge/Java-Programming-red?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)  
[![JavaFX](https://img.shields.io/badge/JavaFX-GUI-blue?style=for-the-badge&logo=java&logoColor=white)](https://openjfx.io/)  
[![SQLite](https://img.shields.io/badge/SQLite-Database-blueviolet?style=for-the-badge&logo=sqlite&logoColor=white)](https://www.sqlite.org/index.html)  

---

## 📋 Overview  
The **DMV Management System** is a desktop application built using **Java**, **JavaFX** for the graphical user interface, and **SQLite** for database management.  
It enables efficient management of **citizens**, **driver licenses**, and **vehicles** while applying **Object-Oriented Programming (OOP)** principles such as encapsulation, inheritance, and composition.

📌 **Repository Link:** [DMV-System on GitHub](https://github.com/Youssef-Ahmed00/DMV-System.git)  

---

## ✨ Features  

✅ **Multi-window JavaFX GUI** for smooth navigation  
✅ **SQLite Database** with `citizens` and `licenses` tables  
✅ **Full CRUD operations** (Create, Read, Update, Delete)  
✅ **Role-based login system** (Admin / User)  
✅ **Form validation** with detailed error handling  
✅ **Real-time table view updates** after operations  
✅ **Clean modular OOP structure** for scalability  

---

## 🧱 Tech Stack  

- ☕ **Java SE 8+** – Core application logic  
- 🎨 **JavaFX (FXML)** – GUI design and event handling  
- 💾 **SQLite** – Lightweight database management  
- 🔗 **JDBC** – Java Database Connectivity  
- 🛠 **SceneBuilder** (optional) – For visual GUI editing  

---

## 📂 Project Structure  

```plaintext
DMV-System/
│
├── src/                         # Java source code
│   ├── controllers/             # JavaFX controllers for UI
│   ├── models/                   # OOP models (Citizen, License, etc.)
│   ├── database/                 # SQLite database connection classes
│   └── Main.java                 # Application entry point
│
├── resources/                    # FXML, CSS, icons
│   ├── views/                     # FXML UI files
│   ├── styles.css                 # Styling for JavaFX components
│   └── dmv.db                     # SQLite database file
│
└── README.md                     # Project documentation

---
 🗄 Database Structure
-
citizens Table

| Column Name    | Type    | Description                 |
| -------------- | ------- | --------------------------- |
| fullName       | TEXT    | Full name of the citizen    |
| nationalId     | INTEGER | Unique National ID (**PK**) |
| houseNo        | TEXT    | House number / address      |
| street         | TEXT    | Street name                 |
| governorate    | TEXT    | Governorate / region        |
| country        | TEXT    | Country                     |
| birthDate      | TEXT    | Date of birth (YYYY-MM-DD)  |
| gender         | TEXT    | Gender                      |
| martialStatues | TEXT    | Marital status              |
| religion       | TEXT    | Religion                    |


##licenses Table
| Column Name   | Type    | Description                              |
| ------------- | ------- | ---------------------------------------- |
| fullName      | TEXT    | Full name of the license holder          |
| nationalId    | INTEGER | National ID (**FK** from citizens table) |
| licenseNo     | INTEGER | Unique license number                    |
| birthDate     | TEXT    | Date of birth (YYYY-MM-DD)               |
| issueDate     | TEXT    | License issue date                       |
| expiryDate    | TEXT    | License expiry date                      |
| licenseStatus | TEXT    | Status (Valid, Expired, Suspended, etc.) |
| classType     | TEXT    | License class (A, B, C, etc.)            |
| restriction   | TEXT    | Special conditions or restrictions       |

---
##🔑 Login Credentials (Demo)
To run the project successfully, use the following credentials:
Username: Youssef
Password: 2406241

---

##🧠 Skills Learned
📚 JavaFX GUI Development with FXML and controllers

🗄 SQLite Database Integration using JDBC

🧩 Applying OOP principles (encapsulation, inheritance, composition)

🖥 Multi-window navigation and event handling in JavaFX

✅ Form validation and error handling

🔄 Real-time table updates on CRUD operations

🔐 Role-based authentication

🚀 Future Improvements
🌙 Dark Mode for better accessibility

📂 Vehicle Management Module

🔍 Advanced search filters in citizens/licenses tables

📊 Statistics Dashboard (e.g., total licenses, expired licenses)

📩 Export data to PDF/Excel

🔐 Password hashing for better security
---

💻 Developed by: Youssef Ahmed
-
📅 Year: 2025
📜 License: MIT
