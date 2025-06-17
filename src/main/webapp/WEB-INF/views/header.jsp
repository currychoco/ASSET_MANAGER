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
                <li><a href="/">내 정보</a></li>
                <li><a href="/request">자산 구매 요청</a></li>
                <li class="dropdown">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                        관리자 페이지<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">자산 카테고리</li>
                        <li><a href="/manager/category/list">카테고리 리스트</a></li>
                        <li><a href="/manager/category/create">카테고리 생성</a></li>
                        <li class="dropdown-header">자산</li>
                        <li><a href="/manager/asset/list">자산 리스트</a></li>
                        <li><a href="/manager/asset/create">자산 추가(입력)</a></li>
                        <li><a href="/manager/asset/upload">자산 추가(파일업로드)</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${sessionScope.id == null}">
                        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <p style="margin-top:13px;">Hello, <b>${sessionScope.id}</b></p>
                        </li>
                        <li><a href="javascript:logout()"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </nav>

</header>

