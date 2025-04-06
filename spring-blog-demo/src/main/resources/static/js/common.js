$(document).ajaxSend(function(event,xhr,options){
    xhr.setRequestHeader("user_token",localStorage.getItem("userToken"));
});
$(document).ajaxError(function(event,xhr,options,exc){
    if(xhr.status==401){
        location.href="blog_login.html";
    }
});

function getUserInfo(url){
    $.ajax({
        type:"get",
        url:url,
        success:function(result){
            if(result!=null&&result.code=="SUCCESS"&&result.data!=null){
                var userInfo=result.data;
                $(".left .card h3").text(userInfo.userName);
                $(".left .card a").attr("href",userInfo.githubUrl);
            }
        }
    })
}

function logout(){
    localStorage.removeItem("loginUserId");
    localStorage.removeItem("userToken");
    location.href="blog_login.html";
}