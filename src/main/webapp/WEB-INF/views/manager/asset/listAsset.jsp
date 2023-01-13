<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>

    <script>

    </script>
</head>
<body>
<c:import url="/WEB-INF/views/header.jsp"/>

<div>
    <form class="container body-container" id="addForm">
        <h3 class="title">자산 리스트</h3>
        <div class="form-group">
            <input type="text" class="form-control" id="serialnumber" name="serialnumber" placeholder="시리얼넘버" required>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="model" name="model" placeholder="모델명" required>
        </div>
        <div class="form-group">
            <table class="table table-hover">
                <colgroup>
                    <col style="width:10%" />
                    <col style="width:20%" />
                    <col style="width:10%" />
                    <col style="width:40%" />
                    <col style="width:20%" />
                </colgroup>
                <thead>
                <tr>
                    <th>고유번호</th>
                    <th>시리얼번호</th>
                    <th>자산 상태</th>
                    <th>등록일</th>
                    <th>모델</th>
                    <th>카테고리</th>
                </tr>
                </thead>
                <tbody id="assetList">
                </tbody>
            </table>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-lg btn-primary btn-block">자산 추가</button>
        </div>
    </form>
</div>

<c:import url="/WEB-INF/views/footer.jsp"/>
</body>
</html>
