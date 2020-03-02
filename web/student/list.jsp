<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h1>Students</h1>
<p>
    <a href="/students?action=create">Create new student</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><a href="/students?action=view&id=${student.getId()}">${student.getName()}</a></td>
            <td>${student.getEmail()}</td>
            <td><a href="/students?action=edit&id=${student.getId()}">edit</a></td>
            <td><a href="/students?action=delete&id=${student.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>