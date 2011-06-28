<%-- 
    Document   : test
    Created on : Jun 28, 2011, 6:05:35 PM
    Author     : NIIT
--%>

<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Product p = (Product)session.getAttribute("test");
        %>
        <p>Product name: <%=p.getProductName()%></p>
        <p>Description: <%=p.getDescription()%></p>
        <p>Category: <%=p.getCategory()%></p>
    </body>
</html>
