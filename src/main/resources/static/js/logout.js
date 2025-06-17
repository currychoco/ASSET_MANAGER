function logout(){
    $.ajax({
        type : "POST",
        url : "/account/logout"
    }).done(function(response){
        alert("로그아웃 완료");
        location.href = "/";
    }).fail(function(err){
        console.log(err);
    });
}