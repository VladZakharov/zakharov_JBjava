<%@ page import="ru.kpfu.itis.model.enums.SubjectType" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1> Student ${student_name} subjects: </h1>

<sf:form action="/students/${student_id}/set_scores" method="post" modelAttribute="subject">

    <c:choose>
        <c:when test="${subjects.size() != 0}">

            <c:forEach items="${subjects}" var="sub">
                <option>${sub.subjectType.name()} score: ${sub.score} </option>
                <a href="/scores/${student_id}/${sub.id}/remove"> remove</a>
            </c:forEach>
            <hr>
            <a type="text">Average score: ${aScore}</a><br>
            <a type="text">Total score: ${tScore}</a><br>

        </c:when>
        <c:otherwise>
            <p>Where is no subjects yet</p>
        </c:otherwise>
    </c:choose>
    <hr>

    <p>Adding subject </p>
    <select name="subjectType">
        <c:forEach items="<%=SubjectType.values()%>" var="sType">
            <option value="${sType}">${sType.name()}</option>
        </c:forEach>
    </select>

    <sf:label path="score">${subject.subjectType.name()} score: </sf:label>
    <sf:input path="score"/>
    <%--<sf:errors path="surname"/><br>--%>

    <button type="submit">Submit</button>
</sf:form>

</body>
<head>
    <title>Title</title>
</head>
</html>
