# EMS

## 📌 Purpose
This project is designed to store and manage student registration details **course-wise**, using technologies such as **JSP, Servlet, MySQL**, and follows the **MVC Architecture**.  

### Features:
- Admin login/logout functionality.
- Admin can:
  - Add new student registrations.
  - View the list of registrations based on their **User ID**.
  - Update student details.
  - Delete student records.  
  *(Supports full CRUD operations)*  
- Automatic session timeout after **90 seconds** of inactivity, requiring re-login.

---

## 🛠️ Tech Stack
- **Frontend:** JSP  
- **Backend:** Servlet, MySQL  
- **Architecture:** MVC  

---

## 🗄️ Database Setup

### Database Queries
```sql
CREATE DATABASE sms_1;
USE sms_1;

# Create Admin Table

create table admin(
id int auto_increment primary key,
name varchar(45),
email varchar(128),
password varchar(14),
userid varchar(45) unique
);

select * from admin;

insert into admin values(1, 'admin1', 'test.admin1@gmail.com', 'test@123', 'testadmin1');
insert into admin values(2, 'admin2', 'test.admin2@gmail.com', 'test@123', 'testadmin2');

select * from admin;

# Create Student Registration Table

create table student_registration(
id int auto_increment primary key,
first_name varchar(45) not null,
last_name varchar(45) not null,
email varchar(128) unique,
mobile varchar(10) unique,
city varchar(45) not null,
course varchar(45) not null,
userid VARCHAR(45), 
FOREIGN KEY (userid) REFERENCES admin(userid)
);

select * from student_registration;

