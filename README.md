# DMV Management System (JavaFX + SQLite)

## 📋 Project Overview

This **DMV Management System** is a desktop application built using **Java**, **JavaFX** for GUI, and **SQLite** for database management. It provides an interface for managing **citizens**, **driver licenses**, and **vehicles**, applying core **Object-Oriented Programming (OOP)** principles like encapsulation, inheritance, and composition.

---

## 🎯 Features

✅ Multi-window JavaFX GUI  
✅ SQLite database with **citizen** and **license** tables  
✅ Full **CRUD operations** (Create, Read, Update, Delete)  
✅ Role-based login system (Admin/User)  
✅ Form validation with error handling  
✅ Real-time table view updates  
✅ Clean modular OOP structure  

---

## 🧱 Tech Stack

- **Java SE 8+**
- **JavaFX (FXML)**
- **SQLite**
- **JDBC (Java Database Connectivity)**
- **SceneBuilder (optional, for GUI design)**

---

### `citizens` Table

| Column Name     | Type    | Description                        |
|------------------|---------|------------------------------------|
| fullName         | TEXT    | Full name of the citizen           |
| nationalId       | INTEGER | Unique National ID (Primary key)   |
| houseNo          | TEXT    | House number/address details       |
| street           | TEXT    | Street name                        |
| governorate      | TEXT    | Governorate/region                 |
| country          | TEXT    | Country                            |
| birthDate        | TEXT    | Date of birth (YYYY-MM-DD)         |
| gender           | TEXT    | Gender                             |
| martialStatues   | TEXT    | Marital status                     |
| religion         | TEXT    | Religion                           |

---

### `licenses` Table

| Column Name   | Type    | Description                                |
|---------------|---------|--------------------------------------------|
| fullName      | TEXT    | Full name of the license holder            |
| nationalId    | INTEGER | National ID of the citizen (used as key)   |
| licenseNo     | INTEGER | Unique license number                      |
| birthDate     | TEXT    | Date of birth (YYYY-MM-DD)                 |
| issueDate     | TEXT    | License issue date                         |
| expiryDate    | TEXT    | License expiry date                        |
| licenseStatus | TEXT    | Status (e.g., Valid, Expired, Suspended)   |
| classType     | TEXT    | License class (e.g., A, B, C)              |
| restriction   | TEXT    | Special conditions or restrictions         |

> All fields except `fullName`, `nationalId`, and `licenseNo` are marked as **NOT NULL**.

---
## Code Project
Fell free to check out the code project and run it 

## Tip To Run The Projuct You Must Pass Through the login 
## UserName = Youssef
## Password = 2406241
