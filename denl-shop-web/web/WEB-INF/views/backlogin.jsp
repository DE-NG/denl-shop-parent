<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>DENL商城-后台管理系统</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mycss.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrapValidator.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/zshop.css"/>

    <script>

        $(function () {
             /*登录表单校验*/
            $('#frmLogin').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields:{
                    loginName: {
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    }
                }
            });

            /*显示服务器端的消息*/
            var failMsg = '${failMsg}';
            if (failMsg != '') {
                layer.msg(failMsg,{
                    time: 1500,
                    area: '100px',
                    skin: 'errorMsg'
                });
            }
        });

    </script>

</head>
<body>
<!-- 使用自定义css样式 div-signin 完成元素居中-->
<div class="container div-signin" style="margin-top: 99px">
    <div class="panel panel-primary div-shadow">
        <!-- h3标签加载自定义样式，完成文字居中和上下间距调整 -->
        <div class="panel-heading">
            <h3>DENL商城</h3>
        </div>
        <div class="panel-body">
            <!-- login form start -->
            <form action="${pageContext.request.contextPath}/back/sysuser/doLogin" class="form-horizontal" method="post" id="frmLogin">
                <div class="form-group">
                    <label class="col-sm-3 control-label">用户名：</label>
                    <div class="col-sm-9">
                        <input class="form-control" type="text" placeholder="请输入用户名" id="loginName" name="loginName">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                    <div class="col-sm-9">
                        <input class="form-control" type="password" placeholder="请输入密码" id="password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-3">
                    </div>
                    <div class="col-sm-9 padding-left-0">
                            <button type="submit" style="width: 200px;" class="btn btn-primary btn-block">登&nbsp;&nbsp;陆</button>
                    </div>
                </div>
            </form>
            <!-- login form end -->
        </div>
    </div>
</div>
<!-- footers start -->
<footer id="footer" class="footer navbar-fixed-bottom">
    <div class="container-fluid footers text-center">
        Copy Right @ 2019 BY DENL
    </div>
</footer>
<!-- footers end -->
</body>
</html>
