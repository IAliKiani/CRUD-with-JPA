<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 9/15/2026
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/person/save.do" method="post">
    <input type="text" name="name" placeholder="NAME" class="text text-input">
    <input type="text" name="family" placeholder="FAMILY" class="text text-area">
    <input type="text" name="age" placeholder="AGE" class="form-control-feedback">
    <input type="text" name="nationalCode" placeholder="NATIONAL CODE" class="form-control-static" >
    <input type="submit" value="SAVE" class="btn btn-success">
</form>
    <table class="table table-bordered table-responsive table-hover table-striped" style="width:100%">

        <tr>
            <td>ID</td>
            <td>NATIONAL CODE</td>
            <td>NAME</td>
            <td>FAMILY</td>
            <td>AGE</td>
            <td>OPERATION1</td>
            <td>OPERATION2</td>
        </tr>

        <c:forEach items="${requestScope.persons}" var="person">
            <tr>
                <form action="/person/update.do" method="post">
                    <td><input type="text" name="id" value="${person.id}" class="form-control-static" readonly></td>
                    <td><input type="text" name="nationalCode" value="${person.nationalCode}" class="form-control-static" readonly></td>
                    <td><input type="text" name="name" value="${person.name}" class="form-control"></td>
                    <td><input type="text" name="family" value="${person.family}" class="form-control"></td>
                    <td><input type="text" name="age" value="${person.age}" class="form-control"></td>
                    <td><input type="submit"  value="UPDATE" class="btn btn-link"></td>
                    <td><input type="button" value="REMOVE" class="btn btn-danger" onclick="removePerson(${person.id},${person.version})"></td>
                    <td><input type="hidden" name="version" value="${person.version}"></td>
                </form>
            </tr>
        </c:forEach>

    </table>


    <script>
        function removePerson(id,version) {
            if (confirm('Are you sure?')){
                window.location = '/person/remove.do?id='+ id+'&version='+version;
            }
        }
    </script>
</body>
</html>
