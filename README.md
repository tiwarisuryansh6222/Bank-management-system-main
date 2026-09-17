🏦 Bank Management System (Java + MySQL)

A Java Swing-based desktop banking application that allows users to perform essential banking operations such as deposits, withdrawals, PIN changes, balance checks, and viewing mini statements.
Built using Java, Swing, and MySQL, this project demonstrates GUI-based transaction handling with database integration.

⸻

💡 Features

✅ Login Authentication — Users log in using a unique PIN
✅ Deposit & Withdrawal — Perform transactions securely
✅ Mini Statement — Displays the last 5 transactions from the database
✅ Balance Enquiry — Shows the real-time account balance
✅ PIN Change — Allows users to change their PIN
✅ Exit Option — Safely close the application
✅ MySQL Integration — All operations are stored and fetched dynamically

⸻

🧰 Technologies Used

Component	Technology
Language	Java
GUI Framework	Java Swing / AWT
Database	MySQL
IDE	IntelliJ IDEA
JDBC Driver	MySQL Connector/J


⸻

⚙️ Project Structure

bankmanagementsystem/
│
├── src/bank/management/system/
│   ├── login.java
│   ├── signup.java
│   ├── welcome.java        # main dashboard screen
│   ├── deposit.java
│   ├── withdrawal.java
│   ├── pinchange.java
│   ├── mini.java
│   ├── dbcon.java          # database connection class
│
├── mysql-connector-java-8.0.xx.jar
├── README.md
└── .gitignore


⸻

🖥️ How to Run
	1.	Open the project in IntelliJ IDEA
	2.	Add mysql-connector-java-8.0.xx.jar to your classpath
	3.	Ensure MySQL is running
	4.	Run the login.java file first to log in
	5.	After successful login, you’ll be redirected to the welcome.java dashboard

⸻

🧾 Application Flow

Login → Welcome Screen → Choose Operation → Database Update → Confirmation/Output

Each button in welcome.java leads to a specific operation window:

Button	Function
Deposit	Opens deposit.java
Cash Withdrawal	Opens withdrawal.java
Mini Statement	Opens mini.java
Pin Change	Opens pinchange.java
Balance Enquiry	Displays current balance
Exit	Closes the application


⸻

🎨 GUI Preview

The welcome.java screen is styled with Swing components:
	•	Bold fonts (Raleway)
	•	Red text + blue buttons
	•	ATM background image (icon/atm2.png)

⸻

👨‍💻 Developer

Author: Sparsh Joshi

GitHub: @sparshhjoshi￼

Project: Bank Management System

⸻

📌 Future Enhancements
	•	Add user account creation via signup form
	•	Integrate password/PIN hashing for security
	•	Add transaction receipts
	•	Implement export to PDF for mini statements

⸻
