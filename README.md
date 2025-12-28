# Student Registration App

This is a simple Java web application for managing student registrations, built with JSP, Servlets, and MySQL. It provides functionality to add new students and view all registered students.

---

## Features

* Register new students with name, email, and year.
* View a list of all registered students.
* Simple and clean interface.
* Backend handled with Servlets and JDBC.
* Responsive design using basic CSS.

---

## Screenshots

### Desktop
<img width="1280" height="695" alt="image" src="https://github.com/user-attachments/assets/6dc8aaaa-260a-4b76-b651-b303fcc95445" />


<img width="1280" height="693" alt="image" src="https://github.com/user-attachments/assets/ad70c552-42d8-4821-8e86-a758968d966c" />

---

## Technologies Used

* Java 25
* Tomcat 10+
* JSP and Servlets
* MySQL 9.5.0
* Maven for dependency management
* JSTL for dynamic content in JSP

---

## Installation and Setup

1. **Database Setup**

   * Start MySQL server (XAMPP or your preferred method).
   * Create the database and table by running the SQL script `student_registration.sql`:

     ```sql
     CREATE DATABASE IF NOT EXISTS student_db;
     USE student_db;

     CREATE TABLE IF NOT EXISTS students (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(100) NOT NULL,
         email VARCHAR(100) NOT NULL UNIQUE,
         `year` INT NOT NULL
     );
     ```

2. **Project Setup**

   * Import the project into IntelliJ IDEA as a Maven project.
   * Make sure Maven dependencies are loaded.
   * Ensure Tomcat 10+ is configured in IntelliJ.
   * Update `DBConnection.java` with your MySQL username and password.

3. **Running the Application**

   * Build and deploy the project on Tomcat via IntelliJ.
   * Open the browser at `http://localhost:8080/student-registration-app`.

---

## Project Structure

```
student-registration-app/
├─ src/main/java/com/example/studentapp/
│  ├─ controller/  # Servlets
│  ├─ dao/         # Database access
│  ├─ model/       # Student class
│  └─ util/        # DB connection utility
├─ src/main/webapp/
│  ├─ index.jsp
│  ├─ register.jsp
│  ├─ show_all.jsp
│  └─ css/style.css
├─ pom.xml
├─ README.md
```

---

## Author
Tursina

📧 Email: yisehaktursina@gmail.com) 💼 LinkedIn: https://in/tursina-yisehak-7a9942358 🐙 GitHub:https://github.com/tuyy-99

---

## License

This project is open-source and free to use for learning and personal projects.
