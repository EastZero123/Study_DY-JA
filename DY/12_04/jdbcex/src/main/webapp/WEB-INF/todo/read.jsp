<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-12-04
  Time: 오후 3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<div>
    <input type="text" name="true" value="${dto.tno}" readonly>
</div>
<div>
    <input type="text" name="title" value="${dto.title}" readonly>
</div>
<div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
</div>
<div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked": ""} readonly>
</div>
<div>
    <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
    <a gref="/todo/list">List</a>
</div>
</body>
</html>
