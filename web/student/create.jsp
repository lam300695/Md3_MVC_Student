<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<h1>Create new Student</h1>
<p>
    <a href="/students"> Back to student list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email :</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>submit :</td>
                <td><input type="submit" value="Create Student"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
