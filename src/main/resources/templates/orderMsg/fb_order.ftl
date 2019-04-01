<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">订单信息</li>
            </ul>

            <ul id="orderTab" class="nav nav-tabs">
                <li class="active">
                    <a href="#orderListDiv" data-toggle="tab">
                        <span style="font-size: 20px;font-family: PingFangSC-Semibold">订单信息</span>
                    </a>
                </li>
                <li>
                    <a href="#addOrderDiv" data-toggle="tab">
                        <span style="font-size: 20px;font-family: PingFangSC-Semibold">订单录入</span>
                        <#--<i class="fa glyphicon-remove text tab-close"></i>-->
                    </a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane fade in active" id="orderListDiv">
                    <div class="col-md-12" style="padding-top: 20px;">
                        <section class="panel panel-default">
                            <div class="panel-body" style="text-align: left">
                                <div class="row" style="margin-left: 10px;margin-bottom: 20px">
                                    <button  class="btn btn-s-lg" style="border-radius: 5px;"  onclick="addOrder()">录入订单</button>
                                </div>
                                <div style="text-align: center;font-family: PingFangSC-Semibold,sans-serif;">
                                    <table id="orderTable" class="table table-striped table-hover">
                                    </table>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>

                <div class="tab-pane fade" id="addOrderDiv">
                    <div class="col-md-12" style="padding-top: 20px;">
                        <span style="font-size: 20px;font-family: PingFangSC-Semibold">订单详情录入（直接粘贴数据）</span>
                    </div>
                </div>
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
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/orderMsg/order.js?t=201903272212"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
