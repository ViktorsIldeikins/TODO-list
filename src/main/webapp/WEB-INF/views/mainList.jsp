<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>TODO List</title>
    <style>
        table, th, td {
            border: 1px solid #4e3184;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1>This is TODO List</h1>

<table>
    <tr>
        <th>Responsible person</th>
        <th>Task</th>
    </tr>
    <c:forEach var="task" items="${list.getList()}">
        <tr>
            <td>${task.getPerson()}</td>
            <td>${task.getTask()}</td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/removeTask" method="post">

                    <input type="hidden" name="person" value="${task.getPerson()}"/>
                    <input type="hidden" name="task" value="${task.getTask()}"/>
                    <input type="submit" value="Remove task"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Add new task</h3>
<form action="${pageContext.servletContext.contextPath}/addTask" method="POST">
    <label>
        Person:
        <input type="text" name="person"/>
    </label> <br>
    <label>
        Task:
        <input type="text" name="task"/>
    </label> <br>
    <input type="submit" value="Submit"/>
</form>

</body>