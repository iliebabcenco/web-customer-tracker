<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
    <title>Add New Customer</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>

        <div id="container">
            <h3>Save Customer</h3>
            <form:form action="/customers/add" method="post" modelAttribute="customer">

                <form:hidden path="id"/>

                <table>
                    <tbody>
                        <tr>
                            <td>
                                <label>First name:</label>
                            </td>
                            <td>
                                <form:input path="firstName" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Last name:</label>
                            </td>
                            <td>
                                <form:input path="lastName" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Email</label>
                            </td>
                            <td>
                                <form:input path="email" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label></label>
                            </td>
                            <td>
                                <input type="submit" value="Save" class="save"/>
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form:form>

            <div style="clear: both">

            </div>

            <p>
                <a href="${pageContext.request.contextPath}/customers/list"> Back to List</a>
            </p>
        </div>

    </div>

</body>
</html>
