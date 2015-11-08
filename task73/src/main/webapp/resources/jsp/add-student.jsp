<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Добавление нового студента: </h1>

<sf:form action="/students/add_student" method="post" modelAttribute="student">

    <sf:label path="surname">Фамилия: </sf:label>
    <sf:input path="surname"/>
    <sf:errors path="surname"/><br>

    <sf:label path="name">Имя:</sf:label>
    <sf:input path="name"/>
    <sf:errors path="name"/><br>

    <sf:label path="lastname">Отчество: </sf:label>
    <sf:input path="lastname"/>
    <sf:errors path="lastname"/><br>

    <sf:label path="group">Группа: </sf:label>
    <sf:input path="group"/>
    <sf:errors path="group"/><br>

    <button type="submit">Сохранить</button>
</sf:form>

</body>
</html>
