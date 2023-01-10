<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>

    <script>
        function createCategory(){
            const categoryCode = $("#categoryCode").val();
            const categoryName = $("#categoryName").val();

            if(!categoryCode || !categoryName){
                alert("누락된 내용이 있습니다.");
                return;
            }

            $.ajax({
                url : "/category",
                type : "POST",
                contentType : "application/json",
                data : JSON.stringify({
                    categoryCode : categoryCode,
                    categoryName : categoryName
                })
            }).done(function(response){
                alert("카테고리 생성 성공")
                location.reload();
            }).fail(function(err){
                console.log(err);
                //err.responseJSON && alert(err.responseJSON.message);
            });
        }

        $(document).ready(function() {
            $("#addForm").submit(function(e) {
                e.preventDefault();
                createCategory();
            });
        });
    </script>
</head>
<body>
<c:import url="/WEB-INF/views/header.jsp"/>

<div>
    <form class="container body-container" id="addForm">
        <h3 class="title">카테고리 추가</h3>
        <div class="form-group">
            <input type="text" class="form-control" id="categoryCode" name="categoryCode" placeholder="카테고리 코드" required>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="카테고리명" required>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-lg btn-primary btn-block">카테고리 생성</button>
        </div>
    </form>
</div>

<c:import url="/WEB-INF/views/footer.jsp"/>
</body>
</html>
