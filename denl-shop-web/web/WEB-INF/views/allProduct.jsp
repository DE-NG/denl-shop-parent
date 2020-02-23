<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<%--    <meta charset="UTF-8"/>--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>--%>
    <title>Apple</title>
        <link rel="shortcut icon" type="image/x-icon" href="/static/images/apple.ico"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/iconfont/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xmstyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/animate.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/zshop.js"></script>

    <%--我的自定义样式--%>
    <style type="text/css">
        #xm {
            width: auto;
            height: auto;
        }
    </style>

    <script>

        //TODO: 设置固定在底部的footer 可以自适应高度
        function autoFooterHeight() {
            // 获取内容的高度
            var bodyHeight = $("body").height();
            // 获取底部导航的高度
            var navHeight = $(".footer").height();
            // 获取显示屏的高度
            var iHeight = document.documentElement.clientHeight || document.body.clientHeight;
            // 如果内容的高度大于（窗口的高度 - 导航的高度）,移除属性样式
            if (bodyHeight > (iHeight - navHeight)) {
                $("#footer").removeClass("navbar-fixed-bottom");
            }
        }

        //展示商品详情
        function showProductDetail(id) {
            location.href = '${pageContext.request.contextPath}/front/product/showProductDetail?id=' + id;
        }
    </script>
</head>

<body class="animated fadeIn">
<div id="wrapper" style="margin-top: 50px">
    <!-- 导航栏 start -->
    <jsp:include page="top.jsp">
        <jsp:param name="num" value="1"/>
    </jsp:include>
    <!-- 导航栏 end -->

        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="page-header" style="margin-bottom: 0px;">
                            <h3 style="color: #2b2b2b">商品列表</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="content-back">
        <div class="container" id="a">
            <div class="row">
                <c:forEach items="${pageInfo.list}" var="product">
                    <div class="col-xs-3  hot-item" id="showDetail" onclick="showProductDetail(${product.id})"
                         style="cursor: pointer;">
                        <div class="panel clear-panel">
                            <div class="panel-body">
                                <div class="art-back clear-back">
                                    <div class="add-padding-bottom">
                                        <img src="${product.image}" class="shopImg">
                                    </div>
                                    <h4 class="myH4"><a href="#">${product.name}</a></h4>
                                    <div class="user clearfix pull-right"><span>¥ </span>${product.price}</div>
                                    <div>
                                        <a class="my" href="#">${product.info}</a>
                                    </div>
                                        <%--<div class="attention pull-right">--%>
                                        <%--<i class="icon iconfont icon-gouwuche"></i>--%>
                                        <%--</div>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div align="center">
        <ul class="pagination">
            <li><a href="/front/product/selectAllProduct?pageNum=${pageInfo.prePage}">&laquo;</a></li>
            <c:forEach items="${pageInfo.navigatepageNums}" var="p">
            <li><a href="/front/product/selectAllProduct?pageNum=${p}">${p}</a></li>
            </c:forEach>
            <li><a href="/front/product/selectAllProduct?pageNum=${pageInfo.nextPage}">&raquo;</a></li>

        </ul>
        </div>
    </div>
    <!-- 中间展示的内容 end-->


</div>
<script>
    $('#myCarousel').carousel({interval:2000});
</script>
</body>

</html>
