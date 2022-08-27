<%-- 
    Document   : list-customer
    Created on : Aug 26, 2022, 8:38:30 AM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
    </head>
    <body>
        <h1>Customers</h1>
        <a href="showFormForAdd">Add New Customer</a>
        <c:set var="customers" value="${requestScope.CUSTOMERS}"/>
        <c:if test="${not empty customers}">
            <table border="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customers}" var="customer"  >
                        <c:url var="updateLink" value="updateForm">
                            <c:param name="id" value="${customer.id}"/>
                        </c:url>
                         <c:url var="deleteLink" value="deleteCustomer">
                            <c:param name="id" value="${customer.id}"/>
                        </c:url>
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.email}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}">Delete</a>
                            </td>

                        </tr>    
                    </c:forEach>

                </tbody>
            </table>

        </c:if>
        <c:if test="${empty customers}">
            <h1>Do not have any customer</h1>
        </c:if>
    </body>
</html>
