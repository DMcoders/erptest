<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff" id="storageSection">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">库存信息</li>
            </ul>
            <div class="col-md-12" style="padding-top: 20px;padding-bottom: 20px">
                <span style="font-size: 20px;font-family: PingFangSC-Semibold">仓库实时概览</span>
                <label style="margin-left: 20px;border-radius: 6px;background: rgb(206,39,60)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                <span style="font-size: 16px;font-family: PingFangSC-Semibold">满仓</span>
                <label style="margin-left: 20px;border-radius: 6px;background: rgb(217,202,23)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                <span style="font-size: 16px;font-family: PingFangSC-Semibold">半仓</span>
                <label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                <span style="font-size: 16px;font-family: PingFangSC-Semibold">空仓</span>
            </div>

            <#--<div class="col-sm-1" style="margin-top: 30px;text-align: right">-->
                <#--<span style="font-size: 26px;font-family: PingFangSC-Semibold">1</span>-->
            <#--</div>-->
            <#--<div class="col-sm-11">-->
                <#--<section class="panel panel-default">-->
                    <#--<div class="panel-body" style="text-align: left">-->
                        <#--<table id="storageStateTable">-->
                            <#--<tr>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                            <#--</tr>-->
                            <#--<tr>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                            <#--</tr>-->
                            <#--<tr>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                            <#--</tr>-->
                        <#--</table>-->
                    <#--</div>-->
                <#--</section>-->
            <#--</div>-->


            <#--<div class="col-sm-1" style="margin-top: 30px;text-align: right">-->
                <#--<span style="font-size: 26px;font-family: PingFangSC-Semibold">1</span>-->
            <#--</div>-->
            <#--<div class="col-sm-11">-->
                <#--<section class="panel panel-default">-->
                    <#--<div class="panel-body" style="text-align: left">-->
                        <#--<table id="storageStateTable">-->
                            <#--<tr>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                            <#--</tr>-->
                            <#--<tr>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                            <#--</tr>-->
                            <#--<tr>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                                <#--<td><label style="margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>-->
                            <#--</tr>-->
                        <#--</table>-->
                    <#--</div>-->
                <#--</section>-->
            <#--</div>-->
        </section>
    </section>
</section>
</section>

<script src="/js/opaMsg/storageState.js?t=201904072112"></script>


</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
