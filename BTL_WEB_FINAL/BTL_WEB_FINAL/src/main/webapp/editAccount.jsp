<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Account</title>
</head>
<body>
<h2>Edit Account</h2>
<form action="updateAccount" method="post">
    <input type="hidden" name="id" value="${accountId}">
    <label for="user">User:</label>
    <input type="text" id="user" name="user"><br><br>

    <label for="isAdmin">Is Admin:</label>
    <select id="isAdmin" name="isAdmin">
        <option value="0">No</option>
        <option value="1">Yes</option>
    </select><br><br>

    <label for="status">Status:</label>
    <select id="status" name="status">
        <option value="0">Inactive</option>
        <option value="1">Active</option>
    </select><br><br>

    <input type="submit" value="Update">
</form>
</body>
</html>
