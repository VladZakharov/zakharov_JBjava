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
    <title>Adding new provider</title>
</head>
<body>

<h1>Заполните форму</h1>

<sf:form action="/offices/${office_id}/add_provider/process" method="post" modelAttribute="provider">

    <sf:label path="name">Имя: </sf:label>
    <sf:input path="name"/>
    <sf:errors path="name"/> <br>

    <button type="submit">Добавить поставщика услуг</button>
</sf:form>

</body>
</html>
