<%--
    Document   : user
    Created on : Aug 30, 2021, 12:19:31 PM
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
        ${requestScope.user.fullName}
    </body>
</html>

