function login(){
    const id = $("#id").val();
    const password = $("#password").val();

    $.ajax({
        type : "POST",
        url : "/account/login",
        data : {
            id : id,
            password : password
        }
    }).done(function(response){
        if(response){
            alert("로그인 성공");
            location.href="/";
        }else{
            alert("로그인 실패");
        }
    }).fail(function (err){
        console.log(err)
    });
}

$(document).ready(function() {

    /*
    document.getElementById("password").addEventListener("keyup", function() {

    });

    $("#password").on("keyup", function (key) {

    });
    */

    $("#password").keyup(function(key) {
        if(key.keyCode === 13) {
            login();
        }
    });
});