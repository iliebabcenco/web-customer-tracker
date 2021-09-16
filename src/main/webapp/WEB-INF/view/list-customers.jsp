<%@ page import="com.luv2code.springdemo.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of customers</title>
</head>
<body>
    <h3>List Customers - coming soon ... </h3>
<% List<Customer> customers = (List<Customer>) request.getAttribute("customers"); %>
<% for (Customer c: customers) { %>
    <p><%= c.getFirstName()%> <%= c.getLastName()%></p>
<% } %>

</body>
</html>
