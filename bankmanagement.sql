create database banksystem;
use banksystem;
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
SELECT * FROM signup;
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
SELECT * FROM signuptwo;

create table signup3 (application_no INT NOT NULL, account_type varchar (40), card_number varchar (40) , pin varchar(30) , facility varchar (200)  );
select * from signup3;

create table login (application_no INT NOT NULL, card_number varchar (50), pin varchar(40));
select * from login;
create table bank(pin varchar(20), date varchar (50), type varchar(50), amount varchar (50));
select * from bank;


