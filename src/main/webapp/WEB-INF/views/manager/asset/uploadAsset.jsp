<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <c:import url="/WEB-INF/views/layout/head.jsp"/>
  <script type="text/javascript">

    $(document).ready(function() {
      let msg = "${resMap.msg}";
      if(msg != "") alert(msg);
    });

    function _onSubmit(){

      if($("#file").val() == ""){
        alert("파일을 업로드해주세요.");
        $("#file").focus();
        return false;
      }
      return true;
    }

  </script>
</head>
<body>
<c:import url="/WEB-INF/views/header.jsp"/>

<div class="container body-container">
  <h3 class="title">자산 추가(파일업로드)</h3>
  <form name="inputForm" method="post" onsubmit="return _onSubmit();" action="/asset/upload" enctype="multipart/form-data" class="form-horizontal">
      <table id="datatable-scroller" class="table table-bordered tbl_Form">
        <tbody>
        <tr>
          <th class="active" style="text-align:center"><label class="control-label">파일 업로드</label></th>
          <td>
            <input type="file" name="file" id="file" accept=".xlsx, .xls"/>
          </td>
        </tr>
        </tbody>
      </table>

    <div class="pull-right">
      <a href="/files/asset_upload_sample.xls" download><button type="button" class="btn btn btn-lg">업로드 샘플 다운로드</button></a>
      <input type="submit" value="엑셀파일 업로드" class="btn btn btn-primary btn-lg" />
    </div>
  </form>
</div>

<c:import url="/WEB-INF/views/footer.jsp"/>
</body>
</html>
