<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register Student</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Student Registration</h2>
        <form action="register" method="post">
            <div class="form-group">
                <label>Student Name:</label>
                <input type="text" name="name" required>
            </div>
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" required>
            </div>
            <div class="form-group">
                <label>Year:</label>
                <input type="number" name="year" required>
            </div>
            <button type="submit">Register</button>
        </form>
        <br>
        <a href="index.jsp">Back to Home</a>
    </div>
</body>
</html>
