<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>

    <script>

        function getCategoryList(){
            $.ajax({
                url : "/category",
                type : "GET",
                contentType : "application/json",
            }).done(function (response){
                const list = response;
                let htmlText = "";
                if(response.length === 0){
                    htmlText = `<tr><td colspan="2" class="text-center">검색된 카테고리가 없습니다.</td></tr>`;
                }else{
                    list.forEach(e=>{
                        htmlText += `
                            <tr>
                                <td>\${e.categoryCode}</td>
                                <td>\${e.categoryName}</td>
                            </tr>
                        `
                    })
                }

                $('#categoryList').html(htmlText);

            }).fail(function(err){
                console.log("error : " + err);
            });
        }

        $(document).ready(function (){
            getCategoryList();
        });
    </script>
</head>
<body>
<c:import url="/WEB-INF/views/header.jsp"/>

<div class="container body-container">
    <form id="addForm">
        <h3 class="title">카테고리 리스트</h3>
        <div class="form-group">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>카테고리 코드</th>
                    <th>카테고리</th>
                </tr>
                </thead>
                <tbody id="categoryList">
                </tbody>
            </table>
        </div>
    </form>
</div>
<c:import url="/WEB-INF/views/footer.jsp"/>
</body>
</html>
