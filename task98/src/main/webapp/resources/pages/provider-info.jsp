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
    <title>Provider information</title>
</head>
<body>

<h1>Информация о поставщике услуг</h1>

<h3>Имя: ${provider.name}</h3>

<hr>

<h2>Юридическая информация</h2>

<h3>Номер: ${provider.juridicalInfo.number}</h3>

<h3>Серия: ${provider.juridicalInfo.series}</h3>

<a href="/offices/${office.id}/edit_ji">Править юр. информацию</a>

</body>
</html>
