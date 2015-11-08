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

<h1>Информация об офисе</h1>

<h3>Город: ${office.city}</h3>

<h3>Улица: ${office.street}</h3>

<hr>

<c:choose>
    <c:when test="${patients.size() != 0}">
        <a>Средний чек клиентов офиса: ${avgCost} руб.</a><br>
        <p>Клиенты:</p>
        <c:forEach items="${patients}" var="patient">
            <a href="/peoples/${patient.id}">${patient.fio}</a><br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>Нет ни одного клиента</p>
    </c:otherwise>
</c:choose>
<a href="/offices/${office.id}/add_patient">Добавить клиента</a><hr>

<c:choose>
    <c:when test="${stuffs.size() != 0}">
        <a>Средняя зарплата работников офиса: ${avgSalary} руб. в час</a><br>
        <p>Работники:</p>
        <c:forEach items="${stuffs}" var="stuff">
            <a href="/peoples/${stuff.id}">${stuff.fio}</a><br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>Нет ни одного работника</p>
    </c:otherwise>
</c:choose>
<a href="/offices/${office.id}/add_stuff">Добавить работника</a><hr>

<c:choose>
    <c:when test="${providers.size() != 0}">
        <p>Поставщики услуг:</p>
        <c:forEach items="${providers}" var="provider">
            <a href="/providers/${provider.id}">${provider.name}</a><br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>Нет ни одного поставщика услуг</p>
    </c:otherwise>
</c:choose>
<a href="/offices/${office.id}/add_provider">Добавить поставщика услуг</a><hr>


<c:choose>
    <c:when test="${operSupps.size() != 0}">
        <p>Отчеты о доставке:</p>
        <c:forEach items="${operSupps}" var="operSupp">
            <a>Дата отправки: ${operSupp.begin_date}</a><br>
            <c:if test="${operSupp.end_date != null}">
                Дата доставки: ${operSupp.end_date}<br>
            </c:if>
            <a>Кол-во товаров в посылке: ${operSupp.count}</a><br>
            <a>Поставщик :</a>
            <a href="/providers/${operSupp.getProvider().getId()}">${operSupp.getProvider().getName()}</a><br>
            <hr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>Нет ни одного заказа</p>
    </c:otherwise>
</c:choose>
<a href="/offices/${office.id}/get_up_delivery">Оформить доставку оборудования</a><hr>

</body>
</html>
