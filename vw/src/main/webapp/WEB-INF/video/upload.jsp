<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh_CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>视频上传</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/plugin/bootstrap/css/bootstrap3.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/myupload.css">
</head>

<body>
<header class="navbar navbar-static-top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/vw/index" title="视频网站">
                <img src="<%=request.getContextPath()%>/assets/img/yklogo.png" alt="优酷">
            </a>
        </div>
        <nav class="collapse navbar-collapse" role="navigation">
            <form class="navbar-form navbar-left" role="search" method="GET" action="">
                <div class="form-group">
                    <input type="text" id="" name="" class="form-control" placeholder="I didn't do the search">
                    <button type="sumbit" class=""><em>Search</em>
                    </button>
                </div>
            </form>
            <ul class="nav navbar-nav">
                <li class="nav-upload">
                    <a href="">upload</a>
                    <ul class="dropdown-menu">
                        <li><a href="">uploadVideo</a>
                        </li>
                    </ul>
                </li>
                <li><a class="login" href="javascript:void(0);">login</a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<div class="mainCol">
    <div class="uploadHot">
        <div class="uploadIcon"></div>
        <div class="uploadBtn"></div>
        <input id="fileupload" type="file" name="files[]" data-url="/vw/video/uploadVideo">
    </div>
</div>

<div class="container upload">
    <div class="row">
        <div class="top navbar-inverse"><span>上传视频</span>
        </div>
        <h4 id="filename"></h4>

        <div class="progress navbar-left">
            <div id="progress" class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100">
            </div>
        </div>
        <span id="percent">百分比</span>
        <button id='cancel' class="cancel navbar-right "><span>取消上传</span>
        </button>
        <div class="show navbar-left">
            <span>上传速度：<span id="speed"></span></span>
            <span class="showtitle">已上传：<span id="loaded"></span></span>
            <span class="showtitle">剩余时间：<span id="time"></span></span>
        </div>
    </div>
    <!-- Form表单部分 -->
    <div class="row uploadform">
        <form class="form-horizontal" role="form" action="/vw/video/videoInfo" method="POST">
            <div class="pull-left">
                <h4><label for="" class="control-label">视频信息</label></h4>

                <div class="form-group">
                    <label for=""  class="col-sm-2 control-label">标题:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="videoTitle" name="videoTitle">
                    </div>
                </div>

                <div class="form-group">
                    <label for="" class="col-sm-2 control-label">简介:</label>
                    <div class="col-sm-10">
                        <textarea id="videoIntroduction" name="videoIntroduction" class="form-control" rows="3"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="" class="col-sm-2 control-label">分类:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="videoClassification" name="videoClassification">
                            <option value="电影">电影</option>
                            <option value="体育">体育</option>
                            <option value="游戏">游戏</option>
                            <option value="原创">原创</option>
                            <option value="纪录片">纪录片</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="" class="col-sm-2 control-label">标签:</label>
                    <div class="col-sm-10">
                        <input type="text" id="videoLabel" name="videoLabel" class="form-control" placeholder="" >
                    </div>
                </div>
            </div>

            <div class="pull-right">
                <div class="form-group">
                    <label for="" class="col-sm-2 control-label">版权:</label>
                    <div class="col-md-8">
                        <select class="form-control" id="videoCopyright" name="videoCopyright">
                            <option value="0">原创</option>
                            <option value="1">转载</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="" class="col-sm-2 control-label">隐私:</label>
                    <div class="col-md-8">
                        <select class="form-control" id="isPrivate" name="isPrivate">
                            <option value="0">公开</option>
                            <option value="1">隐私</option>
                        </select>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn-primary btn-lg">保存</button>
        </form>
    </div>
    <!-- Form表单部分 -->
</div>

<script src="<%=request.getContextPath()%>/assets/js/jquery-2.1.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/plugin/fileupload/vendor/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/plugin/fileupload/jquery.iframe-transport.js"></script>
<script src="<%=request.getContextPath()%>/assets/plugin/fileupload/jquery.fileupload.js"></script>
<script src="<%=request.getContextPath()%>/assets/plugin/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/myfunction.js"></script>
<script type="text/javascript">
    function show() {
        $('.upload').css('display', 'block');
        $('.mainCol').css('display', 'none');
    }
</script>
</body>
</html>