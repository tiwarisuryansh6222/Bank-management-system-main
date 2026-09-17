# 🏦 Bank Management System (Java + MySQL)

A Java Swing-based desktop banking application that allows users to perform essential banking operations such as account creation (multi-step signup), secure login, deposits, withdrawals, PIN changes, balance enquiry, and mini statement generation.

Built using **Java**, **Java Swing/AWT**, and **MySQL**, this project demonstrates GUI-based transaction handling with full database integration via JDBC.

---

## 📋 Table of Contents

- [Features](#-features)
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Database Setup](#-step-1-database-setup)
- [Compile & Run](#-step-2-compile--run-from-command-line)
- [Testing Instructions](#-testing-instructions)
- [Application Flow](#-application-flow)
- [Design Documentation](#-design-documentation)

---

## ✅ Features

| Feature | Description |
|---------|-------------|
| Multi-Step User Signup | 3-screen registration: personal info → KYC → account type & PIN |
| Login Authentication | Secure login using card number and PIN |
| Deposit | Credit money; transaction logged with date |
| Cash Withdrawal | Debit money with database update |
| Mini Statement | View last 5 transactions |
| Balance Enquiry | Real-time account balance |
| PIN Change | Securely update account PIN |
| MySQL Integration | All data stored and fetched from MySQL via JDBC |

---

## 🧰 Technologies Used

| Component | Technology |
|-----------|------------|
| Language | Java (JDK 8+) |
| GUI Framework | Java Swing / AWT |
| Database | MySQL 8.x |
| DB Driver | MySQL Connector/J 8.0.28 (included) |
| Date Picker | JCalendar 1.3.3 (included) |
| Version Control | Git / GitHub |

---

## 📁 Project Structure

```
Bank-Management-System-main/
│
├── src/
│   └── bank/
│       └── management/
│           └── system/
│               ├── login.java        # Entry point — Login screen
│               ├── signup.java       # Step 1: Personal details
│               ├── signup2.java      # Step 2: KYC / additional info
│               ├── signup3.java      # Step 3: Account type & PIN setup
│               ├── welcome.java      # Main dashboard after login
│               ├── deposit.java      # Deposit screen
│               ├── withdrawal.java   # Withdrawal screen
│               ├── mini.java         # Mini statement screen
│               ├── pinchange.java    # PIN change screen
│               └── dbcon.java        # Database connection utility
│
├── src/icon/                         # Application images/icons
├── docs/
│   └── design.md                     # UML diagrams, ER diagram, architecture
├── mysql-connector-java-8.0.28.jar   # JDBC driver (included)
├── jcalendar-tz-1.3.3-4.jar         # Date picker library (included)
├── bankmanagement.sql                # Database schema & setup script
├── compile.bat                       # Windows: compile script
├── run.bat                           # Windows: run script
├── run.sh                            # Linux/macOS: compile & run script
├── statement.md                      # Problem statement & project scope
└── README.md
```

---

## 🔧 Prerequisites

Before running the project, ensure the following are installed:

1. **Java Development Kit (JDK) 8 or higher**
   - Verify: `java -version` and `javac -version`
   - Download: https://www.oracle.com/java/technologies/downloads/

2. **MySQL Server 8.x**
   - Verify: `mysql --version`
   - Download: https://dev.mysql.com/downloads/mysql/

> ⚠️ The JAR files (`mysql-connector-java-8.0.28.jar` and `jcalendar-tz-1.3.3-4.jar`) are **already included** in the repository root. No extra download needed.

---

## 🗄️ Step 1: Database Setup

Open a terminal and log in to MySQL:

```bash
mysql -u root -p
```

Run the SQL setup script:

```bash
source /full/path/to/bankmanagement.sql
```

**Or** paste this SQL manually:

```sql
CREATE DATABASE banksystem;
USE banksystem;

CREATE TABLE signup (
    id INT AUTO_INCREMENT PRIMARY KEY,
    application_no INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    aadhar_number VARCHAR(20),
    phone_number VARCHAR(15),
    gender VARCHAR(10),
    dob DATE,
    father_name VARCHAR(50),
    occupation VARCHAR(50),
    nationality VARCHAR(20),
    address VARCHAR(100),
    city VARCHAR(50),
    pin_code VARCHAR(10),
    state VARCHAR(50)
);

CREATE TABLE signuptwo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    application_no INT NOT NULL,
    religion VARCHAR(50) NOT NULL,
    catagory VARCHAR(50) NOT NULL,
    income VARCHAR(100),
    education VARCHAR(20),
    occupation VARCHAR(15),
    pan VARCHAR(10),
    aadhar VARCHAR(50),
    siblings VARCHAR(50)
);

CREATE TABLE signup3 (
    application_no INT NOT NULL,
    account_type VARCHAR(40),
    card_number VARCHAR(40),
    pin VARCHAR(30),
    facility VARCHAR(200)
);

CREATE TABLE login (
    application_no INT NOT NULL,
    card_number VARCHAR(50),
    pin VARCHAR(40)
);

CREATE TABLE bank (
    pin VARCHAR(20),
    date VARCHAR(50),
    type VARCHAR(50),
    amount VARCHAR(50)
);
```

### ⚙️ Configure Database Credentials

Open `src/bank/management/system/dbcon.java` and update line 13 if your MySQL root password is not empty:

```java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/banksystem", "root", "your_password_here"
);
```

---

## ▶️ Step 2: Compile & Run from Command Line

### On Windows

**Compile:**
```cmd
compile.bat
```

**Run:**
```cmd
run.bat
```

### On Linux / macOS

```bash
chmod +x run.sh
./run.sh
```

### Manual Compilation (any OS)

**Windows:**
```cmd
mkdir out
javac -cp ".;mysql-connector-java-8.0.28.jar;jcalendar-tz-1.3.3-4.jar" -sourcepath src -d out src/bank/management/system/login.java src/bank/management/system/signup.java src/bank/management/system/signup2.java src/bank/management/system/signup3.java src/bank/management/system/welcome.java src/bank/management/system/deposit.java src/bank/management/system/withdrawal.java src/bank/management/system/mini.java src/bank/management/system/pinchange.java src/bank/management/system/dbcon.java
xcopy /E /I src\icon out\icon
java -cp "out;mysql-connector-java-8.0.28.jar;jcalendar-tz-1.3.3-4.jar" bank.management.system.login
```

**Linux/macOS:**
```bash
mkdir -p out
javac -cp ".:mysql-connector-java-8.0.28.jar:jcalendar-tz-1.3.3-4.jar" -sourcepath src -d out src/bank/management/system/login.java src/bank/management/system/signup.java src/bank/management/system/signup2.java src/bank/management/system/signup3.java src/bank/management/system/welcome.java src/bank/management/system/deposit.java src/bank/management/system/withdrawal.java src/bank/management/system/mini.java src/bank/management/system/pinchange.java src/bank/management/system/dbcon.java
cp -r src/icon out/
java -cp "out:mysql-connector-java-8.0.28.jar:jcalendar-tz-1.3.3-4.jar" bank.management.system.login
```

---

## 🧪 Testing Instructions

### Quick Test — Insert Test Data

To test the application immediately without going through signup, run in MySQL:

```sql
USE banksystem;

-- Insert test login credentials
INSERT INTO login (application_no, card_number, pin) VALUES (1001, '1234567890123456', '1234');

-- Insert some test transactions
INSERT INTO bank (pin, date, type, amount) VALUES ('1234', '2024-01-01', 'Deposit', '10000');
INSERT INTO bank (pin, date, type, amount) VALUES ('1234', '2024-01-02', 'Withdrawal', '2000');
INSERT INTO bank (pin, date, type, amount) VALUES ('1234', '2024-01-03', 'Deposit', '5000');
```

**Login with:**
- **Card Number:** `1234567890123456`
- **PIN:** `1234`

---

### Test Case Table

| Test Case | Steps | Expected Result |
|-----------|-------|-----------------|
| TC-01: Valid Login | Enter valid card number + PIN → Click Sign-In | Redirected to Welcome dashboard |
| TC-02: Invalid Login | Enter wrong card/PIN → Click Sign-In | Stays on login screen |
| TC-03: Deposit | Login → Click Deposit → Enter amount → Submit | Success dialog; transaction recorded in DB |
| TC-04: Withdrawal | Login → Click Cash Withdrawal → Enter amount → Submit | Success dialog; balance reduced |
| TC-05: Mini Statement | Login → Click Mini Statement | Last 5 transactions displayed |
| TC-06: Balance Enquiry | Login → Click Balance Enquiry | Current balance shown in dialog |
| TC-07: PIN Change | Login → Click PIN Change → Enter old/new PIN → Submit | PIN updated in login and signup3 tables |
| TC-08: New Signup | Click Sign-Up → Complete 3 steps | Account created; can log in with new credentials |

---

## 🔄 Application Flow

```
Login Screen
    │
    ├── [New User] ──► Signup Step 1 (Personal Info)
    │                        ──► Signup Step 2 (KYC Details)
    │                                ──► Signup Step 3 (Account Type & PIN)
    │                                          ──► Back to Login
    │
    └── [Existing User] ──► Welcome Dashboard
                                   │
                                   ├── Deposit
                                   ├── Cash Withdrawal
                                   ├── Mini Statement (last 5 transactions)
                                   ├── Balance Enquiry
                                   ├── PIN Change
                                   └── Exit
```

---

## 📐 Design Documentation

Full design artefacts including system architecture, UML diagrams (Use Case, Class, Sequence), ER diagram, and workflow diagram are available in:

📄 **[docs/design.md](docs/design.md)**

---

## 🧾 Troubleshooting

| Issue | Solution |
|-------|---------|
| `javac` not found | Add JDK `bin` to system PATH |
| MySQL connection refused | Run `net start mysql` (Windows) or `sudo service mysql start` (Linux) |
| Wrong credentials error | Update password in `dbcon.java` line 13 |
| Icons not loading | Ensure `out/icon/` folder exists — compile script handles this |
| `ClassNotFoundException` | Ensure JAR files are in the project root folder |

---

## 👨‍💻 Developer

- **Author:** Suryansh Tiwari
- **GitHub:** [@tiwarisuryansh6222](https://github.com/tiwarisuryansh6222)
- **Project:** Bank Management System

---

## 📌 Future Enhancements

- PIN/password hashing (BCrypt) for security
- Transaction receipts and PDF export
- REST API backend for web-based access
- Admin panel for bank staff
- Role-based access control
