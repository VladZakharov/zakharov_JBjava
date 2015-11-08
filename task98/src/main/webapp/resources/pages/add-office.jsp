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
    <title>Adding new office</title>
</head>
<body>

<h1>Заполните форму</h1>

<sf:form action="/clinics/${clinic_id}/add_office/process" method="post" modelAttribute="office">

    <sf:label path="city">Город: </sf:label>
    <sf:input path="city"/>
    <sf:errors path="city"/> <br>

    <sf:label path="street">Улица: </sf:label>
    <sf:input path="street" />
    <sf:errors path="street"/> <br>


    <button type="submit">Добавить офис</button>
</sf:form>

</body>
</html>
