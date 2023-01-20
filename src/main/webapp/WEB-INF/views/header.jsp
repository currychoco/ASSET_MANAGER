<%--
  Created by IntelliJ IDEA.
  User: currychoco
  Date: 2023-01-09
  Time: 오후 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    .dropdown-header {
        color: #337ab7;
    }
</style>

<header class="body-header">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/" style="padding: 0px 10px;">
                    <img src="/favicon.png" width="50" height="50" />
                </a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/manager/asset/list">자산 리스트</a></li>
                <li><a href="/manager/asset/create">자산 추가</a></li>
                <li><a href="/manager/category/create">카테고리 생성</a></li>
            </ul>
        </div>
    </nav>

</header>

