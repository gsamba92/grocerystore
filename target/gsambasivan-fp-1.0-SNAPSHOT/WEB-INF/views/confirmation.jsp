<%-- 
    Document   : confirmation
    Created on : 2 Mar, 2017, 6:11:49 PM
    Author     : Swathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    <body>
        <h1>You have created a Product Category!  Congratulations!</h1>
       <h2>Your Product Category Details are : ${requestScope.ProductCategory.categoryName} ${requestScope.ProductCategory.description}</h2>
    </body>
</html>
