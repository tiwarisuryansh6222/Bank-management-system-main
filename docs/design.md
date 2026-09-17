# 🏦 Bank Management System — System Design & Architecture

---

## 1. System Architecture

The application follows a **3-Tier Client-Server Architecture**:

```
┌─────────────────────────────────────────────────────────┐
│                    PRESENTATION LAYER                    │
│          Java Swing / AWT GUI Components                 │
│  login │ signup │ welcome │ deposit │ withdrawal │ mini  │
└───────────────────────┬─────────────────────────────────┘
                        │ Java method calls
┌───────────────────────▼─────────────────────────────────┐
│                    BUSINESS LOGIC LAYER                  │
│         Java Classes (ActionListener, Event Handling)    │
│     Input Validation │ Transaction Logic │ Navigation    │
└───────────────────────┬─────────────────────────────────┘
                        │ JDBC (SQL Queries)
┌───────────────────────▼─────────────────────────────────┐
│                      DATA LAYER                          │
│              MySQL Database (banksystem)                 │
│   signup │ signuptwo │ signup3 │ login │ bank (tables)   │
└─────────────────────────────────────────────────────────┘
```

---

## 2. Use Case Diagram

```mermaid
graph TD
    User((👤 User / Customer))

    User --> UC1[Register New Account]
    User --> UC2[Login to System]
    User --> UC3[Deposit Money]
    User --> UC4[Withdraw Money]
    User --> UC5[View Mini Statement]
    User --> UC6[Check Balance]
    User --> UC7[Change PIN]
    User --> UC8[Logout / Exit]

    UC1 --> UC1a[Fill Personal Details - Step 1]
    UC1 --> UC1b[Fill KYC Details - Step 2]
    UC1 --> UC1c[Select Account Type & PIN - Step 3]

    UC2 --> UC2a{Credentials Valid?}
    UC2a -- Yes --> UC9[Access Dashboard]
    UC2a -- No --> UC2b[Show Error]
```

---

## 3. Class Diagram

```mermaid
classDiagram
    class dbcon {
        +Connection connection
        +Statement statement
        +dbcon()
    }

    class login {
        -JTextField t1
        -JPasswordField p1
        -JButton b1, b2, b3
        +login()
        +actionPerformed(ActionEvent e)
        +main(String[] args)
    }

    class signup {
        -JTextField fields[]
        -JButton next
        +signup()
        +actionPerformed(ActionEvent e)
    }

    class signup2 {
        -JTextField fields[]
        -JButton next
        +signup2(String appNo)
        +actionPerformed(ActionEvent e)
    }

    class signup3 {
        -JTextField fields[]
        -JButton submit
        +signup3(String appNo)
        +actionPerformed(ActionEvent e)
    }

    class welcome {
        -JButton deposit, withdraw, mini, pin, balance, exit
        -String pin
        +welcome(String pin)
        +actionPerformed(ActionEvent e)
    }

    class deposit {
        -JTextField amount
        -JButton submit
        -String pin
        +deposit(String pin)
        +actionPerformed(ActionEvent e)
    }

    class withdrawal {
        -JTextField amount
        -JButton submit
        -String pin
        +withdrawal(String pin)
        +actionPerformed(ActionEvent e)
    }

    class mini {
        -JTextArea statement
        -String pin
        +mini(String pin)
    }

    class pinchange {
        -JPasswordField oldPin, newPin, confirmPin
        -JButton submit
        +pinchange(String pin)
        +actionPerformed(ActionEvent e)
    }

    login --> dbcon : uses
    login --> welcome : navigates to
    login --> signup : navigates to
    signup --> signup2 : navigates to
    signup2 --> signup3 : navigates to
    signup3 --> login : navigates to
    welcome --> deposit : opens
    welcome --> withdrawal : opens
    welcome --> mini : opens
    welcome --> pinchange : opens
    deposit --> dbcon : uses
    withdrawal --> dbcon : uses
    mini --> dbcon : uses
    pinchange --> dbcon : uses
    signup --> dbcon : uses
    signup2 --> dbcon : uses
    signup3 --> dbcon : uses
```

---

## 4. Sequence Diagram — Login Flow

```mermaid
sequenceDiagram
    actor User
    participant LoginUI as login.java
    participant DB as dbcon.java
    participant MySQL as MySQL DB
    participant Dashboard as welcome.java

    User->>LoginUI: Enter Card Number & PIN
    User->>LoginUI: Click Sign-In
    LoginUI->>DB: new dbcon()
    DB->>MySQL: DriverManager.getConnection()
    MySQL-->>DB: Connection established
    LoginUI->>MySQL: SELECT * FROM login WHERE card_number=? AND pin=?
    MySQL-->>LoginUI: ResultSet (match found / not found)
    alt Credentials Valid
        LoginUI->>Dashboard: new welcome(pin)
        Dashboard-->>User: Show Banking Dashboard
    else Invalid Credentials
        LoginUI-->>User: Stay on login screen (no feedback shown)
    end
```

---

## 5. Sequence Diagram — Deposit Flow

```mermaid
sequenceDiagram
    actor User
    participant Dashboard as welcome.java
    participant DepositUI as deposit.java
    participant DB as dbcon.java
    participant MySQL as MySQL DB

    User->>Dashboard: Click "Deposit" button
    Dashboard->>DepositUI: new deposit(pin)
    User->>DepositUI: Enter amount
    User->>DepositUI: Click "Deposit"
    DepositUI->>DB: new dbcon()
    DepositUI->>MySQL: INSERT INTO bank (pin, date, type, amount)
    MySQL-->>DepositUI: Success
    DepositUI-->>User: Show confirmation dialog
```

---

## 6. ER Diagram (Entity-Relationship)

```mermaid
erDiagram
    SIGNUP {
        int id PK
        int application_no
        varchar first_name
        varchar last_name
        varchar email
        varchar aadhar_number
        varchar phone_number
        varchar gender
        date dob
        varchar father_name
        varchar occupation
        varchar nationality
        varchar address
        varchar city
        varchar pin_code
        varchar state
    }

    SIGNUPTWO {
        int id PK
        int application_no FK
        varchar religion
        varchar catagory
        varchar income
        varchar education
        varchar occupation
        varchar pan
        varchar aadhar
        varchar siblings
    }

    SIGNUP3 {
        int application_no FK
        varchar account_type
        varchar card_number
        varchar pin
        varchar facility
    }

    LOGIN {
        int application_no FK
        varchar card_number
        varchar pin
    }

    BANK {
        varchar pin FK
        varchar date
        varchar type
        varchar amount
    }

    SIGNUP ||--|| SIGNUPTWO : "has KYC"
    SIGNUP ||--|| SIGNUP3 : "has account"
    SIGNUP3 ||--|| LOGIN : "generates credentials"
    LOGIN ||--o{ BANK : "records transactions"
```

---

## 7. Process / Workflow Diagram

```mermaid
flowchart TD
    A([Start]) --> B[Open Application]
    B --> C{New User?}

    C -- Yes --> D[Signup Step 1: Personal Info]
    D --> E[Signup Step 2: KYC Details]
    E --> F[Signup Step 3: Account Type & PIN]
    F --> G[Credentials stored in DB]
    G --> H[Return to Login]

    C -- No --> H
    H --> I[Enter Card Number & PIN]
    I --> J{Valid Credentials?}
    J -- No --> I
    J -- Yes --> K[Welcome Dashboard]

    K --> L{Choose Operation}
    L --> M[Deposit]
    L --> N[Withdrawal]
    L --> O[Mini Statement]
    L --> P[Balance Enquiry]
    L --> Q[PIN Change]
    L --> R[Exit]

    M --> S[Update bank table]
    N --> S
    S --> K

    O --> T[Query last 5 records]
    T --> K

    P --> U[Sum all transactions]
    U --> K

    Q --> V[Update login & signup3 tables]
    V --> K

    R --> W([End])
```

---

## 8. Database Schema

| Table | Purpose |
|-------|---------|
| `signup` | Stores personal information from signup step 1 |
| `signuptwo` | Stores KYC/additional info from signup step 2 |
| `signup3` | Stores account type, card number, PIN, and facilities |
| `login` | Stores credentials used for authentication |
| `bank` | Stores all transaction records (deposit/withdrawal) |

### Key Relationships
- `application_no` links `signup` → `signuptwo` → `signup3` → `login`
- `pin` links `login` → `bank` (transaction history)
