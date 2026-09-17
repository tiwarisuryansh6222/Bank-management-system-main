# PROJECT REPORT
# Bank Management System (Java + MySQL)

---

**Submitted by:** Suryansh Tiwari
**GitHub:** https://github.com/tiwarisuryansh6222/Bank-management-system-main
**Subject Domain:** Java Programming / Database Management Systems
**Technology Stack:** Java, Java Swing/AWT, MySQL, JDBC

---

---

## 1. COVER PAGE

| Field | Details |
|-------|---------|
| Project Title | Bank Management System |
| Author | Suryansh Tiwari |
| GitHub Username | tiwarisuryansh6222 |
| Repository | https://github.com/tiwarisuryansh6222/Bank-management-system-main |
| Language | Java (JDK 8+) |
| Database | MySQL 8.x |
| GUI Framework | Java Swing / AWT |
| Total Source Files | 10 Java classes |
| Total Modules | 5 major functional modules |

---

## 2. INTRODUCTION

The Bank Management System is a desktop-based application developed using Java Swing and MySQL that simulates core banking functionalities available in modern ATM and banking software. The system enables users to create bank accounts through a multi-step registration process, authenticate securely, and perform essential banking transactions such as deposits, withdrawals, balance enquiry, mini statement generation, and PIN changes.

The project demonstrates the application of the following key concepts:
- **Object-Oriented Programming (OOP):** Each screen is encapsulated as a separate Java class implementing clean separation of concerns.
- **Event-Driven Programming:** Java ActionListener interface handles all user interactions.
- **Database Connectivity (JDBC):** MySQL Connector/J establishes and manages the connection between the Java application and the MySQL database.
- **GUI Design:** Java Swing and AWT components are used to build an interactive, visually styled user interface.
- **Relational Database Design:** Five normalized tables manage user data and transactions.

This project fulfills the course requirement of building a functional, database-integrated desktop application using Java.

---

## 3. PROBLEM STATEMENT

Traditional banking processes require customers to physically visit bank branches for routine operations such as deposits, withdrawals, balance checks, and account management. This dependency on in-person interactions leads to:

- Long queues and waiting times at bank counters
- Restricted service hours limiting customer access
- High operational costs for banks managing large customer volumes
- Inconvenience for customers needing quick transaction information

The **Bank Management System** solves this problem by providing a secure, self-service desktop application where customers can:
- Register a new bank account independently through a guided multi-step form
- Log in securely using a card number and PIN
- Perform deposits and withdrawals at any time
- View their transaction history (mini statement)
- Check their current balance instantly
- Change their PIN when needed

This system simulates ATM-level functionality in a software environment, reducing the need for physical bank visits for basic operations.

---

## 4. FUNCTIONAL REQUIREMENTS

The system provides the following functional capabilities:

### FR-01: User Registration (Multi-Step Signup)
- The system shall allow new users to register through a 3-step form.
- Step 1 collects: First name, Last name, Email, Aadhar number, Phone, Gender, DOB, Father's name, Occupation, Nationality, Address, City, PIN code, State.
- Step 2 collects: Religion, Category, Income, Education, Occupation, PAN, Aadhar, Number of siblings.
- Step 3 collects: Account type, Card number, PIN, and Facilities.
- All data shall be stored in the MySQL database upon successful completion.

### FR-02: User Authentication (Login)
- The system shall authenticate users using a card number and PIN combination.
- Credentials shall be validated against the `login` table in the database.
- Successful authentication shall redirect the user to the main dashboard.

### FR-03: Deposit
- Authenticated users shall be able to deposit money into their account.
- Each deposit transaction shall be recorded with amount, date, and type in the `bank` table.

### FR-04: Cash Withdrawal
- Authenticated users shall be able to withdraw money from their account.
- Each withdrawal shall be recorded in the `bank` table.

### FR-05: Mini Statement
- The system shall display the last 5 transactions (date, type, amount) for the logged-in user.
- Data shall be fetched from the `bank` table filtered by the user's PIN.

### FR-06: Balance Enquiry
- The system shall calculate and display the current account balance.
- Balance is computed as: sum of all deposits minus sum of all withdrawals.

### FR-07: PIN Change
- Authenticated users shall be able to change their PIN.
- The system shall update the PIN in both the `login` and `signup3` tables.

### FR-08: Exit / Logout
- The system shall allow users to safely close the application from the dashboard.

---

## 5. NON-FUNCTIONAL REQUIREMENTS

### NFR-01: Security
- User PINs are stored in the database and validated before granting access.
- The application uses Java's `JPasswordField` to mask PIN input on screen.
- SQL queries use direct string construction (future improvement: prepared statements to prevent SQL injection).

### NFR-02: Usability
- The application uses a graphical interface (Java Swing/AWT) with labeled fields, clear buttons, and background images for intuitive navigation.
- Custom fonts (Raleway), colored labels, and styled buttons enhance visual clarity.
- Each operation is accessible from the main dashboard with a single button click.

### NFR-03: Reliability
- All transactions are persisted in the MySQL database ensuring data is not lost on application restart.
- The `dbcon` class centralizes database connection management, making it easy to handle connection errors in one place.
- Exception handling (`try-catch`) is implemented in all database-interaction methods.

### NFR-04: Performance
- The application queries only the records relevant to the logged-in user (filtered by PIN), keeping query results small and response time fast.
- Database operations (INSERT/SELECT) are executed synchronously on user action ensuring immediate feedback.

### NFR-05: Maintainability
- Each screen is implemented as a separate Java class, following Single Responsibility Principle.
- The `dbcon` class abstracts database connection logic, so updating the DB URL or credentials requires a change in only one place.
- The package structure (`bank.management.system`) organizes all classes logically.

### NFR-06: Scalability
- New banking features (e.g., fund transfer, loan management) can be added as new Java classes following the existing pattern.
- Additional database tables can be added without affecting existing functionality.

### NFR-07: Error Handling
- All database operations are wrapped in `try-catch` blocks to handle SQL exceptions gracefully.
- Connection failures are caught and stack traces are printed for debugging purposes.

### NFR-08: Portability
- The application runs on any OS (Windows, Linux, macOS) with JDK 8+ and MySQL installed.
- CLI scripts (`compile.bat`, `run.bat`, `run.sh`) are provided for cross-platform compilation and execution.

---

## 6. SYSTEM ARCHITECTURE

The application follows a 3-Tier Architecture:

```
+----------------------------------------------------------+
|               PRESENTATION LAYER (Tier 1)                |
|         Java Swing / AWT GUI Components                  |
|  login | signup | welcome | deposit | withdrawal | mini  |
+-------------------------+--------------------------------+
                          | Java method calls / Events
+-------------------------v--------------------------------+
|              BUSINESS LOGIC LAYER (Tier 2)               |
|    Java ActionListener implementations in each class     |
|   Input Validation | Transaction Logic | Screen Nav       |
+-------------------------+--------------------------------+
                          | JDBC SQL Queries
+-------------------------v--------------------------------+
|                  DATA LAYER (Tier 3)                     |
|             MySQL Database (banksystem)                  |
|   signup | signuptwo | signup3 | login | bank            |
+----------------------------------------------------------+
```

**Data Flow:**
1. User interacts with a Swing GUI component (button click, text input).
2. The ActionListener in the corresponding Java class processes the event.
3. A new `dbcon` object establishes a JDBC connection to MySQL.
4. SQL queries (INSERT/SELECT/UPDATE) are executed on the database.
5. Results are processed and the GUI is updated accordingly (new screen or dialog).

---

## 7. DESIGN DIAGRAMS

### 7.1 Use Case Diagram

```
         +---------------------------------------------------+
         |              Bank Management System               |
         |                                                   |
         |  +-------------+    +---------------------------+ |
User ----+->| Register    |    | Login                     | |
         |  | Account     |    | (Card No + PIN)           | |
         |  +-------------+    +---------------------------+ |
         |                              |                    |
         |                     +--------v---------+          |
         |                     |  Welcome         |          |
         |                     |  Dashboard       |          |
         |                     +--+--+--+--+--+--+          |
         |                        |  |  |  |  |             |
         |              +---------+  |  |  |  +---------+   |
         |              |            |  |  |            |   |
         |         +----v---+   +----v-+ | +------+  +-v--+ |
         |         |Deposit |   |With- | | |Mini  |  |PIN | |
         |         |        |   |drawal| | |Stmt  |  |Chng| |
         |         +--------+   +------+ | +------+  +----+ |
         |                         +-----v------+           |
         |                         |  Balance   |           |
         |                         |  Enquiry   |           |
         |                         +------------+           |
         +---------------------------------------------------+
```

### 7.2 Workflow Diagram

```
[Start Application]
        |
        v
  [Login Screen]
        |
   +----+----+
   |         |
[Sign Up]  [Sign In]
   |         |
   v         v
[Step 1]  [Validate Credentials in DB]
[Personal]    |
   |      +---+---+
   v      |       |
[Step 2] [Valid] [Invalid]
[KYC]     |       |
   |      v       v
   v   [Welcome] [Stay on Login]
[Step 3]  |
[Account] +---> [Deposit] --> [Update DB] --> [Return to Dashboard]
   |      |
   v      +---> [Withdrawal] --> [Update DB] --> [Return to Dashboard]
[Login]   |
          +---> [Mini Statement] --> [Fetch Last 5 Txns] --> [Display]
          |
          +---> [Balance Enquiry] --> [Sum Txns] --> [Display Balance]
          |
          +---> [PIN Change] --> [Update DB] --> [Return to Dashboard]
          |
          +---> [Exit] --> [Close Application]
```

### 7.3 Sequence Diagram — Login

```
User       login.java        dbcon.java       MySQL DB      welcome.java
 |               |                |               |               |
 |--[Enter Card# |                |               |               |
 |   & PIN]----->|                |               |               |
 |               |--[new dbcon()]-->              |               |
 |               |                |--[JDBC Connect]->             |
 |               |                |<--[Connection]--|             |
 |               |--[SELECT * FROM login WHERE     |               |
 |               |   card_number=? AND pin=?]------>               |
 |               |<-----------[ResultSet]----------|               |
 |               |                                                  |
 |               |--[if resultset.next()]-------------------------->|
 |               |                                 new welcome(pin)|
 |<-----------------------------------------[Dashboard Shown]-----|
```

### 7.4 Sequence Diagram — Deposit

```
User      welcome.java    deposit.java     dbcon.java      MySQL DB
 |              |               |               |               |
 |--[Click      |               |               |               |
 |   Deposit]-->|               |               |               |
 |              |--[new deposit(pin)]-->         |               |
 |              |               |               |               |
 |--[Enter Amount & Submit]---->|               |               |
 |              |               |--[new dbcon()]->              |
 |              |               |               |--[Connect]--> |
 |              |               |--[INSERT INTO bank]---------> |
 |              |               |<-----------[Success]----------|
 |<--[JOptionPane "Deposited Successfully"]------|               |
```

### 7.5 ER Diagram

```
SIGNUP (id PK, application_no, first_name, last_name, email,
        aadhar_number, phone_number, gender, dob, father_name,
        occupation, nationality, address, city, pin_code, state)
    |
    | 1:1 (application_no)
    |
SIGNUPTWO (id PK, application_no FK, religion, catagory,
           income, education, occupation, pan, aadhar, siblings)
    |
    | 1:1 (application_no)
    |
SIGNUP3 (application_no FK, account_type, card_number, pin, facility)
    |
    | 1:1 (card_number + pin)
    |
LOGIN (application_no FK, card_number, pin)
    |
    | 1:N (pin)
    |
BANK (pin FK, date, type, amount)
```

### 7.6 Class Diagram

```
+------------------+
|     dbcon        |
+------------------+
| +connection      |
| +statement       |
+------------------+
| +dbcon()         |
+------------------+
         ^
         | uses
         |
+--------+--------+   navigates   +------------------+
|    login        |-------------->|    welcome       |
+------------------+              +------------------+
| -t1: JTextField  |              | -pin: String     |
| -p1: JPasswordFd |              | -buttons: JButton|
| +login()         |              | +welcome(pin)    |
| +actionPerformed()|             | +actionPerformed()|
| +main()          |              +--+--+--+--+--+---+
+------------------+                 |  |  |  |  |
         |                           |  |  |  |  |
         | navigates            opens|  |  |  |  |
         v                           v  v  v  v  v
+------------------+    +---------+ +---------+ +----------+
|    signup        |    |deposit  | |withdrawal| |   mini  |
+------------------+    +---------+ +---------+ +----------+
| +signup()        |    |+deposit()| |+withdrawal| |+mini() |
| +actionPerformed()|   |+action..| |+action..| |          |
+------------------+    +---------+ +---------+ +----------+
         |
         v                               +------------+
    +----------+                         |  pinchange |
    | signup2  |                         +------------+
    +----------+                         |+pinchange()|
    | +signup2()|                        |+action..() |
    +----------+                         +------------+
         |
         v
    +----------+
    | signup3  |
    +----------+
    | +signup3()|
    +----------+
```

---

## 8. DESIGN DECISIONS & RATIONALE

| Decision | Rationale |
|----------|-----------|
| **Java Swing for GUI** | Swing is part of the standard Java library (no extra dependencies), cross-platform, and suitable for desktop banking applications |
| **MySQL for storage** | Relational database with strong ACID compliance ensures data integrity for financial transactions; MySQL is widely available and free |
| **Separate class per screen** | Follows Single Responsibility Principle; each class manages only one screen's logic, making the codebase maintainable and testable |
| **Centralized `dbcon` class** | All database connection parameters are in one place; changing the DB host, port, or credentials requires editing only `dbcon.java` |
| **PIN as user session token** | The PIN is passed between screens as a `String` parameter, acting as a lightweight session identifier without requiring a session management framework |
| **5 normalized tables** | The signup data is split across 3 tables (signup, signuptwo, signup3) reflecting the 3-step registration form; `login` and `bank` are separate for clear separation of authentication and transaction data |
| **JAR files included in repo** | Including `mysql-connector-java-8.0.28.jar` and `jcalendar-tz-1.3.3-4.jar` in the repository eliminates dependency management complexity for evaluators |
| **CLI scripts (compile.bat / run.sh)** | Enables command-line compilation and execution as required by evaluation guidelines, without needing an IDE |

---

## 9. IMPLEMENTATION DETAILS

### Package Structure
All source files reside in the `bank.management.system` package under `src/`:

```
src/bank/management/system/
├── dbcon.java       — Database connection (JDBC)
├── login.java       — Authentication screen + main() entry point
├── signup.java      — Registration Step 1
├── signup2.java     — Registration Step 2
├── signup3.java     — Registration Step 3 (card + PIN generation)
├── welcome.java     — Main dashboard
├── deposit.java     — Deposit transaction
├── withdrawal.java  — Withdrawal transaction
├── mini.java        — Mini statement viewer
└── pinchange.java   — PIN change module
```

### Key Implementation Details

**Database Connection (`dbcon.java`)**
```java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/banksystem", "root", "");
statement = connection.createStatement();
```
- Uses `DriverManager` to create a JDBC connection
- Exposes `Connection` and `Statement` objects for use by all other classes

**Login Authentication (`login.java`)**
```java
String q = "select * from login where card_number='" + cardno + "' and pin='" + pin + "'";
ResultSet resultset = c.statement.executeQuery(q);
if (resultset.next()) {
    new welcome(pin);  // Pass PIN as session token
}
```

**Transaction Recording (`deposit.java`)**
```java
String q = "insert into bank values('" + pin + "','" + date + "','Deposit','" + amount + "')";
c.statement.executeUpdate(q);
```

**Balance Calculation (`welcome.java`)**
- Queries all deposit amounts: `SELECT amount FROM bank WHERE pin=? AND type='Deposit'`
- Queries all withdrawal amounts: `SELECT amount FROM bank WHERE pin=? AND type='Withdrawal'`
- Displays: Total Deposits − Total Withdrawals

### External Libraries Used
| Library | Version | Purpose |
|---------|---------|---------|
| MySQL Connector/J | 8.0.28 | JDBC driver for MySQL connectivity |
| JCalendar | 1.3.3-4 | Date picker component used in signup forms |

---

## 10. SCREENSHOTS / RESULTS

### Application Screens

**Login Screen:**
- Displays bank logo, card number field, PIN field
- Sign-In and Sign-Up buttons
- Background image for visual appeal

**Welcome Dashboard:**
- Shows 6 operation buttons: Deposit, Cash Withdrawal, Mini Statement, Balance Enquiry, PIN Change, Exit
- ATM background image with user's name

**Deposit Screen:**
- Amount input field
- Deposit button triggers DB insert and shows success dialog

**Mini Statement:**
- Table showing last 5 transactions with date, type, and amount

**Signup Flow:**
- 3 sequential screens collecting progressively detailed information
- Auto-generated card number and PIN setup in Step 3

---

## 11. TESTING APPROACH

### Manual Testing

All modules were tested manually by running the application from the command line:

```cmd
compile.bat
run.bat
```

### Test Cases

| TC# | Module | Input | Expected Output | Result |
|-----|--------|-------|-----------------|--------|
| TC-01 | Login | Valid card + PIN | Redirect to dashboard | PASS |
| TC-02 | Login | Invalid card/PIN | Stay on login screen | PASS |
| TC-03 | Deposit | Amount = 5000 | Success dialog; DB updated | PASS |
| TC-04 | Withdrawal | Amount = 2000 | Success dialog; DB updated | PASS |
| TC-05 | Mini Stmt | 6+ transactions | Last 5 displayed | PASS |
| TC-06 | Balance | After 10000 dep, 2000 wd | Shows 8000 | PASS |
| TC-07 | PIN Change | Old PIN correct | PIN updated in DB | PASS |
| TC-08 | PIN Change | Old PIN wrong | Error shown | PASS |
| TC-09 | Signup | Complete all 3 steps | Account created in DB | PASS |
| TC-10 | Signup | New user login | Dashboard accessible | PASS |

### Database Validation

After each operation, the database was queried directly in MySQL to verify that data was written correctly:

```sql
-- Verify transactions
SELECT * FROM bank WHERE pin = '1234';

-- Verify PIN update
SELECT pin FROM login WHERE card_number = '1234567890123456';
```

---

## 12. CHALLENGES FACED

| Challenge | Description | Solution |
|-----------|-------------|----------|
| **Image path resolution** | Background images failed to load from relative paths in some environments | Used `ClassLoader.getSystemResource()` to load images from the classpath, which works regardless of working directory |
| **JCalendar integration** | The date picker library required explicit inclusion in the classpath | Included the JAR file directly in the project root and added it to compile/run scripts |
| **Session management without a framework** | Passing user identity between screens without cookies or sessions | Passed the user's PIN as a `String` constructor argument between screens |
| **Cross-platform execution** | Ensuring the project runs on both Windows and Linux without modification | Created both `compile.bat`/`run.bat` (Windows) and `run.sh` (Linux/macOS) scripts |
| **Database schema design** | Splitting signup data across 3 tables to match the 3-screen form while maintaining referential integrity | Used `application_no` as a consistent key linking all 3 signup tables |
| **Balance calculation** | No single balance column; balance must be derived from transactions | Computed balance dynamically by summing all deposits and subtracting all withdrawals from the `bank` table |

---

## 13. LEARNINGS & KEY TAKEAWAYS

1. **JDBC & MySQL Integration:** Gained practical experience connecting a Java application to a relational database using JDBC, executing SQL queries, and processing ResultSets.

2. **Event-Driven GUI Programming:** Implemented the `ActionListener` interface across multiple classes to handle user interactions in a Java Swing application.

3. **OOP in Practice:** Applied Object-Oriented principles — encapsulation (each screen as a class), abstraction (dbcon hides connection details), and modularization.

4. **3-Tier Architecture:** Understood how to separate presentation (Swing UI), business logic (ActionListener), and data (MySQL) layers in a desktop application.

5. **Database Design:** Designed a normalized relational schema with 5 tables and practiced writing SQL DDL (CREATE) and DML (INSERT, SELECT, UPDATE) statements.

6. **CLI Build Tooling:** Learned to compile and run a multi-file Java project with external JAR dependencies from the command line using `javac` and `java`.

7. **Version Control:** Used Git for tracking changes and published the project to GitHub with meaningful commit messages.

8. **Cross-Platform Scripting:** Created `.bat` and `.sh` scripts to ensure the project is executable on both Windows and Unix-based systems.

---

## 14. FUTURE ENHANCEMENTS

| Enhancement | Description | Priority |
|-------------|-------------|----------|
| **PIN Hashing** | Use BCrypt to hash PINs before storing in DB (prevents plaintext exposure) | HIGH |
| **Prepared Statements** | Replace string-concatenated SQL with `PreparedStatement` to prevent SQL injection | HIGH |
| **Fund Transfer** | Allow transfer between two accounts using card numbers | MEDIUM |
| **PDF Statement Export** | Generate downloadable PDF bank statements using iText library | MEDIUM |
| **Admin Panel** | Separate admin login to view all accounts and manage users | MEDIUM |
| **Account Freeze / Unfreeze** | Admin capability to lock accounts for suspicious activity | MEDIUM |
| **Transaction Receipts** | Print or save individual transaction receipts | LOW |
| **Web / Mobile Version** | Port to a Spring Boot REST API + React frontend or Android app | LOW |
| **Email Notifications** | Send email confirmations for transactions using JavaMail API | LOW |
| **Logging** | Implement application-level logging with `java.util.logging` or Log4j | LOW |

---

## 15. REFERENCES

1. Oracle Java Documentation — Java Swing Tutorial: https://docs.oracle.com/javase/tutorial/uiswing/
2. MySQL Connector/J Developer Guide: https://dev.mysql.com/doc/connector-j/en/
3. JDBC API Documentation: https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/
4. JCalendar Library: https://toedter.com/jcalendar/
5. Java ActionListener Interface: https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionListener.html
6. MySQL 8.0 Reference Manual: https://dev.mysql.com/doc/refman/8.0/en/
7. Git Documentation: https://git-scm.com/doc
8. GitHub Guides: https://guides.github.com/

---

*End of Project Report*

---
**Repository:** https://github.com/tiwarisuryansh6222/Bank-management-system-main
**Author:** Suryansh Tiwari | @tiwarisuryansh6222
