# 🏦 Bank Management System (Java + MySQL)

A Java Swing-based desktop banking application that allows users to perform essential banking operations such as account creation (signup), login authentication, deposits, withdrawals, PIN changes, balance enquiry, and mini statement generation.

Built using **Java**, **Java Swing/AWT**, and **MySQL**, this project demonstrates GUI-based transaction handling with full database integration via JDBC.

---

## 📋 Table of Contents

- [Features](#-features)
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Database Setup](#-step-1-database-setup)
- [How to Compile & Run](#-step-2-compile--run-from-command-line)
- [Application Flow](#-application-flow)
- [Test Credentials](#-test-credentials)

---

## ✅ Features

| Feature | Description |
|---|---|
| User Signup | Multi-step account creation (personal info, KYC, account type) |
| Login Authentication | Secure login using card number and PIN |
| Deposit | Credit money into the account |
| Cash Withdrawal | Debit money from the account |
| Mini Statement | View last 5 transactions |
| Balance Enquiry | Check real-time account balance |
| PIN Change | Update account PIN securely |
| Exit | Safely close the application |

---

## 🧰 Technologies Used

| Component | Technology |
|---|---|
| Language | Java (JDK 8+) |
| GUI Framework | Java Swing / AWT |
| Database | MySQL 8.x |
| DB Driver | MySQL Connector/J 8.0.28 (included) |
| Date Picker | JCalendar 1.3.3 (included) |

---

## 📁 Project Structure

```
Bank-Management-System-main/
│
├── src/
│   └── bank/
│       └── management/
│           └── system/
│               ├── login.java        # Entry point – Login screen
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
├── mysql-connector-java-8.0.28.jar   # JDBC driver (included)
├── jcalendar-tz-1.3.3-4.jar         # Date picker library (included)
├── bankmanagement.sql                # Database schema & setup script
├── compile.bat                       # Windows: compile script
├── run.bat                           # Windows: run script
├── run.sh                            # Linux/macOS: compile & run script
└── README.md
```

---

## 🔧 Prerequisites

Before running the project, make sure the following are installed on your system:

1. **Java Development Kit (JDK) 8 or higher**
   - Verify: `java -version` and `javac -version`
   - Download: https://www.oracle.com/java/technologies/downloads/

2. **MySQL Server 8.x**
   - Verify: `mysql --version`
   - Download: https://dev.mysql.com/downloads/mysql/

> ⚠️ **Note:** The required JAR files (`mysql-connector-java-8.0.28.jar` and `jcalendar-tz-1.3.3-4.jar`) are **already included** in the repository root. No additional download is needed.

---

## 🗄️ Step 1: Database Setup

Open a terminal and log in to MySQL:

```bash
mysql -u root -p
```

Then run the SQL setup script:

```bash
source /path/to/bankmanagement.sql
```

**Or** copy and paste the following SQL commands manually:

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

Open `src/bank/management/system/dbcon.java` and update the connection string if your MySQL credentials differ:

```java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/banksystem", "root", "your_password"
);
```

By default the password is set to empty (`""`). If your MySQL root user has a password, update it here.

---

## ▶️ Step 2: Compile & Run from Command Line

### On Windows

**Step 2a – Compile:**
```cmd
compile.bat
```

**Step 2b – Run:**
```cmd
run.bat
```

### On Linux / macOS

**Make the script executable and run:**
```bash
chmod +x run.sh
./run.sh
```

### Manual Compilation (any OS)

If you prefer to compile manually, run the following from the project root directory:

**Windows:**
```cmd
javac -cp ".;mysql-connector-java-8.0.28.jar;jcalendar-tz-1.3.3-4.jar" -sourcepath src -d out src/bank/management/system/login.java src/bank/management/system/signup.java src/bank/management/system/signup2.java src/bank/management/system/signup3.java src/bank/management/system/welcome.java src/bank/management/system/deposit.java src/bank/management/system/withdrawal.java src/bank/management/system/mini.java src/bank/management/system/pinchange.java src/bank/management/system/dbcon.java
```

```cmd
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

## 🔄 Application Flow

```
Login Screen
    │
    ├── [New User] → Signup Step 1 (Personal Info)
    │                     → Signup Step 2 (KYC Details)
    │                           → Signup Step 3 (Account Type & PIN)
    │                                 → Login Screen
    │
    └── [Existing User] → Welcome Dashboard
                              │
                              ├── Deposit
                              ├── Cash Withdrawal
                              ├── Mini Statement (last 5 transactions)
                              ├── Balance Enquiry
                              ├── PIN Change
                              └── Exit
```

---

## 🔑 Test Credentials

To test the application without going through the full signup, insert a test record into MySQL:

```sql
USE banksystem;
INSERT INTO login (application_no, card_number, pin) VALUES (1001, '1234567890123456', '1234');
INSERT INTO bank (pin, date, type, amount) VALUES ('1234', '2024-01-01', 'Deposit', '10000');
```

Then log in with:
- **Card Number:** `1234567890123456`
- **PIN:** `1234`

---

## 🧾 Troubleshooting

| Issue | Solution |
|---|---|
| `javac` not found | Add JDK `bin` folder to your system PATH |
| `java` not found | Add JRE/JDK `bin` folder to your system PATH |
| MySQL connection refused | Ensure MySQL service is running (`net start mysql` on Windows) |
| Wrong credentials error | Update password in `dbcon.java` to match your MySQL setup |
| Icons not loading | Ensure the `out/icon/` directory exists (compile script handles this) |

---

## 👨‍💻 Developer

- **Author:** Suryansh Tiwari
- **GitHub:** [@tiwarisuryansh6222](https://github.com/tiwarisuryansh6222)
- **Project:** Bank Management System

---

## 📌 Future Enhancements

- Password/PIN hashing for enhanced security
- Transaction receipts and PDF export
- REST API backend for web-based access
- Role-based admin and customer access
