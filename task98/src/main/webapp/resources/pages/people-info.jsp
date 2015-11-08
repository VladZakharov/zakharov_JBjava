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
    <title>People information</title>
</head>
<body>

<h1>Информация о человеке</h1>

<h3>ФИО: ${people.fio}</h3>

<h3>Паспортные данные: ${people.pasport_series} ${people.pasport_number} ${people.pasport_issued}</h3>

<hr>

<c:choose>
    <c:when test="${patientData != null}">
        <a>Дата посещения: ${patientData.visit_date}</a><br>
        <a>Чек: ${patientData.cost} руб.</a>
    </c:when>
    <c:when test="${stuffData != null}">
        <a>Принят на работу: ${stuffData.employent_date}</a><br>
        <c:if test="${stuffData.creatin_date != null}">
            Уволен: ${stuffData.creatin_date}<br>
        </c:if>
        <a>Часов в неделю: ${stuffData.expected_time}</a><br>
        <a>Ставка в час: ${stuffData.salary} руб.</a><br>
        <a>Отработано часов: ${stuffData.worked_hours}</a><br>
        <a>Месячная зарплата: ${monthSalary} руб.</a><br>
    </c:when>
</c:choose>
<hr>

</body>
</html>
