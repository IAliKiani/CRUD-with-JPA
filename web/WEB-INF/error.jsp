<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">Error</div>
        <div class="panel-body">
            ${requestScope.error}
        </div>
    </div>
</div>
</body>
</html>
