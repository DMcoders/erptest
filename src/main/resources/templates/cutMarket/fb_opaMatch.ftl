<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">花片配对</li>
            </ul>
            <div class="row">
                <div class="col-md-6" style="margin-left: 35px;height: 100px;text-align: center;vertical-align: middle;background:rgb(45, 202, 147);border-radius: 15px;">
                    <label style="color:white;font-size:35px;font-family: PingFangSC-Semibold,sans-serif;width:100%;height: 100%;vertical-align: middle;margin-top: 4%;">花片配对</label>
                </div>
            </div>
            <div class="col-md-12" style="padding-top: 20px;">
                <section class="panel panel-default">
                    <div class="panel-body" style="text-align: left">
                        <div class="row" style="margin-left: 10px;margin-top: 30px;">
                            <span style="font-family: PingFangSC-Semibold,sans-serif;color:black">请扫描花片二维码</span>
                        </div>
                        <div class = "row">
                            <div class="col-md-6" style="margin-top: 10px;">
                                <textarea id="opaQcode" rows="6" class="form-control" style="background: rgb(248,248,248);width :100%"></textarea>
                            </div>

                            <div class="col-md-6" style="margin-top: 10px;">
                                <textarea id="storeLocation" rows="6" class="form-control" style="background: rgb(248,248,248);width : 100%"></textarea>
                            </div>
                        </div>
                        <div class="col-md-6" style="margin-top: 10px;text-align: right">
                            <span id="scanNum" style="font-family: PingFangSC-Semibold;font-size:18px;">已扫描0件</span>
                        </div>
                    </div>
                </section>
            </div>
            <div class="col-md-12" style="text-align: center;margin-top: 40px">
                <button  class="btn btn-s-lg" style="border-radius: 5px;"  onclick="opaMatch()">确认</button>
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
<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/cutMarket/opaMatch.js?t=2019040601912"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;

        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
