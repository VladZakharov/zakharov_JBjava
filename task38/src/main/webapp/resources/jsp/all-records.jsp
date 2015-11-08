<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Все записи</h1>

<core:forEach var="record" items="${records}">
    ${record.name} ${record.surname} ${record.midname} ${record.birthday} ${record.sex} <br/>
</core:forEach>

</body>
</html>
