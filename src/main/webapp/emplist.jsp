<!DOCTYPE html>
<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <!--在手机网站，都需要加上视口约束！！！-->
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
    <!--以最新的内核渲染页面-->
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <!--引入样式文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bs/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/jqgrid/css/trirand/ui.jqgrid-bootstrap.css"
          type="text/css">
    <!--引入js功能文件-->
    <script src="${pageContext.request.contextPath}/static/bs/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/bs/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/jqgrid/js/trirand/i18n/grid.locale-cn.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/jqgrid/js/trirand/jquery.jqGrid.min.js"
            type="text/javascript"></script>
    <script type="text/javascript">
        /*  $(function () {
          }*/

        // 分页查询
        function showEmp() {

            $('#table').jqGrid({
                // 整合使用bootstrap样式的属性
                styleUI: 'Bootstrap',
                url: '${pageContext.request.contextPath}/supplier/selectByPage',
                datatype: 'json',
                colNames: ['供应商ID', '供应商名称', '负责人', '联系电话', '创建时间'],
                // 开启表格编辑模式
                cellEdit: true,
                // 指定表单编辑时提交的路径
                editurl: '${pageContext.request.contextPath}/supplier/operSupplier',
                colModel: [
                    //传入后台的数据
                    {name: 'id', align: 'center'},
                    {name: 'name', align: 'center', editable: true},
                    {name: 'leader', align: 'center', editable: true},
                    {name: 'phone', align: 'center', editable: true},
                    {name: 'createdate', align: 'center', editable: true},
                ],
                autowidth: true,
                pager: '#pager',
                rowList: [2, 4, 10, 20, 50],
                rowNum: 2,
                page: 1,
                viewrecords: true,
                multiselect: true,
                rownumbers: true,
                height: 350,
            }).navGrid('#pager');
        }

        $(function () {
            $("#like").click(function () {
                var name = $("#name").val();
                var option = $("#option").val();
                $("#table").jqGrid("setGridParam", {
                    url: "${pageContext.request.contextPath}/supplier/like?name=" + name + "&option=" + option,
                    datatype: "json",
                    type: "post"
                }).trigger("reloadGrid");
            })
        })
        //模糊查询
        /*$(function () {
            $("#like").click(function () {
                $('#emplist').show();
                var name = $("#name").val();
                $.ajax({
                    url: '/supplier/like',
                    data: {name: name},
                    type: 'post',
                    dataType: 'json',
                    success: function (result) {
                        console.log(result);
                        for (var i in result) {
                            console.log(result)
                            $("#table").append(
                                "<tr>" +
                                "<td>" + result[i].id + "</td>" +
                                "<td>" + result[i].name + "</td>" +
                                "<td>" + result[i].leader + "</td>" +
                                "<td>" + result[i].phone + "</td>" +
                                "<td>" + result[i].createdate + "</td>",
                                "<tr>"
                            );
                        }
                    },
                    error: function () {
                        alert('出错了~~~')
                    }
                });
            })
        })*/

    </script>
</head>
<body>
<div class="container">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#col-menu">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
        </div>
        <div class="navbar-collapse collapse" id="col-menu" style="text-align: center">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#col-menu">
            </button>
            <a href="" class="navbar-brand">仓库管理系统</a>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#col-menu">
            </button>
            <h3 style="color: white" align="right">欢迎${sessionScope.user1.name}</h3>
        </div>
    </div>

    <br><br><br>
    <div class="row">
        <div class="col-md-3">

            <div class="panel-group" id="pg">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <a href="#pn2" class="panel-title" data-toggle="collapse" data-parent="#pg">
                            库存管理
                        </a>
                    </div>
                    <div class="panel-collapse collapse" id="pn4">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="javascript:void(0)"
                                                               onclick="showDep()">查看部门信息</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <a href="#pn2" class="panel-title" data-toggle="collapse" data-parent="#pg">
                            出入库管理
                        </a>
                    </div>
                    <div class="panel-collapse collapse" id="pn5">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="javascript:void(0)"
                                                               onclick="showDep()">查看部门信息</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <a href="#pn2" class="panel-title" data-toggle="collapse" data-parent="#pg">
                            人员管理
                        </a>
                    </div>
                    <div class="panel-collapse collapse" id="pn2">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="javascript:void(0)"
                                                               onclick="showDep()">查看部门信息</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <a href="#pn1" class="panel-title" data-toggle="collapse"
                           data-parent="#pg">
                            基础数据
                        </a>
                    </div>
                    <div class="panel-collapse collapse" id="pn1">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="javascript:void(0)"
                                                               onclick="showEmp()">供应商信息管理</a></li>
                                <li class="list-group-item"><a href="javascript:void(0)"
                                                               onclick="showEmp()">客户信息管理</a></li>
                                <li class="list-group-item"><a href="javascript:void(0)"
                                                               onclick="showEmp()">货物信息管理</a></li>
                                <li class="list-group-item"><a href="javascript:void(0)"
                                                               onclick="showEmp()">仓库信息管理</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <a href="#pn2" class="panel-title" data-toggle="collapse" data-parent="#pg">
                            系统维护
                        </a>
                    </div>
                    <div class="panel-collapse collapse" id="pn3">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="javascript:void(0)"
                                                               onclick="showDep()">查看部门信息</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-9">
            <div class="panel-body container" align="center">

            </div>

            <!--展示员工信息-->
            <div class="panel panel-primary" id="emplist">
                <div class="panel-heading">
                    <h3 class="panel-title">供应商信息管理</h3>
                </div>
                <div class="panel-body">
                    <form action="" class="form-inline">
                        <div class="form-group">
                            <label for="name" class="sr-only">name</label>
                            <input type="text" name="supplier" class="form-control" id="name" placeholder="请输入条件">
                        </div>
                        <select name="option" id="option" class="form-control col-md-1">
                            <option value="name">名称</option>
                            <option value="leader">负责人</option>
                        </select>
                        <button type="button" class="btn btn-success" id="like">搜索</button>
                    </form>
                </div>
                <table id="table" class="table table-striped table-bordered table-hover">

                </table>
                <%--分页工具栏--%>
                <div id="pager"></div>
            </div>

        </div>
    </div>

</div>


<script type="text/javascript">

</script>
</body>
</html>















