<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of students</title>
</head>
<body>
<h1>Список студентов</h1>

<a href="/students/add">Add new student</a><br><br>

<core:forEach var="student" items="${students}">
    ${student.surname} ${student.name} ${student.lastname} ${student.group}
    <a href="/students/${student.id}/info">Information</a>
</core:forEach>


</body>
</html>
