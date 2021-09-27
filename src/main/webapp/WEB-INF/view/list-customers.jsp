<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>List of customers</title>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add Customer"
               onclick="window.location.href='add'; return false;"
                class="add-button"
        />
        <form:form action="/customers/search" method="get">
            <input type="text" name="searchKeyword" />
            <input type="submit" value="Search" >
        </form:form>
        <hr>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="customer" items="${customers}">
                <c:url var="update" value="/customers/update">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>
                <c:url var="delete" value="/customers/delete">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a href="${update}">Update</a> | <a href="${delete}"
                    onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false;"
                    >Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
