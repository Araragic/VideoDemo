<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!DOCTYPE HTML >
<head>
    <title>PlayPage</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/plugin/bootstrap/css/bootstrap3.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/plugin/play/css/flat-ui.css" >
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
                <li><a class="login" href="javascript:void(0)">login</a>
                </li>
            </ul>
        </nav>
    </div>
</header>

<div class="container" style="margin:20px auto;width:1000px;">
    <div class="span8 demo-video">
        <video class="video-js" controls
               preload="auto" width="1000" height="500" poster="<%=request.getContextPath()%>/video/cover/${videoName}.jpg" data-setup="{}">
            <source src="<%=request.getContextPath()%>/video/file/${videoName}.mp4" type='video/mp4'/>
        </video>
    </div>
</div>
<br/><br/><br/>

<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/jquery-2.1.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/plugin/play/js/video.js"></script>
</body>
</html>
