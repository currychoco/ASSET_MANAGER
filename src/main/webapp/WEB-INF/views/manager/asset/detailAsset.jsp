<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>

    <script>
        function deleteAsset(){
            if(!confirm("삭제하시겠습니까?")){
                return;
            }

            const id = ${asset.id};
            console.log(id);

            $.ajax({
                url : `/asset/\${id}`,
                type : "DELETE"
            }).done(function(response){
                alert("삭제되었습니다.");
                location.href="/manager/asset/list";
            }).fail(function(err){
                console.log(err);
            })
        }

        function updateAsset(){

            if(!confirm("수정하시겠습니까?")){
                return;
            }

            const id = '<c:out value = "${asset.id}"/>';
            const model = $("#model").val();
            const serialnumber = $("#serialnumber").val();
            const assetState = $("#assetState option:selected").val();
            const category = $("#category option:selected").val();

            if(!model || !serialnumber || !assetState || !category){
                alert("누락된 내용이 있습니다.");
                return;
            }

            $.ajax({
                url : `/asset/\${id}`, //jsp와 jstl을 함께 쓸 때 자바스크립트 변수를 문자열 안에 삽입하기 위한 방법
                type : "PUT",
                contentType : "application/json",
                data : JSON.stringify({
                    id : id,
                    serialnumber : serialnumber,
                    assetState : assetState,
                    model : model,
                    categoryCode : category
                })
            }).done(function (response){
                alert("수정되었습니다.");
            }).fail(function (err){
                console.log(err);
            });
        }

        $(document).ready(function() {
            $("#updateForm").submit(function(e) {
                updateAsset();
            });

            $("#deleteAsset").click(function (e){
               deleteAsset();
            });
        });

    </script>
</head>
<body>
<c:import url="/WEB-INF/views/header.jsp"/>

<div class="container body-container">
    <h3 class="title">자산 상세 페이지</h3>
    <form id="updateForm" onsubmit="return false">
        <div class="form-group">
            <input type="text" class="form-control" id="id" name="id" placeholder="사번" value="${asset.id}" readonly>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="model" name="model" placeholder="모델명" value="${asset.model}" required>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="serialnumber" name="serialnumber" placeholder="시리얼넘버" value="${asset.serialnumber}" required>
        </div>
        <div class="form-group">
            <select class="form-control" id="assetState" name="assetState">
                <c:forEach var="assetState" items="${assetState}">
                    <option value="${assetState.assetState}" ${assetState.assetState == asset.assetState ? 'selected' : ''}>${assetState.assetStateName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="regDate" name="regDate" placeholder="등록일" value="${asset.regDate}" readonly>
        </div>
        <div class="form-group">
            <select class="form-control" id="category" name="category">
                <c:forEach var="category" items="${category}">
                    <option value="${category.categoryCode}" ${category.categoryCode == asset.categoryCode ? 'selected' : ''}>${category.categoryName}</option>
                </c:forEach>
            </select>
        </div>

        <!-- 자산 대여 히스토리 출력 추가해주기-->

        <!-- 권한 추가시 권한 설정 해주기 -->
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">수정</button>
            <button type="button" class="btn btn-danger btn-block" id="deleteAsset">삭제</button>
        </div>

    </form>
</div>

<c:import url="/WEB-INF/views/footer.jsp"/>
</body>
</html>
