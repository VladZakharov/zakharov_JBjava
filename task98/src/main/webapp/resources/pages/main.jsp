<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 27.10.15
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<h1>Список клиник</h1>

<c:choose>
    <c:when test="${clinics.size() != 0}">
        <c:forEach items="${clinics}" var="clinic">
            <a href="/clinics/${clinic.id}">${clinic.name}</a><br>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>В базе данных не найдено ни одной клиники</p>
    </c:otherwise>
</c:choose>

<hr>
<a href="/clinics/add">Добавить новую клинику в базу данных</a>
<hr>
<a href="/generate/auto/10">Быстрая генерация (моделирует работу 10 клиник)</a>
<hr>
<a href="/generate/drop_db">Очистить БД</a>

</body>
</html>
