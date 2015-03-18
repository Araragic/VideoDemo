$(function () {
    /** 弹出登录页面*/
    $('.login').click(function () {
        $('.login').attr('data-toggle', 'modal');
        $('.login').attr('data-target', '#loginModal');
    });

    /** 初始化上传控件*/
    $('#fileupload').fileupload({
        dataType: 'json',
        add: function (e, data) {
            //限制上传文件的大小，以及显示上传文件的名字
            $.each(data.files, function (index, file) {
                var name = file.name.substr(file.name.lastIndexOf(".") + 1).toLowerCase();
                //alert(name);
                if (!(file.size < 500000000 && name =="mp4")) {//only for mp4
                    alert("文件大小超过限制或者不是FLV，MP4格式");
                    jqXHR.abort();
                } else {
                    $('.upload').css('display', 'block');
                    $('.mainCol').css('display', 'none');
                    $('#filename').text(file.name);
                    $('#videoTitle').val(file.name);
                }
            });
            //点击按钮停止上传
            var jqXHR = data.submit()
                .error(function (jqXHR, textStatus, errorThrown) {
                    if (errorThrown === 'abort') {
                        //alert('文件大小超过限制或者不是FLV，MP4格式');
                    }
                });
            $('#cancel').click(function (e) {
                jqXHR.abort();
                alert("你终止了上传");
                $('.upload').css('display', 'none');
                $('.mainCol').css('display', 'block');
            });
        },

        done: function (e, data) {

        },

        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('.progress-bar').css({
                'width': progress + '%'
            });
            $('#percent').text(progress + '%');
            $('#speed').text(bytesToSize(data.bitrate / 8) + '/S');
            $('#loaded').text(bytesToSize(data.loaded) + '/' + bytesToSize(data.total));
            $('#time').text(
                formatSeconds((data.total - data.loaded) * (8 / data.bitrate))
            );
        }
    })
});

/** ajax登录*/
function login(){
    $.ajax({
        type: "POST",
        url : "/vw/user/login",
        dataType: "json",
        data:$('#loginForm').serialize(),//这个方法配合spring可以直接给controller中的参数bean赋值
        complete : function(data){
            var result = eval("(" + data.responseText + ")");
            if(result){
                $('.login').css('display','none');
                $('.showUser').css('display','block');
                $('.close').click();
                alert("成功");
            }else{
                alert("失败");
            }
        }
    })
}

function bytesToSize(bytes) {
    if (bytes === 0) return '0 B';
    var k = 1000,
        sizes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
        i = Math.floor(Math.log(bytes) / Math.log(k));
    return (bytes / Math.pow(k, i)).toPrecision(3) + ' ' + sizes[i];
}

function formatSeconds(value) {
    var theTime = parseInt(value); // 秒
    var theTime1 = 0; // 分
    var theTime2 = 0; // 小时
    if (theTime > 60) {
        theTime1 = parseInt(theTime / 60);
        theTime = parseInt(theTime % 60);
        if (theTime1 > 60) {
            theTime2 = parseInt(theTime1 / 60);
            theTime1 = parseInt(theTime1 % 60);
        }
    }
    var result = "" + parseInt(theTime) + "秒";
    if (theTime1 > 0) {
        result = "" + parseInt(theTime1) + "分" + result;
    }
    if (theTime2 > 0) {
        result = "" + parseInt(theTime2) + "小时" + result;
    }
    return result;
}