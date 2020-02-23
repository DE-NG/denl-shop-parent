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
        $(function () {
            autoFooterHeight();
            $('#xm').carousel({
                interval: '1500',//设置自动播放的间隔时间
                pause: null,//当鼠标悬停在图片上时是否暂停播放
                wrap: true //设置是否循环播放
            });
        });

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

    <%--轮播插件--%>
    <div style="background-color: #fafafa">
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="/static/images/banner1.png" alt="First slide">
                    <div class="carousel-caption"></div>
                </div>
                <div class="item">
                    <img src="/static/images/banner2.png" alt="Second slide">
                    <div class="carousel-caption"></div>
                </div>
                <div class="item">
                    <img src="/static/images/banner3.png" alt="Third slide">
                    <div class="carousel-caption"></div>
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

    <%--TODO:商品展示没有加分页功能，还有数据的回显功能--%>
    <!-- 中间展示的内容 start -->
    <%--<div class="container-fluid" style="background-color: #FFF8DC">--%>
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="page-header" style="margin-bottom: 0px;">
                            <h3 style="color: #2b2b2b">商品列表&nbsp;<a href="/front/product/selectAllProduct" style="font-size: 15px;">查看更多</a></h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <form class="form-inline hot-search"
                              action="${pageContext.request.contextPath}/front/product/searchAllProducts"
                              method="post">
                            <div class="form-group">
                                <label class="control-label">商品：</label>
                                <input type="text" class="form-control" placeholder="商品名称" name="name">
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label class="control-label">价格：</label>
                                <input type="text" class="form-control" placeholder="最低价格" name="minPrice"> --
                                <input type="text" class="form-control" placeholder="最高价格" name="maxPrice">
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <label class="control-label">种类：</label>
                                <select class="form-control input-sm" name="productTypeId">
                                    <option value="-1" selected="selected">查询全部</option>
                                    <c:forEach items="${productTypes}" var="productType">
                                        <option value="${productType.id}">${productType.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            &nbsp;
                            <div class="form-group">
                                <button type="submit" class="btn btn-info">
                                    <i class="glyphicon glyphicon-search"></i> 查询
                                </button>
                            </div>
                        </form>
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
<%--        <ul>--%>
<%--            <li><a href="/front/product/searchAllProducts?pageNum=1">首页</a></li>--%>
<%--            <li><a href="/front/product/searchAllProducts?pageNum=${pageInfo.prePage}">上一页</a></li>--%>
<%--            <li><a href="/front/product/searchAllProductst?pageNum=${pageInfo.nextPage}">下一页</a></li>--%>
<%--            <li><a href="/front/product/searchAllProducts?pageNum=${pageInfo.pages}">尾页</a></li>--%>
<%--            <c:forEach items="${list.navigatepageNums}" var="p">--%>
<%--                <li><a href="/front/product/searchAllProducts?pageNum=${p}">${p}</a></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
    </div>
    <!-- 中间展示的内容 end-->

    <!-- footers start -->
    <footer id="footer" class="footers navbar-fixed-bottom">
        <div class="container-fluid footers">
            Copy Right @ 2019 BY DENL
        </div>
    </footer>
    <!-- footers end -->
</div>
<script>
    $('#myCarousel').carousel({interval:2000});
</script>
</body>

</html>
