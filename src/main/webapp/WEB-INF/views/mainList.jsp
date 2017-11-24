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
    <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>


<h1>This is TODO List</h1>

<div id="target"></div>

<table id="list of tasks">
    <tr>
        <th>Responsible person</th>
        <th>Task</th>
    </tr>
    <c:forEach var="task" items="${list.getList()}">
        <tr>
            <td>${task.getPerson()}</td>
            <td>${task.getTask()}</td>
            <td>
                <input type="button" value="Remove task"
                       onclick="removeTask(this,'${task.getPerson()}','${task.getTask()}' )">
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Add new task</h3>
<%--<form action="${pageContext.servletContext.contextPath}/addTask" method="POST">--%>
<form id="newTaskForm" onsubmit="addTask()">
    <label>
        Person:
        <input id="personField" type="text" name="person"/>
    </label> <br>
    <label>
        Task:
        <input id="taskField" type="text" name="task"/>
    </label> <br>
    <input type="submit"/>
</form>


<script type="text/javascript">
    $("#newTaskForm").submit(function (e) {
        e.preventDefault();
    })

    function addTask() {
        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "/todolist/addTask",
                data: $("#newTaskForm").serialize()
            }).done(function (result) {
                if (result === "success") {
                    var table = document.getElementById("list of tasks");
                    var row = table.insertRow(table.rows.length);
                    row.insertCell(0).innerHTML = document.getElementById("personField").value;
                    row.insertCell(1).innerHTML = document.getElementById("taskField").value;
                    row.insertCell(2).innerHTML = "<input type=\"button\" value=\"Remove task\"\n" +
                        "onclick=\"removeTask(this,'" + document.getElementById("personField").value + "','" + document.getElementById("taskField").value + "' )\">"
                }
            }).fail(function (xhr, status, errThrowm) {
                $("#target").text("...ups....something went wrong");
            }).always(function (xhr, status) {
                $("#target").text("finished work");
                document.getElementById("personField").value = "";
                document.getElementById("taskField").value = "";
            })
        })
    }

    function removeTask(row, personPassed, taskPassed) {
        $(document).ready(function () {
            $.ajax({
                type: "POST",
                url: "/todolist/removeTask",
                data: {
                    person: personPassed,
                    task: taskPassed
                },
                success: function (result) {
                    if (result === "success") {
                        deleteRow(row, "list of tasks");
                    } else {
                        $("#target").html("error");
                    }
                }
            });
        })
    }

    function deleteRow(row, table) {
        var i;
        i = row.parentNode.parentNode.rowIndex;
        document.getElementById(table).deleteRow(i);
    }
</script>

</body>