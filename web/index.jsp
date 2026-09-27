<%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 9/24/2026
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <a href="/person/findAll.do">persons</a>
 <form action="/person/save.do" method="post">
     <input type="text" name="name" placeholder="NAME" class="text text-input">
     <input type="text" name="family" placeholder="FAMILY" class="text text-area">
     <input type="text" name="nationalCode" placeholder="nationalCode" class="form-control form-control-static">
     <input type="text" name="age" placeholder="AGE" class="form-control-feedback">
     <input type="submit" value="SAVE" class="btn btn-success">
 </form>
</body>
</html>
