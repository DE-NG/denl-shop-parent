<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>个人中心</title>
    <link rel="shortcut icon" type="image/x-icon" href="/static/images/apple.ico"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/iconfont/iconfont.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/zshop.js"></script>

    <script>
        $(function () {
            autoFooterHeight();
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
                                message: '联系电话不能为空'
                            },
                            regexp: {
                                regexp: '^[1][3,4,5,6,7,8,9][0-9]{9}$',
                                message: '无效的手机号'
                            }
                        }
                    },
                    address: {
                        validators: {
                            notEmpty: {
                                message: '联系地址不能为空'
                            }
                        }
                    }
                }
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

        //显示修改编辑信息弹框
        function showModifyCustomer(customerId) {
            console.log(customerId);
            $('#customerId').val(customerId);
            $('#ModifyCustomerModal').modal('show');
        }

        //修改用户信息
        function modifyCustomer() {
            var formData = new FormData();
            var id=$("#customerId").val();
            var loginName=$("#customerLoginName").val();
            var phone=$("#mobile").val();
            var address=$("#customerAddr").val();
            if($("#multipartFile")[0].files[0]!=null){
                formData.append("multipartFile",$("#multipartFile")[0].files[0]);
            }
            formData.append("customerId",id);
            formData.append("loginName",loginName);
            formData.append("phone",phone);
            formData.append("address",address);
            console.log(JSON.stringify(formData));
            $.ajax({
                url:'${pageContext.request.contextPath}/front/customer/editCustomer',
                data:formData,
                dataType:'json',
                type:"POST",
                async: false,
                processData : false, // 使数据不做处理
                contentType : false, // 不要设置Content-Type请求头
                success:function (result) {
                    if (result.code == "200") {
                        layer.msg(result.msg, {
                            time: 1000,
                            skin: 'successMsg'
                        }, function () {
                            location.reload();
                        });
                    } else {
                        layer.msg(result.msg, {
                            time: 1500,
                            skin: 'errorMsg'
                        });
                    }
                }
        });
        }


        //当file改变的时候，将img的src改为修改后的值
        // $('#multipartFile').change(function () {
        //     f = document.getElementById('multipartFile').files[0];
        //     var reads = new FileReader();
        //     reads.readAsDataURL(f);
        //     reads.onload = function(e) {
        //         $('#images').src = this.result;
        //     }
        // })
        // 点击button来点击input:file
        function clickFile(){
            $('#multipartFile').click();
        }
        // $('#btnImages').click(function () {
        //     alert(222)
        //
        // })

    </script>
    <style>

        #multipartFile{
            opacity:0;
        }
        #btnImages{
            background: #288cdd;
            border: none;
            width: 80px;
            height: 40px;
            line-height: 40px;
            font-size: 10px;
            color: #ffffff;
            border-radius: 20px;
        }
    </style>
</head>

<body>

<!-- 导航栏 start -->
<jsp:include page="top.jsp">
    <jsp:param name="num" value="4"/>
</jsp:include>
<!-- 导航栏 end -->

<!-- content start -->
<div class="container" style="margin-top:100px;margin-left: 350px">
    <div class="row">
        <div class="col-sm-6">
            <div class="page-header" style="margin-bottom: 0px;">
                <h3>基本资料
                    <span style="letter-spacing:1px;font-size:14px;cursor: pointer;float: right"
                          class="glyphicon glyphicon-edit text-success" onclick="showModifyCustomer(${user.id})">
                        编辑</span>
                </h3>
            </div>
        </div>
    </div>
</div>
<div class="container" style="margin-left: 350px">
    <form class="form-horizontal">
        <div class="form-group">
            <label class="col-md-2 col-sm-2 control-label">头像:</label>
            <div class="col-sm-3">
                <img style="width: 100px;height: 100px;" src="${user.images}">
            </div>
        </div>
        <div class="form-group">
            <label for="loginName" class="col-md-2 col-sm-2 control-label">用户名:</label>

            <div class="col-sm-3">
                <input type="text" class="form-control" id="loginName" placeholder="用户名" readonly="readonly"
                       value="${user.loginName}">

            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-md-2  col-sm-2 control-label">手机号:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="phone" placeholder="手机号" value="${user.phone}" readonly>

            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-md-2   col-sm-2  control-label">联系地址:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="address" placeholder="详细地址" value="${user.address}"
                       readonly>

            </div>
        </div>
        <%--<div class="form-group">--%>
        <%--<div class="col-sm-offset-2 col-sm-3">--%>
        <%--<button type="submit" class="btn btn-info">保存</button>--%>
        <%--<button type="submit" class="btn btn-info">取消</button>--%>
        <%--</div>--%>
        <%--</div>--%>
    </form>
</div>
<div class="modal fade" id="ModifyCustomerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="top: 10%">
    <div class="modal-dialog" role="document" style="width: 36%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">个人信息修改</h4>
            </div>
            <div class="modal-body" style="overflow: auto">
                <form enctype="multipart/form-data" class="form-horizontal col-sm-11" id="frmModifyCustomer">
                    <div class="form-group">
                        <label for="multipartFile" class="col-sm-4 control-label">头像:</label>
                        <div class="col-sm-7">
                            <img id="images" style="width: 100px;height: 100px;" src="${user.images}">

                            <input type="file" id="hiddenfile" style="display: none;"/>
                            <button style="margin-right: 1px" id="btnImages" onclick="clickFile()">修改图片</button>
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="file" id="multipartFile"  name="multipartFile"/>
                    </div>
                    <div class="form-group">
                        <label for="loginName" class="col-sm-4 control-label">用户名</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="customerLoginName" placeholder="用户名" name="myName" value="${user.loginName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-4 control-label">手机号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="mobile" name="phone" value="${user.phone}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="customerAddr" class="col-sm-4 control-label">联系地址</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="customerAddr" name="address"
                                   value="${user.address}">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <input type="hidden" name="customerId" id="customerId">
                <button type="button" class="btn btn-primary" onclick="modifyCustomer()">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!-- content end-->

<!-- footers start -->
<footer id="footer" class="footer navbar-fixed-bottom">
    <div class="container-fluid footers">
        Copy Right @ 2019 BY DENL
    </div>
</footer>
<!-- footers end -->
</body>

<script>
    $(function () {
        $("#multipartFile").change(function(){
            // Get a reference to the fileList
            var files = !!this.files ? this.files : [];

            // If no files were selected, or no FileReader support, return(如果没有选择任何文件，或者没有文件读取器支持，则返回)
            if (!files.length || !window.FileReader) return;

            // Only proceed if the selected file is an image(仅当所选文件是图像时才继续)
            if (/^image/.test( files[0].type)){
                // Create a new instance of the FileReader
                var reader = new FileReader();

                // Read the local file as a DataURL(以dataurl形式读取本地文件)
                reader.readAsDataURL(files[0]);

                // 加载时，将图像数据设置为图片标签的内容的背景
                reader.onloadend = function(){
                    $("#images").attr("src", this.result);
                }
            }
        })
    })
</script>

</html>
