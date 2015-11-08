<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 27.10.15
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding new clinic</title>
</head>
<body>

<h1>Заполните форму</h1>

<sf:form action="/clinics/add/process" method="post" modelAttribute="clinic">

    <sf:label path="name">Название клиники: </sf:label>
    <sf:input path="name"/>
    <sf:errors path="name"/> <br>

    <sf:label path="creating_date">Дата основания: </sf:label>
    <sf:input path="creating_date" />
    <sf:errors path="creating_date"/> <br>

    <sf:label path="license_number">Номер лицензии: </sf:label>
    <sf:input path="license_number"/>
    <sf:errors path="license_number"/> <br>

    <button type="submit">Сохранить</button>
</sf:form>

</body>
</html>
