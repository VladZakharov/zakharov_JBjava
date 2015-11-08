<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Hello, man. Try it.</h1>

<sf:form action="/add_record" method="post" modelAttribute="record">

    <sf:label path="name">Name: </sf:label>
    <sf:input path="name"/>
    <sf:errors path="name"/> <br>

    <sf:label path="surname">Surname: </sf:label>
    <sf:input path="surname"/>
    <sf:errors path="surname"/> <br>

    <sf:label path="midname">Middle name: </sf:label>
    <sf:input path="midname"/>
    <sf:errors path="midname"/> <br>

    <sf:label path="birthday">Birth date: </sf:label>
    <sf:input path="birthday"/>
    <sf:errors path="birthday"/> <br>

    <sf:label path="sex">Sex (нет, не секс, а пол): </sf:label>
    <sf:input path="sex"/>
    <sf:errors path="sex"/> <br>

    <button type="submit">Добавить</button>
</sf:form>

</body>
</html>
