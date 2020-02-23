<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>订单支付</title>
    <link rel="shortcut icon" type="image/x-icon" href="/static/images/apple.ico"
                              media="screen"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/animate.min.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
    <style>
        p {
            margin: 10px 0;
        }

        .mark {
            font-size: 16px;
            color: #808080;
            padding: .2em 0;
        }

        .des-label {
            width: 100px;
            text-align: right;
            font-size: 16px;
            font-weight: bolder;
            color: #808080;
            display: inline-block;
        }

        .list-group-item {
            border: 0;
        }
    </style>
    <script>
        $(function () {
            //显示服务端响应的消息
            var failMsg = '${failMsg}';
            if (failMsg != '') {
                layer.msg(failMsg, {
                    time: 1500,
                    skin: 'errorMsg'
                });
            }
        });

        //使用支付宝支付
        function aliPay() {
            location.href = '${pageContext.request.contextPath}/front/pay/goAliPay?orderNumber=' + '${order.orderNumber}';
        }

    </script>
</head>

<body class="animated fadeIn">

<!-- 导航栏 start -->
<jsp:include page="top.jsp">
    <jsp:param name="num" value="8"/>
</jsp:include>
<!-- 导航栏 end -->

<!-- content start -->
<div class="container" style="margin-top: 50px">
    <div class="row">
        <div class="col-sm-12">
            <div class="page-header" style="margin-top: 30px;">
                <h3>支付订单</h3>
            </div>
        </div>
    </div>
    <div align="center" style="background-color: #fcf8e3;margin-top: 40px;width: 50%;margin-left: 23%">
        <ul style="margin-top: 10px" class="list-group">
            <li class="list-group-item">
                <div align="left" style="margin-left: 30px;background: #D0D0D0" class="mark">
                    <p>
                        <span class="des-label">订单编号：</span>
                        <span>${order.orderNumber}</span>
                    </p>
    <c:forEach items="${orderItems}" var="orderItem">
                    <p>
                        <%--TODO:商品名称--%>
                        <span class="des-label">商品名称：</span>
                        <span>${orderItem.product.name}</span>
                    </p>
    </c:forEach>
                    <p>
                        <span class="des-label">支付金额：</span>
                        <b><span>${order.price}￥</span></b>
                    </p>
                    <p>
                        <span class="des-label">商品数量：</span>
                        <span>${order.productNumber}</span>
                    </p>
                </div>
            </li>
        </ul>
        <input type="hidden" name="orderNumber" id="orderNumber">
        <button type="button" class="btn btn-default col-sm-offset-3 col-sm-3" onclick="aliPay()"><img style="width: 20px;height: 20px;" src="/static/images/AliPay.png">&nbsp;支付宝支付</button>
        <button type="button" class="btn btn-default col-sm-offset-1 col-sm-3" ><img style="width: 20px;height: 20px;" src="/static/images/WeChat.png">&nbsp;微信支付</button>
    </div>
</div>
<!-- content end-->


<!-- footers start -->
<footer id="footer" class="footers navbar-fixed-bottom">
    <div class="footer container-fluid footers">
        Copy Right @ 2019 BY DENL
    </div>
</footer>
<!-- footers end -->
</body>

</html>
