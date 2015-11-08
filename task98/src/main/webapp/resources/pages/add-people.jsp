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
    <title>Adding new ${type}</title>
</head>
<body>

<h1>Заполните форму</h1>

<sf:form action="/offices/${office_id}/add_${type}/process" method="post" modelAttribute="people">

    <sf:label path="fio">ФИО: </sf:label>
    <sf:input path="fio"/>
    <sf:errors path="fio"/> <br>

    <sf:label path="pasport_series">Серия: </sf:label>
    <sf:input path="pasport_series" />
    <sf:errors path="pasport_series"/> <br>

    <sf:label path="pasport_number">Номер: </sf:label>
    <sf:input path="pasport_number" />
    <sf:errors path="pasport_number"/> <br>

    <sf:label path="pasport_issued">Кем выдан: </sf:label>
    <sf:input path="pasport_issued" />
    <sf:errors path="pasport_issued"/> <br>

    <button type="submit">Добавить</button>
</sf:form>

</body>
</html>
