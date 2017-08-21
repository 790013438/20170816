<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="static/css/index.css" charset="utf-8">
        <title>Login</title>
    </head>
    <c:set var="errMsg" value="${null}"/>
    <c:set var="displayForm" value="${true}"/>
    <c:if test="${\"POST\".equalsIgnoreCase(pageContext.request.method) && pageContext.request.getParameter(\"submit\") != null}">
        <jsp:useBean id="loginBean" class="snippets.bean.LoginBean">
            <jsp:setProperty name="loginBean" property="*"/>
        </jsp:useBean>
        <c:choose>
            <c:when test="${!loginBean.isValidUser()}">
                <c:set var="errMsg" value="Invalid user id or password. Please try again"/>
            </c:when>
            <c:otherwise>
                <h2><c:out value="Welcome admin !"/></h2>
                <c:out value="You are successfully logged in"/>
                <c:set var="displayForm" value="${false}"/>
            </c:otherwise>
        </c:choose>
    </c:if>
    <c:if test="${displayForm}">
        <body>
            <h2>Login:</h2>
            <!-- Check error message. If it is set, then display it -->
            <c:if test="${errMsg != null}">
                <span style="color: red;">
                    <c:out value="${errMsg}"/>
                </span>
            </c:if>
            <form method="post">
                <div class="a-row">
                    User Name: <input class="a-input-text a-span12" type="text" name="userName"/>
                </div>
                <div>
                    Password: <input class="a-input-text a-span12" type="password" name="password"/>
                </div>
                <button type="submit" name="submit">Submit</button>
                <button type="reset">Reset</button>
            </form>
        </body>
    </c:if>
</html>
