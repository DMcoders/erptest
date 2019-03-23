<#macro head>
<header class="bg-dark dk header navbar navbar-fixed-top-xs">
    <div class="navbar-header aside-md"><a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen"
                                           data-target="#nav"> <i class="fa fa-bars"></i> </a> <a href="#"
                                                                                                  class="navbar-brand"
                                                                                                  style="font-size: 18px;"
                                                                                                  data-toggle="fullscreen"><img
            src="/resources/images/logo.png" class="m-r-sm">灵宝平台</a> <a class="btn btn-link visible-xs"
                                                                             data-toggle="dropdown"
                                                                             data-target=".nav-user"> <i
            class="fa fa-cog"></i> </a></div>
    <ul class="nav navbar-nav navbar-right hidden-xs nav-user">
        <li class="dropdown hidden-xs"><a href="#" class="dropdown-toggle dker" data-toggle="dropdown"><i
                class="fa fa-fw fa-search"></i></a>
            <section class="dropdown-menu aside-xl animated fadeInUp">
                <section class="panel bg-white">
                    <form role="search">
                        <div class="form-group wrapper m-b-none">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search">
                                <span class="input-group-btn">
                  <button type="submit" class="btn btn-info btn-icon"><i class="fa fa-search"></i></button>
                  </span></div>
                        </div>
                    </form>
                </section>
            </section>
        </li>
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> ${userName!""} <b
                class="caret"></b> </a>
            <ul class="dropdown-menu animated fadeInRight">
                <span class="arrow top"></span>
                <li><a href="http://www.meituan.com/acl/user/myprofile">个人信息</a></li>
                <li><a onclick="if(!confirm('你确定退出么？')) return false;" href="/logout">退出</a></li>
            </ul>
        </li>
        <li class="dropdown"><a href="http://wiki.sankuai.com/pages/viewpage.action?pageId=651397909"> 帮助 </a>
        </li>
    </ul>
</header>
</#macro>


