<%-- 
    Document   : AddCustomerForm
    Created on : Aug 26, 2022, 9:34:09 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer</title>
    </head>
    <body>
        <h1>Add Customer</h1>
        <form action="addNewCustomer" method="POST">
            First name: <input type="text" name="txtFirstName" value="" />
            Last name: <input type="text" name="txtLastName" value="" />
            Email: <input type="text" name="txtEmail" value="" />
            <input type="submit" value="Add" />
        </form>
    </body>
</html>
