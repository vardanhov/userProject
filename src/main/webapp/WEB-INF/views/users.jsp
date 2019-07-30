<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List User</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>

<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <hr/>
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>
        <input type="button" value="Add User" onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary"/>
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">User List</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    <c:choose>
                        <c:when test="${not empty users}">
                            <c:forEach var="user" items="${users}">
                                <c:url var="updateLink" value="/user/updateForm">
                                    <c:param name="id" value="${user.id}"/>
                                </c:url>
                                <c:url var="deleteLink" value="/user/delete">
                                    <c:param name="id" value="${user.id}"/>
                                </c:url>
                                <tr>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>
                                    <td>
                                        <a href="${updateLink}">Update</a>
                                        | <a href="${deleteLink}"
                                             onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>No User Found</c:otherwise>
                    </c:choose>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>