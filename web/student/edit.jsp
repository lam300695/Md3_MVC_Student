<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit student</title>
</head>
<body>
<h1>Edit student</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/students">Back to student list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input type="text" name="id" id="id" value="${requestScope["student"].getId()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["student"].getName()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope["student"].getEmail()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>