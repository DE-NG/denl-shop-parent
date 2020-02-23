<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>DENL商城-后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrapValidator.min.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/userSetting.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrapValidator.min.js"></script>

    <style type="text/css">
        .welcome {
            width: auto;
        }
        .myLi{
            cursor: pointer;
        }

    </style>

    <script type="text/javascript">
        $(function () {
            // 点击切换页面
            $("#product-type-set").click(function () {
                $("#frame-id").attr("src", "${pageContext.request.contextPath}/back/product_type/find_all");
            });
            $("#product-set").click(function () {
                $("#frame-id").attr("src", "${pageContext.request.contextPath}/back/product/findAllProduct");
            });
            $("#user-set").click(function () {
                $("#frame-id").attr("src", "${pageContext.request.contextPath}/back/customer/getAllCustomers");
            });
            // autoFooterHeight();
        });

        //TODO: 设置固定在底部的 footer 可以自适应高度
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

        //系统用户退出登录
        function systemUserLogout() {
            $.post(
                '${pageContext.request.contextPath}/back/sysuser/logout',
                function (result) {
                    if (result.code == "200") {
                        //跳到登录页面
                        location.href = '${pageContext.request.contextPath}/back/sysuser/login';
                    }
                }
            );
        }

    </script>
</head>

<body>
<div class="wrapper-cc clearfix">
    <div class="content-cc">
        <!-- header start -->
        <div class="clear-bottom head">
            <div class="container head-cc">
                <p>DENL商城<span>后台管理系统</span></p>
                <div class="welcome">
                    <div class="left">欢迎您：<span>${sessionScope.get("systemUser").loginName}</span></div>
                    <%--<div class="right">xxx</div>--%>
                    <button type="button" style="background: #0f0f0f; border-style: none" onclick="systemUserLogout()">
                        退出
                    </button>
                </div>
            </div>
        </div>
        <!-- header end -->

        <!-- content start -->
        <div class="container-flude flude-cc" id="a">
            <div class="row user-setting">
                <div class="col-xs-2 user-wrap">
                    <ul class="list-group">
                        <li class="list-group-item active myLi" name="userSet" id="product-type-set">
                            <i class="glyphicon glyphicon-bookmark"></i> &nbsp;商品类型管理
                        </li>
                        <li class="list-group-item myLi" name="userPic" id="product-set">
                            <i class="glyphicon glyphicon-shopping-cart"></i> &nbsp;商品管理
                        </li>
                        <c:if test="${sessionScope.get('systemUser').role.id == 3}">
                            <li class="list-group-item myLi" name="userInfo" id="user-set">
                                <i class="glyphicon glyphicon-user"></i> &nbsp;客户管理
                            </li>
                        </c:if>
                    </ul>
                </div>
                <div class="col-xs-10" id="userPanel">
                    <iframe id="frame-id" src="${pageContext.request.contextPath}/back/product_type/find_all"
                            width="100%" height="100%" frameborder="0" scrolling="no">
                    </iframe>
                </div>
            </div>
        </div>
        <!-- content end-->

    </div>
</div>

<!-- footers start -->
<footer id="footer" class="footer navbar-fixed-bottom">
    <div class="container-fluid footers">
        Copy Right @ 2019 BY DENL
    </div>
</footer>
<!-- footers end -->
</body>

</html>
