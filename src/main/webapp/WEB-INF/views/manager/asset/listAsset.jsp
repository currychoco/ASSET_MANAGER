<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:import url="/WEB-INF/views/layout/head.jsp"/>

    <script>

        function getAssetList(){
            $.ajax({
                url : "/asset",
                type : "GET",
                contentType : "application/json",
            }).done(function (response){
                const list = response;
                let htmlText = "";
                if(response.length === 0){
                    htmlText = `<tr><td colspan="5" class="text-center">검색된 자산이 없습니다.</td></tr>`;
                }else{
                    list.forEach(e=>{
                        htmlText += `
                            <tr>
                                <td><a href="/manager/asset/detail?id=\${e.id}">\${e.id}</a></td>
                                <td>\${e.categoryName}</td>
                                <td>\${e.model}</td>
                                <td>\${e.assetState}</td>
                                <td>\${e.regDate}</td>
                            </tr>
                        `
                    })
                }

                $('#assetList').html(htmlText);

            }).fail(function(err){
                console.log("error : " + err);
            });
        }


        $(document).ready(function (){
            getAssetList();
        });
    </script>
</head>
<body>
<c:import url="/WEB-INF/views/header.jsp"/>

<div class="container body-container">
    <form id="addForm">
        <h3 class="title">자산 리스트</h3>
        <div class="form-group">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>고유번호</th>
                    <th>카테고리</th>
                    <th>모델</th>
                    <th>자산 상태</th>
                    <th>등록일</th>
                </tr>
                </thead>
                <tbody id="assetList">
                </tbody>
            </table>
        </div>
    </form>
    <div>
        <button class="btn btn-primary" onclick="location.href='http://localhost:8081/asset/excel'">자산 리스트 다운로드</button>
    </div>
</div>

<c:import url="/WEB-INF/views/footer.jsp"/>
</body>
</html>
