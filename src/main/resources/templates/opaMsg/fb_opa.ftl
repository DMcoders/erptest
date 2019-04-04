<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">花片出厂</li>
            </ul>
            <div class="col-md-12" style="padding-top: 20px;">
                <span style="font-size: 20px;font-family: PingFangSC-Semibold">花片出厂录入</span>
            </div>
            <div class="col-md-12" style="padding-top: 20px;">
                <section class="panel panel-default">
                    <div class="panel-body" style="text-align: left">
                        <div class="row" style="margin-left: 10px;margin-bottom: 20px">
                            <button  class="btn btn-s-lg" style="border-radius: 5px;"  onclick="addOPA()">出厂录入</button>
                        </div>
                        <div style="overflow-x: auto;overflow-y:auto;max-height: 600px;text-align: center;font-family: PingFangSC-Semibold,sans-serif;">
                            <table class="table table-striped table-bordered ">
                            <#if opaList?? && opaList?size gt 0>
                                <thead>
                                    <tr bgcolor="#ffcb99" style="color: black;">
                                        <th style="width: 10%;text-align:center;font-size:14px">序号</th>
                                        <th style="width: 15%;text-align:center;font-size:14px">订单号</th>
                                        <th style="width: 10%;text-align:center;font-size:14px">客户名</th>
                                        <th style="width: 15%;text-align:center;font-size:14px">发送目的地</th>
                                        <th style="width: 10%;text-align:center;font-size:14px">尺码</th>
                                        <th style="width: 10%;text-align:center;font-size:14px">出厂数量</th>
                                        <th style="width: 10%;text-align:center;font-size:14px">出厂日期</th>
                                        <th style="width: 10%;text-align:center;font-size:14px">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#list opaList as opa>
                                    <tr>
                                        <td>${opa_index+1}</td>
                                        <td>${opa.orderName!}</td>
                                        <td>${opa.customerName!}</td>
                                        <td>${opa.destination!}</td>
                                        <td>${opa.sizeName!}</td>
                                        <td>${opa.opaCount!}</td>
                                        <td>${opa.opaDate!}</td>
                                        <td><a href="#" style="color:#3e8eea;" onclick="deleteOPA(${opa.opaID?c})">删除</a></td>
                                    </tr>
                                </#list>
                                </tbody>
                            <#else>
                            <h4 style="text-align: center">暂无数据</h4>
                            </#if>
                            </table>
                        </div>
                    </div>
                </section>
            </div>
            <div class="row">
                <div id="entities" class="col-sm-12">
                </div>
                <#include "fb_opaAdd.ftl">
                <@entities></@entities>
            </div>
        </section>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen"
       data-target="#nav"></a>
</section>
<aside class="bg-light lter b-l aside-md hide" id="notes">
    <div class="wrapper">Notification</div>
</aside>
</section>
<#--<link rel="stylesheet" href="/css/laydate.css" type="text/css">-->
<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/common/laydate.js" type="text/javascript" ></script>
<script src="/js/opaMsg/opa.js?t=201904022212"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>