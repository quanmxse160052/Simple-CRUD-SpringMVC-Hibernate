<%-- 
    Document   : updateForm
    Created on : Aug 26, 2022, 10:36:55 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Update Customer</h1>
        <c:set var="customer" value="${requestScope.CUSTOMER}"/>
        <form action="updateCustomer" method="POST">
            First name: <input type="text" name="txtFirstName" value="${customer.firstName}" />
            Last name: <input type="text" name="txtLastName" value="${customer.lastName}" />
            Email: <input type="text" name="txtEmail" value="${customer.email}" />
            <input type="hidden" name="id" value="${customer.id}" />
            <input type="submit" value="Update" />
        </form>
    </body>
</html>
