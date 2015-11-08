<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 07.10.15
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<link rel="stylesheet" type="text/css" href="css/style.css">--%>
    <%--<link rel="javascript" type="text/javascript" src="js/script.js">--%>
    <style>
        <%@ include file="css/style.css"%>
    </style>

    <script>

        var n = 0;

        function reset_n() {
            n = 0;
        }

        function set(val) {
            reset_n();
            document.getElementById("display").value = val;
        }

        function add(val) {
            if (n == 0){
                set(val);
            } else {
                document.getElementById("display").value += val;
            }
            n++;
        }

    </script>
</head>
<body>
<h2>WebCalculator</h2>
<div class="box">


    <form action="/" method="POST">
        <div class="display">
            <input type="text" <%--readonly--%> size="17" id="display" name="result" value= ${result} >
        </div>
        <div class="keys">
            <p>
                <input type="button" class="button gray" value="(" onclick='add("(")'>
                <input type="button" class="button gray" value=")" onclick='add(")")'>
                <input type="button" class="button gray" value="^" onclick='add("^")'>
                <input type="button" class="button pink" value="/" onclick='add("/")'>
            </p>
            <p>
                <input type="button" class="button black" value="7" onclick='add("7")'>
                <input type="button" class="button black" value="8" onclick='add("8")'>
                <input type="button" class="button black" value="9" onclick='add("9")'>
                <input type="button" class="button pink" value="*" onclick='add("*")'>
            </p>
            <p>
                <input type="button" class="button black" value="4" onclick='add("4")'>
                <input type="button" class="button black" value="5" onclick='add("5")'>
                <input type="button" class="button black" value="6" onclick='add("6")'>
                <input type="button" class="button pink" value="-" onclick='add("-")'>
            </p>
            <p>
                <input type="button" class="button black" value="1" onclick='add("1")'>
                <input type="button" class="button black" value="2" onclick='add("2")'>
                <input type="button" class="button black" value="3" onclick='add("3")'>
                <input type="button" class="button pink" value="+" onclick='add("+")'>
            </p>
            <p><input type="button" class="button black" value="0" onclick='add("0")'>
                <input type="button" class="button black" value="." onclick='add(".")'>
                <input type="button" class="button black" value="C" onclick='set("")'>
                <input type="submit" class="button orange" value="=" onclick='reset_n()'/>
            </p>
        </div>
    </form>
</div>

</body>
</html>