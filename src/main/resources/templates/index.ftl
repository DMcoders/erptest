<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>祥胜制衣管理系统</title>
</head>
<#include "fb_script.ftl">
<@script> </@script>
<body>
    <div class="row" style="text-align: center">
        <label style="color:rgb(45, 202, 147);font-size: 50px;margin-top: 8%;">祥胜制衣管理系统</label>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3" style="margin-top: 55px;margin-left: 260px;">
            <label style="color:white;font-size: 18px;">管理员账号</label>
        </div>
        <div class="col-md-6 col-md-offset-3">
            <input  id="userName" type="text" class="form-control" placeholder="请输入账号">
        </div>
        <div class="col-md-6 col-md-offset-3" style="margin-top: 50px;margin-left: 234px;">
            <label style="color:white;font-size: 18px;">密码</label>
        </div>
        <div class="col-md-6 col-md-offset-3">
            <input id="passWord" type="password" class="form-control" placeholder="请输入密码">
        </div>
        <div class="col-md-6 col-md-offset-3" style="margin-top: 84px;">
            <button id="loginBtn" class="btn btn-s-lg" onclick="login()">登录</button>
        </div>
    </div>
</body>
</html>
<script src="/js/login/login.js?t=201903211312"></script>

<style>
    html,body { height: 100% }

    body{
        background:url("/pic/index2.jpg") no-repeat;
        background-size: cover;
        text-align:center;
        filter: brightness(0.9);
    }

    #loginBtn {
        outline:none;
        background-color:rgb(45, 202, 147,0.86);
        color: white;
        font-size: 16px;
        width:43%;
        font-family:PingFangSC-Semibold;
    }

    .form-control {
        width:43%;
        background: rgb(225,225,225,0.86);
        border: rgba(255,255,255,0.86);
    }
</style>