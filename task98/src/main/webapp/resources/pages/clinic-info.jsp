<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 27.10.15
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clinic information</title>
</head>
<body>

<h1>Информация о клинике ${medicalClinic.name}</h1>

<h3>Дата основания: ${medicalClinic.creating_date}</h3>

<h3>Номер лицензии: ${medicalClinic.license_number}</h3>

<c:choose>
    <c:when test="${offices.size() != 0}">
        <a>Средняя зарплата работников клиники: ${avgSalary} руб. в час</a><br>
        <a>Средний чек клиентов клиники: ${avgCost} руб.</a><br>
        <a>Чистая прибыль: ${profit} руб.</a><br>
        <p>Офисы</p>
        <c:forEach items="${offices}" var="office">
            <a href="/offices/${office.id}">Офис в г. ${office.city}</a><br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>У клиники нет ни одного офиса</p>
    </c:otherwise>
</c:choose><hr>

<a href="${medicalClinic.id}/add_office">Добавить офис</a>

</body>
</html>
