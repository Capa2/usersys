<%--
    Document   : index
    Created on : Aug 28, 2021, 12:30:00 AM
    Author     : johan
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Index</title>
    </head>
    <body>
        <h1>Hello</h1>
        <form action="userpage" method="post">
            <c:forEach var="user" items="${requestScope.userList}" varStatus="status">
                ${status.count}) <button type="submit" name="user" value="${user}">${user.fullName}</button>
            </c:forEach>
        </form>
    </body>
</html>
