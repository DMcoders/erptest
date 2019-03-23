<#macro aside>
<aside class="bg-dark lter aside-md hidden-print" id="nav">
    <section class="vbox">
        <section class="w-f scrollable">
            <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0"
                 data-size="5px" data-color="#333333"> <!-- nav -->
                <nav class="nav-primary hidden-xs">
                    <ul class="nav">
                        <li><a href="/"> <i
                                class="fa fa-dashboard icon"> <b class="bg-danger"></b> </i> <span>主页</span>
                        </a></li>

                        <li <#if bigMenuTag==1> class="active"</#if>> <a href="#" <#if bigMenuTag==1> class="active"</#if>> <i class="fa fa-building-o icon"> <b class="bg-success"></b> </i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>场景管理</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==1> class="active" </#if>><a href="/lingbao/scene/sceneRuleMgtStart"> <i class="fa fa-angle-right"></i> <span>场景规则管理</span> </a>
                                </li>
                                <li<#if menuTag==2> class="active" </#if>><a href="/lingbao/scene/sceneWordMgtStart"> <i class="fa fa-angle-right"></i> <span>场景违禁词管理</span> </a>
                                </li>
                            </ul>
                        </li>

                        <li <#if bigMenuTag==2> class="active"</#if>> <a href="#" <#if bigMenuTag==2> class="active"</#if>> <i class="fa fa-columns icon"> <b class="bg-success"></b> </i>
                            <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span>
                            <span>词包管理</span> </a>
                            <ul class="nav lt">
                                <li<#if menuTag==1> class="active" </#if>><a href="/lingbao/basicWord/basicWordMgtStart"> <i class="fa fa-angle-right"></i> <span>词包违禁词管理</span> </a>
                                </li>
                            </ul>
                        </li>

                        <li <#if bigMenuTag==3> class="active"</#if>><a href="/lingbao/basicWord/illegalWordMgtStart"> <i class="fa fa-pinterest icon"></i> <span>BS端违禁词执行页面</span> </a>
                        </li>

                        <li <#if bigMenuTag==4> class="active"</#if>><a href="/lingbao/log/logQueryMgtStart"> <i class="fa fa-file-text-o icon"></i> <span>日志查询</span> </a>
                        </li>

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