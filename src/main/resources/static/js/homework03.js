window.onload = function() {
    //var $=jQuery.noConflict();

    $1 = function(obj) {
        return document.getElementById(obj);
    }

    // 字符串形式数据返回
    $1("btn").onclick = function() {
        var user_id = document.getElementById("user_id").value;
        var user_password = document.getElementById("user_password").value;
        var data = {"userId": 0, "userName": user_id, "passWord": user_password}
            //"{\"userId\":\""+0+"\",\"userName\":\""+user_id+"\",\"passWord\":\""+user_password+"\"}";
        sendMes(data);

    }
    function sendMes(data) {
        $($1("show")).text("正在提交......");
        var params = JSON.stringify(data);
        setTimeout(function () {
            $.ajax({
                url: "http://localhost:8088/homework04/client/login",
                type: "POST",
                data: params,
                contentType: "application/json",
                dataType: "json",
                success: function (data) {

                    $($1("show")).text(data.msg);
                },
                error: function (data) {
                    $($1("show")).text("未知异常");
                }
            });
        }, 3000);
    }

}

