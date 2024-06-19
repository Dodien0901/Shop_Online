<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Account Management</title>
</head>
<body>
<h2>Account Management</h2>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>User</th>
    <th>Is Admin</th>
    <th>Status</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${accountList}" var="account">
    <tr>
      <td>${account.id}</td>
      <td>${account.user}</td>
      <td>${account.isAdmin == 1 ? 'Yes' : 'No'}</td>
      <td>${account.status}</td>
      <td>
        <a href="editAccount?id=${account.id}">Edit</a>
        <a href="deleteAccount?id=${account.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
