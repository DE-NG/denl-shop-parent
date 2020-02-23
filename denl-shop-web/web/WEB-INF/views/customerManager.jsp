<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>backend</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/userSetting.js"></script>
    <script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrapValidator.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap-paginator.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrapValidator.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/zshop.css"/>

    <script>
        $(function () {

            //显示服务端传过来的消息
            var successMsg = '${successMsg}';
            var failMsg = '${failMsg}';

            if (successMsg != '') {
                layer.msg(successMsg,{
                   time: 1000,
                    //TODO:设置他弹出层的宽度，高度自适应
                    area: '100px',
                   skin: 'successMsg'
                });
            }

            if (failMsg != '') {
                layer.msg(failMsg,{
                    time: 1500,
                    //TODO:设置他弹出层的宽度，高度自适应
                    area: '100px',
                    skin: 'errorMsg'
                });
            }

            //修改客户信息校验
            $('#frmModifyCustomer').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    phone: {
                        validators: {
                            notEmpty: {
                                message: "用户手机号不能为空"
                            },
                            regexp: {
                                regexp: '^[1][3,4,5,6,7,8,9][0-9]{9}$',
                                message: '无效的手机号码'
                            }
                        }
                    },
                    address: {
                        validators: {
                            notEmpty: {
                                message: '用户地址不能为空'
                            }
                        }
                    }
                }
            });

            //TODO:检测修改用户信息的modal 框隐藏的时候，将校验的数据清空
            $('#myModal').on('hide.bs.modal',function () {
                //清空校验数据
                $('#frmModifyCustomer').bootstrapValidator('resetForm');
            });
        });

        //展示客户信息
        function showCustomer(id) {
            $.post(
                '${pageContext.request.contextPath}/back/customer/showCustomer',
                {'id': id},
                function (result) {
                    if (result.code == "200") {
                        $('#id').val(result.data.id);
                        $('#loginName').val(result.data.loginName);
                        $('#phone').val(result.data.phone);
                        $('#my-addrees').val(result.data.address);
                    }
                }
            );
        }

        //修改客户状态
        function modifyCustomerStatus(id,btn){
            $.post(
                '${pageContext.request.contextPath}/back/customer/modifyCustomerStatus',
                {'id' : id},
                function (result) {
                    if (result.code == "200") {
                        layer.msg(result.msg,{
                            time: 700,
                            skin: 'successMsg'
                        },function () {
                            var $td = $(btn).parent().prev();
                            if ($td.text().trim() == '有效') {
                                //修改表格中td的值显示
                                $td.text('无效');
                                //修改按钮的状态
                                $(btn).val('启用').removeClass('btn-danger').addClass('btn-success');
                            }else{
                                //修改表格中td的值显示
                                $td.text('有效');
                                $(btn).val('禁用').removeClass('btn-success').addClass('btn-danger');
                            }
                        });
                    }else{
                        layer.msg(result.msg,{
                            time: 700,
                            skin: 'errorMsg'
                        });
                    }
                }
            );
        }

    </script>

</head>

<body>
<div class="panel panel-default" id="userInfo" id="homeSet">
    <div class="panel-heading">
        <h3 class="panel-title">客户管理</h3>
    </div>
    <div class="panel-body">

        <%--表头--%>
        <div class="show-list text-center" style="position: relative;top: 30px;">
            <table class="table table-bordered table-hover" style='text-align: center;'>
                <thead>
                <tr class="text-danger">
                    <th class="text-center">序号</th>
                    <th class="text-center">帐号</th>
                    <th class="text-center">头像</th>
                    <th class="text-center">电话</th>
                    <th class="text-center">地址</th>
                    <th class="text-center">注册时间</th>
                    <th class="text-center">状态</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="tb">
                <c:forEach items="${pageInfo.list}" var="customer">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.loginName}</td>
                        <td><img src="${customer.images}" alt="" width="60" height="60"></td>
                        <td>${customer.phone}</td>
                        <td>${customer.address}</td>
                        <td>${customer.registDate}</td>
                        <td>
                            <c:if test="${customer.isValid == 1}">有效</c:if>
                            <c:if test="${customer.isValid == 0}">无效</c:if>
                        </td>
                        <td class="text-center">
                            <input type="button" class="btn btn-warning btn-sm doModify"
                                   onclick="showCustomer(${customer.id})" value="修改">
                            <c:if test="${customer.isValid == 0}">
                                <input type="button" class="btn btn-success btn-sm doDisable" onclick="modifyCustomerStatus(${customer.id},this)" value="启用">
                            </c:if>
                            <c:if test="${customer.isValid == 1}">
                                <input type="button" class="btn btn-danger btn-sm doDisable" onclick="modifyCustomerStatus(${customer.id},this)" value="禁用">
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <ul class="pagination">
                <li><a href="/back/customer/getAllCustomers?pageNum=${pageInfo.prePage}">&laquo;</a></li>
                <c:forEach items="${pageInfo.navigatepageNums}" var="p">
                    <li><a href="/back/customer/getAllCustomers?pageNum=${p}">${p}</a></li>
                </c:forEach>
                <li><a href="/back/customer/getAllCustomers?pageNum=${pageInfo.nextPage}">&raquo;</a></li>

            </ul>
        </div>
    </div>
</div>

<!-- 修改客户信息 start -->
<div class="modal fade" tabindex="-1" id="myModal">
    <!-- 窗口声明 -->
    <div class="modal-dialog">
        <!-- 内容声明 -->
        <form action="${pageContext.request.contextPath}/back/customer/modifyCustomer" method="post" id="frmModifyCustomer">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">修改客户</h4>
                </div>
                <div class="modal-body text-center">
                    <div class="row text-right">
                        <%--TODO:当前页面放到隐藏域中--%>
                        <input type="hidden" name="pageNum" value="${pageInfo.pageNum}">
                        <label for="id" class="col-sm-4 control-label">编号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" readonly id="id" name="id">
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="row text-right">
                        <label for="loginName" class="col-sm-4 control-label">帐号：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" readonly id="loginName" name="loginName">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right form-group">
                        <label for="phone" class="col-sm-4 control-label">电话：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="phone" name="phone">
                        </div>
                    </div>
                    <br>
                    <div class="row text-right form-group">
                        <label for="my-addrees" class="col-sm-4 control-label">地址：</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="my-addrees" name="address">
                        </div>
                    </div>
                    <br>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary updateOne">确认</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- 修改客户信息 end -->
</body>

</html>
