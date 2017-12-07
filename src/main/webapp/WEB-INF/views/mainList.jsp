<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>TODO List</title>

    <c:url value="/files/css/style.css" var="css_url"/>
    <link rel="stylesheet" type="text/css" href="${css_url}">

    <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>

</head>
<body>


<h1>This is TODO List</h1>

<div id="target"></div>

<table id="listOfTasks">
    <tr>
        <th>Responsible person</th>
        <th>Task</th>
        <th>Estimated complexity in coffee cups</th>
        <th>Progress</th>
        <th>Action</th>
    </tr>
    <c:forEach var="task" items="${list.getList()}">
        <tr class="taskRow">
            <td id="personCell">${task.getPerson()}</td>
            <td id="taskCell">${task.getTask()}</td>
            <td>
                <c:set value="${task.getAmountOfCoffeeCups()}" var="coffee"/>
                <c:choose>
                    <c:when test="${coffee == 0 }" >
                        no estimate
                    </c:when>
                    <c:otherwise>
                        ${task.getAmountOfCoffeeCups()}
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <progress value="${task.getUsedCoffeeCups()}" max="${task.getAmountOfCoffeeCups()}"></progress>
            </td>
            <td>
                <input type="button" value="log consumed coffee cup"
                       onclick="logCoffeeCup(this.parentElement.parentElement)">
                <input type="button" value="Remove task"
                       onclick="removeTask(this,'${task.getPerson()}','${task.getTask()}' )">
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Add new task</h3> <span id="generalErrorField" style="color:red"></span>
<form id="newTaskForm" onsubmit="addTask()">
    <label for="personField"> Person: </label>  <span id="personErrorField" style="color:red"> </span> <br>
    <input id="personField" type="text" name="person"/> <br>
    <label for="taskField">Task:</label>  <span id="taskErrorField" style="color:red"> </span> <br>
    <input id="taskField" type="text" name="task"/> <br>
    <label for="coffeeField">Estimated complexity in coffee cups: </label> <span id="coffeeErrorField" style="color:red"> </span> <br>
    <input id="coffeeField" type="text" name="coffee"/> <br>
    <input type="submit"/>
</form>

<c:url value="/files/js/some.js" var="some_url"/>
<script type="text/javascript" src="${some_url}"></script>





</body>
</html>