<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html lang="zh_CN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>视频首页</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/plugin/bootstrap/css/bootstrap3.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/myupload.css">
</head>

<body>
    <header class="navbar navbar-static-top" role="banner">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/vw/index" title="VideoWebsite">
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
                        <a href="javascript:void(0);">upload</a>
                        <ul class="dropdown-menu">
                            <li><a href="/vw/video/show">uploadVideo</a>
                            </li>
                        </ul>
                    </li>
                    <li><a class="login" href="javascript:void(0)">Login</a>
                    <li><a class="showUser" id="user" href="" style="display: none;">${userName}</a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="container">
        <div class="page-content">
            <div class="arrow"></div>
            <div class="row">
                <c:forEach var="videoList" items="${videoList}">
                <div class="item pull-left">
                    <a href="/vw/video/play?videoName=${videoList.videoTitle}">
                        <img src="<%=request.getContextPath()%>/video/cover/${videoList.videoTitle}.jpg" width="100%" height="100%">
                    </a>
                    <div class="itemTitle">
                        <a href="/vw/video/play?videoName=${videoList.videoTitle}" arget="_blank" ata-toggle="tooltip" title="${videoList.videoTitle}">
                            <span class="title">${videoList.videoTitle}</span>
                        </a>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display:none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                       用户登录
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form" id="loginForm">
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input class="form-control" type="text" id="userName" name="userName" placeholder="请输入账号">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <input class="form-control" type="password" id="password" name="password" placeholder="请输入密码">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="login()">
                        登录
                    </button>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=request.getContextPath()%>/assets/js/jquery-2.1.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/plugin/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/myfunction.js"></script>
    <script type="text/javascript">
    </script>
</body>
</html>