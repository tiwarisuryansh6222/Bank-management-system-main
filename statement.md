# 📄 Project Statement — Bank Management System

---

## 1. Problem Statement

Traditional banking processes often require users to physically visit bank branches for basic operations such as deposits, withdrawals, balance inquiries, and account management. This creates inefficiencies, long waiting times, and dependency on bank staff for routine tasks.

The **Bank Management System** addresses this problem by providing a desktop-based banking application that allows users to independently perform essential banking operations through a secure, intuitive graphical interface backed by a relational database. The system simulates core ATM and banking functionalities in a software environment, making it an effective learning and demonstration tool for database-driven application development.

---

## 2. Scope of the Project

The scope of this project includes:

- **User Registration (Signup):** A multi-step account creation process collecting personal details, KYC information, and account preferences.
- **Authentication:** Secure login using a unique card number and PIN combination validated against the database.
- **Core Banking Transactions:** Deposit, withdrawal, and PIN change operations with real-time database updates.
- **Account Enquiry:** Balance check and mini statement (last 5 transactions) retrieved from the database.
- **Data Persistence:** All user data and transactions are stored in a MySQL relational database, ensuring data integrity and persistence across sessions.

**Out of Scope:**
- Online/web-based access
- Multi-bank interoperability
- Loan, insurance, or investment modules
- Mobile application

---

## 3. Target Users

| User Type | Description |
|-----------|-------------|
| **Bank Customers** | End users who register and use the system for daily banking transactions |
| **Developers / Students** | Individuals learning Java GUI development and JDBC/MySQL integration |
| **Academic Evaluators** | Reviewers assessing the technical implementation and design of the system |

---

## 4. High-Level Features

| # | Feature | Description |
|---|---------|-------------|
| 1 | **Multi-Step User Signup** | Three-screen registration collecting personal info, KYC data, and account type with auto-generated card number and PIN setup |
| 2 | **Secure Login** | Card number + PIN authentication with database validation |
| 3 | **Deposit** | Credit money into the user's account; transaction logged with date and type |
| 4 | **Cash Withdrawal** | Debit money with balance validation to prevent overdraft |
| 5 | **Mini Statement** | Display the last 5 transactions (type, amount, date) from the database |
| 6 | **Balance Enquiry** | Real-time calculation of current account balance |
| 7 | **PIN Change** | Secure PIN update with confirmation validation |
| 8 | **Database Integration** | Full MySQL backend via JDBC for all CRUD operations |
| 9 | **GUI Interface** | Java Swing/AWT-based responsive desktop interface with background images and styled components |
| 10 | **Modular Architecture** | Separate Java classes for each module ensuring clean separation of concerns |
