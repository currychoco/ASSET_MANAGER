<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <c:import url="/WEB-INF/views/layout/head.jsp"/>

  <script>
    function createAsset(){
      const serialnumber = $("#serialnumber").val();
      const model = $("#model").val();
      const categoryCode = $("#categoryCode").val();

      if(!serialnumber || !model || !categoryCode){
        alert("누락된 내용이 있습니다.");
        return;
      }

      $.ajax({
        url : "/asset",
        type : "POST",
        contentType : "application/json",
        data : JSON.stringify({
          serialnumber : serialnumber,
          model : model,
          categoryCode : categoryCode
        })
      }).done(function(response){
        alert("자산 추가 성공")
        location.reload();
      }).fail(function(err){
        console.log(err);
        //err.responseJSON && alert(err.responseJSON.message);
      });
    }

    $(document).ready(function() {
      $("#addForm").submit(function(e) {
        e.preventDefault();
        createAsset();
      });
    });
  </script>
</head>
<body>
<c:import url="/WEB-INF/views/header.jsp"/>

<div class="container body-container">
  <h3 class="title">자산 지급 요청</h3>
  <form id="addForm">
    <div class="form-group">
      <select class="form-control" id="categoryCode" name="categoryCode" required>
          <option>카테고리</option>
        <c:forEach var="category" items="${category}">
          <option value="${category.categoryCode}">${category.categoryName}</option>
        </c:forEach>
      </select>
    </div>
    <div class="form-group">
        <select class="form-control" id="model" name="model" required>
          <option>모델 선택</option>
          <option>Macbook Pro 14"</option>
      </select>
    </div>
    <div class="form-group">
      <input type="text" class="form-control" id="reason" name="reason" placeholder="지급 요청 사유" required>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-lg btn-primary btn-block">요청</button>
    </div>
  </form>
</div>

<c:import url="/WEB-INF/views/footer.jsp"/>
</body>
</html>
