# Student Registration Web Application

This is a simple Java Servlet + JSP web application that lets users:
- Register students into a MySQL database via `/register`
- View all registered students in a table via `/show_all`

The app uses:
- Java 11
- Maven
- JSP + JSTL
- MySQL
- Apache Tomcat (tested with Tomcat 9)

## Project Structure

- `src/main/java/com/example/studentapp/model/Student.java` – Student entity (id, name, email, year)
- `src/main/java/com/example/studentapp/dao/StudentDAO.java` – Data access object for `students` table
- `src/main/java/com/example/studentapp/util/DBConnection.java` – Creates JDBC connection to MySQL
- `src/main/java/com/example/studentapp/controller/StudentServlet.java` – Handles `/new`, `/register`, `/show_all`
- `src/main/webapp/index.jsp` – Home page with links
- `src/main/webapp/register.jsp` – Registration form (POST `/register`)
- `src/main/webapp/show_all.jsp` – Table listing all students
- `src/main/webapp/WEB-INF/web.xml` – Web application descriptor
- `src/main/resources/01_sechema.sql` – SQL script to create database and table

## Database Setup (MySQL)

1. Start your MySQL server.
2. Run the SQL script once to create the database and table.

### Option A: Command line

From the project root:

```bash
mysql -u root -p < src/main/resources/01_sechema.sql
```

Replace `root` with your MySQL username if different.

### Option B: MySQL Workbench

1. Open MySQL Workbench and connect to your server.
2. Open `src/main/resources/01_sechema.sql`.
3. Execute the script.

The script creates:

```sql
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;
CREATE TABLE IF NOT EXISTS students (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    year INT NOT NULL
);
```

## Configure Database Credentials

Edit `src/main/java/com/example/studentapp/util/DBConnection.java` and set the username and password to match your MySQL setup:

```java
private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_db";
private static final String JDBC_USERNAME = "root";          // your MySQL user
private static final String JDBC_PASSWORD = "your_password"; // your MySQL password
```

Make sure MySQL is running and listening on `localhost:3306`.

## Build the Application

From the project root:

```bash
mvn clean package
```

This builds `target/student-registration-app.war` and an exploded directory under `target/student-registration-app/` with all compiled classes and libraries (including the MySQL connector).

## Deploy to Tomcat

### Via Tomcat webapps folder

1. Copy `target/student-registration-app.war` to Tomcat's `webapps` directory.
2. Start Tomcat.
3. Access the app at:
   - `http://localhost:8080/student-registration-app/`

### Via IDE (IntelliJ IDEA example)

1. Import the project as a Maven project.
2. Configure a Tomcat run configuration.
3. Add the artifact `student-registration-app:war` or `student-registration-app:war exploded` as a deployment.
4. Run Tomcat from the IDE.

Ensure that the deployed artifact contains `mysql-connector-java-8.0.33.jar` under `WEB-INF/lib`. If not, refresh Maven and rebuild.

## How to Use the Application

1. Go to the home page:
   - `http://localhost:8080/student-registration-app/` (context path may vary)
2. Click **"Register New Student"** to open the registration form (`/new`).
3. Fill in **Name**, **Email**, and **Year**, then submit.
   - The form sends a POST request to `/register`.
   - The servlet validates and inserts into the `students` table.
4. After successful registration you are redirected to `/show_all`.
   - This page displays a table with all students (ID, Name, Email, Year).

## Running Tests

From the project root you can run unit tests (if added) with:

```bash
mvn test
```

## Common Problems

- **HTTP 500: MySQL JDBC Driver not found**
  - Make sure `mysql-connector-java-8.0.33.jar` is present under `WEB-INF/lib` in the deployed application.
  - Run `mvn clean package` and redeploy the generated WAR.

- **Cannot connect to database**
  - Verify `JDBC_URL`, `JDBC_USERNAME`, `JDBC_PASSWORD` in `DBConnection.java`.
  - Ensure MySQL is running and `student_db` / `students` table exist.

This README is meant to guide you (and anyone else) from clone → database setup → build → run → use.
