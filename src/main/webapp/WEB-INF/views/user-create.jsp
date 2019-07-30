<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/css/error.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <style type="text/css">
        /*.text-left{*/
        /*    display: block;*/
        /*    position: relative;*/
        /*    font-size: large;*/

        /*    left: 30px;*/
        /*    font-weight: bold;*/
        /*    color: black;*/
        /*}*/
        /*.col-md-9{*/

        /*    position: relative;*/
        /*    left: 80px;*/

        /*}*/
    </style>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2> User</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add User</div>
            </div>
            <div class="panel-body">
                <form:form action="create" cssClass="form-horizontal"
                           method="post" modelAttribute="creationRequest">

                <table>
                    <tr>

                        <div class="form-group">
                            <td width="100">
                                <div class="text-left">
                                        <spring:message code="label.firstName" text="firstName"/>
                                    <div/>
                            </td>
                            <td width="400">
                                <div class="col-md-9">
                                    <form:input path="firstName" cssClass="form-control"/>
                                </div>
                            </td>
                            <td>
                                <div class="has-error">
                                    <form:errors path="firstName" class="help-inline"/>
                                </div>
                            </td>
                        </div>

                    </tr>

                    <tr>

                        <div class="form-group">
                            <td width="100">
                                <div class="text-left">

                                    <spring:message code="label.lastName" text="lastName"/>
                                </div>
                            </td>
                            <td width="400">
                                <div class="col-md-9">
                                    <form:input path="lastName" cssClass="form-control"/>
                                </div>
                            </td>
                            <td>
                                <div class="has-error">
                                    <form:errors path="lastName" class="help-inline"/>
                                </div>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form-group">
                            <td width="100">
                                <div class="text-left">

                                    <spring:message code="label.email" text="Email"/>
                                </div>
                            </td>
                            <td width="400">
                                <div class="col-md-9">
                                    <form:input path="email" cssClass="form-control"/>
                                </div>
                            </td>
                            <td>
                                <div class="has-error">
                                    <form:errors path="email" class="help-inline"/>
                                    <c:if test="${not empty message}">
                                        <div class="message">${message}</div>
                                    </c:if>
                                </div>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form-group">
                            <td>
                                <!-- Button -->
                                <div class="col-md-offset-3 col-md-9">
                                    <form:button cssClass="btn btn-primary">Submit</form:button>
                                </div>
                            </td>
                        </div>
                    </tr>



            </table>
            </form:form>
        </div>
        </div>
    </div>
</div>
</div>
</body>
</html>