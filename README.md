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

## 🗃️ Database Schema

### `citizens` Table:
| Column Name | Type    | Description              |
|-------------|---------|--------------------------|
| id          | INTEGER | Primary Key (auto-inc)   |
| name        | TEXT    | Full name of the citizen |
| age         | INTEGER | Age                      |
| address     | TEXT    | Address                  |

### `licenses` Table:
| Column Name   | Type    | Description                 |
|---------------|---------|-----------------------------|
| id            | INTEGER | Primary Key (auto-inc)      |
| citizen_id    | INTEGER | Foreign key → citizens(id)  |
| license_type  | TEXT    | Type of license (e.g., B, C) |
| issue_date    | TEXT    | Issue date                  |
| expiry_date   | TEXT    | Expiry date                 |

---

## 🏁 How to Run the Project

1. **Clone or Download** the project:
   ```bash
   git clone https://github.com/yourusername/DMV.git
