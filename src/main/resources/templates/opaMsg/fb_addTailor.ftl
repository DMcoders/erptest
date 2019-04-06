<!DOCTYPE html>
<html>
<head>
    <#include "../feedback/fb_script.ftl">
    <@script> </@script>
    <link rel="stylesheet" href="/css/handsontable.full.min.css" type="text/css">
    <script src="/js/common/handsontable.full.min.js" type="text/javascript" ></script>
    <script src="/js/common/zh-CN.js" type="text/javascript" ></script>
    <script src="/js/opaMsg/addTailor.js?t=201904062112"></script>
</head>

<body>
    <input  type="hidden" value="${basePath}"  id="basePath"/>
    <input  type="hidden" value="${type}"  id="type"/>
    <#if type == "detail">
    <input  type="hidden" value="${orderName}"  id="orderName"/>
    </#if>
    <div class="col-md-12" style="padding-top: 20px;padding-bottom:10px;margin-left: 10px">
        <span style="font-size: 20px;font-family: PingFangSC-Semibold;color:rgb(55,56,57)">输入裁片信息</span>
    </div>
    <div class="row">
        <div class="col-md-4">
            <section class="panel panel-default">
                <header class="panel-heading font-bold">
                    <span class="label bg-success pull-right"></span>数量录入
                </header>
                <div  style="width:100%; overflow-x: hidden;overflow-y: auto;height: 410px;">
                    <div id="layerCountExcel" style="margin-left: 50px;"></div>
                </div>
            </section>
        </div>
        <div class="col-md-8">
            <section class="panel panel-default">
                <header class="panel-heading font-bold">
                    <span class="label bg-success pull-right"></span>基本信息
                </header>
                <table style="border-collapse:separate;border-spacing: 10px;width: 100%;" id="baseInfo">
                    <tr>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label" style="">订单号</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <input id="orderName" class="form-control" autocomplete="off">
                            <div id="orderNameTips"></div>
                        </td>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label">缸号</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <input id="jarName" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label" style="">客户</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <input id="customerName" class="form-control">
                        </td>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label">颜色</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <select id="colorName" class="form-control">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label" style="">床号</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <input id="bedNumber" class="form-control">
                        </td>
                        <td style="text-align: right;margin-bottom: 15px;">
                        </td>
                        <td style="margin-bottom: 15px;">
                        </td>
                    </tr>

                </table>
            </section>

            <section class="panel panel-default">
                <header class="panel-heading font-bold">
                    <span class="label bg-success pull-right"></span>唛架配比
                </header>
                <div style="margin-top: 10px;margin-left: 20px">
                    <label class="control-label" style="">尺码</label>
                    <input name="size" class="form-control" autocomplete="off" style="width:20%">
                </div>
                <div style="margin-bottom: 10px;margin-left: 20px">
                    <label class="control-label" style="">配比</label>
                    <input name="radio" class="form-control" autocomplete="off" style="width:20%">
                    <button  class="btn btn-s-xs" style="border-radius: 5px;margin-left: 10px"  onclick="addSize(this)">增加</button>
                    <button  class="btn btn-s-xs" style="border-radius: 5px;margin-left: 10px;background-color: rgb(236, 108, 98);display: none"  onclick="delSize(this)">删除</button>
                </div>
            </section>

            <section class="panel panel-default">
                <header class="panel-heading font-bold">
                    <span class="label bg-success pull-right"></span>部位选择
                </header>
                <div style="height: 50px">
                <div class="RadioStyle">
                    <input type="checkbox" id="love1" value="大身"/>
                    <label for="love1" style="margin-left: 20px">大身</label>
                    <input type="checkbox" id="love2" value="前身"/>
                    <label for="love2" style="margin-left: 20px">前身</label>
                    <input type="checkbox" id="love3" value="后身"/>
                    <label for="love3" style="margin-left: 20px">后身</label>
                    <input type="checkbox" id="love4" value="左胸"/>
                    <label for="love4" style="margin-left: 20px">左胸</label>
                </div>
                </div>
            </section>
        </div>
    </div>
    <div class="col-md-12" style="text-align: center;margin-top: 20px">
        <button  class="btn btn-s-lg" style="border-radius: 5px;"  onclick="addOrder()">生成</button>
    </div>
</body>
</html>
<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }

    .RadioStyle input {
        display: none
    }
    .RadioStyle label {
        border: 1px solid #CCC;
        color: #666;
        padding: 2px 10px 2px 5px;
        line-height: 28px;
        min-width: 80px;
        text-align: center;
        float: left;
        margin: 2px;
        border-radius: 4px
    }
    .RadioStyle input:checked + label {
        background: url("/images/ico_checkon.svg") no-repeat right bottom;
        border: 1px solid rgb(45, 202, 147);
        background-size: 21px 21px;
        color: rgb(45, 202, 147)
    }
    .RadioStyle input:disabled + label {
        opacity: 0.7;
    }
</style>
</style>
