<#macro aside>
<aside class="bg-dark lter aside-md hidden-print" id="nav">
    <section class="vbox">
        <section class="w-f scrollable">
            <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0"
                 data-size="5px" data-color="#333333"> <!-- nav -->
                <nav class="nav-primary hidden-xs">
                    <ul class="nav">
                        <#--<li><a href="/homepage"> <i-->
                                <#--class="fa fa-dashboard icon"> <b class="bg-danger"></b> </i> <span>主页</span>-->
                        <#--</a></li>-->
                        <#if role! == 'root'>
                        <li <#if bigMenuTag==1> class="active"</#if>> <a href="#" <#if bigMenuTag==1> class="active"</#if>> <i class="fa fa-clock-o fa-flip-horizontal icon"></i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>订单模块</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==1> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/orderStart"><span class="liActive">订单信息</span> </a></li>
                                <li<#if menuTag==2> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/reportStart"><span class="liActive">报表查询</span> </a></li>
                            </ul>
                        </li>

                        <li <#if bigMenuTag==2> class="active"</#if>> <a href="#" <#if bigMenuTag==2> class="active"</#if>> <i class="fa fa-clock-o fa-flip-horizontal icon"></i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>裁片超市</span> </a>
                            <ul class="nav lt">
                                <#--<li<#if menuTag==1> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="#"><span class="liActive">输入裁片信息</span> </a></li>-->
                                <li<#if menuTag==2> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/tailorStart"><span class="liActive">扎号信息</span> </a></li>
                                <li<#if menuTag==3> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/instoreStart"><span class="liActive">裁片入库</span> </a></li>
                                <li<#if menuTag==4> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/changeStoreStart"><span class="liActive">裁片调库</span> </a></li>
                                <li<#if menuTag==5> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/storageStateStart"><span class="liActive">库存信息</span> </a></li>
                                <li<#if menuTag==6> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/opaStart"><span class="liActive">花片出厂</span> </a></li>
                                <li<#if menuTag==7> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/opaBackStart"><span class="liActive">花片回厂</span> </a></li>
                                <li<#if menuTag==8> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/opaMatchStart"><span class="liActive">花片配对</span> </a></li>
                            </ul>
                        </li>

                        <li <#if bigMenuTag==3> class="active"</#if>> <a href="#" <#if bigMenuTag==3> class="active"</#if>> <i class="fa fa-clock-o fa-flip-horizontal icon"></i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>衣胚超市</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==1> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embInStoreStart"><span class="liActive">衣胚入库</span> </a></li>
                                <li<#if menuTag==2> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embOutStoreStart"><span class="liActive">衣胚出库</span> </a></li>
                                <li<#if menuTag==4> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embStorageQueryStart"><span class="liActive">衣胚查询</span> </a></li>
                                <li<#if menuTag==3> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embStorageStateStart"><span class="liActive">衣胚库存</span> </a></li>
                            </ul>
                        </li>

                        <li <#if bigMenuTag==4> class="active"</#if>> <a href="#" <#if bigMenuTag==4> class="active"</#if>> <i class="fa fa-clock-o fa-flip-horizontal icon"></i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>工厂信息录入</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==1> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/storeHouseStart"> <span class="liActive">仓库信息</span> </a></li>
                                <li<#if menuTag==2> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embStoreStart"> <span class="liActive">衣胚仓库</span> </a></li>
                                <li<#if menuTag==3> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/customerStart"> <span class="liActive">顾客信息</span> </a></li>
                                <li<#if menuTag==4> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/userStart"> <span class="liActive">用户信息</span> </a></li>
                            </ul>
                        </li>
                        <#elseif role! == 'role1'>
                        <li <#if bigMenuTag==1> class="active"</#if>> <a href="#" <#if bigMenuTag==1> class="active"</#if>> <i class="fa fa-clock-o fa-flip-horizontal icon"></i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>订单模块</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==1> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/orderStart"><span class="liActive">订单信息</span> </a></li>
                            </ul>
                        </li>
                        <li <#if bigMenuTag==2> class="active"</#if>> <a href="#" <#if bigMenuTag==2> class="active"</#if>> <i class="fa fa-clock-o fa-flip-horizontal icon"></i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>裁片超市</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==2> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/tailorStart"><span class="liActive">扎号信息</span> </a></li>
                            </ul>
                        </li>
                        <#elseif role! == 'role2'>
                        <li <#if bigMenuTag==2> class="active"</#if>> <a href="#" <#if bigMenuTag==2> class="active"</#if>> <i class="fa fa-clock-o fa-flip-horizontal icon"></i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>裁片超市</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==3> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/instoreStart"><span class="liActive">裁片入库</span> </a></li>
                                <li<#if menuTag==4> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/changeStoreStart"><span class="liActive">裁片调库</span> </a></li>
                                <li<#if menuTag==5> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/storageStateStart"><span class="liActive">库存信息</span> </a></li>
                                <li<#if menuTag==6> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/opaStart"><span class="liActive">花片出厂</span> </a></li>
                                <li<#if menuTag==7> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/opaBackStart"><span class="liActive">花片回厂</span> </a></li>
                                <li<#if menuTag==8> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/opaMatchStart"><span class="liActive">花片配对</span> </a></li>
                            </ul>
                        </li>
                        <#elseif role! == 'role3'>
                        <li <#if bigMenuTag==3> class="active"</#if>> <a href="#" <#if bigMenuTag==3> class="active"</#if>> <i class="fa fa-clock-o fa-flip-horizontal icon"></i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>衣胚超市</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==1> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embInStoreStart"><span class="liActive">衣胚入库</span> </a></li>
                                <li<#if menuTag==2> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embOutStoreStart"><span class="liActive">衣胚调库</span> </a></li>
                                <li<#if menuTag==4> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embStorageQueryStart"><span class="liActive">衣胚查询</span> </a></li>
                                <li<#if menuTag==3> class="active" style="background:rgb(45, 202, 147)" </#if>><a href="/embStorageStateStart"><span class="liActive">衣胚库存</span> </a></li>
                            </ul>
                        </li>
                        </#if>

                    </ul>
                </nav>
            </div>
        </section>

        <footer class="footer lt hidden-xs b-t b-dark">
            <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-dark btn-icon"> <i
                    class="fa fa-angle-left text"></i> <i class="fa fa-angle-right text-active"></i> </a>
        </footer>
    </section>
</aside>
</#macro>

<style>
    .liActive {
        margin-left:40px;
        font-family: PingFangSC-Medium,sans-serif;
    }
</style>

<script>
    $(document).ready(function () {
        $(".nav.lt").on("click","li" ,function () {
            $(".nav.lt li").css("background","");
            $(this).css("background","rgb(45, 202, 147)");
        });
    });
</script>