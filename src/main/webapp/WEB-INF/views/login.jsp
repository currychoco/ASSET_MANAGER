<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: currychoco
  Date: 2022-11-15
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>
    <script src="/js/login.js"></script>
</head>
<body>
    <c:import url="/WEB-INF/views/header.jsp"/>
    <div class="container body-container">
        <div class="text-center" style="height:500px;">
            <img src="/favicon.png">
        </div>
        <form>
            <div class="form-group">
                <input type="text" class="form-control" id="id" name="id" placeholder="아이디" required/>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="패스워드" required/>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary btn-block" onclick="login()">로그인</button>
            </div>
        </form>
    </div>
    <c:import url="/WEB-INF/views/footer.jsp"/>
</body>
</html>
