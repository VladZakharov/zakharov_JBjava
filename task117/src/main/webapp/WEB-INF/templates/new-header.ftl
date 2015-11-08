<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <@security.authentication property="principal.login" var="login"/>
</@security.authorize>

<div class="navbar">
    <div class="navbar-inner">
        <div class="container"><a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span
                class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a> <a
                class="brand" href="/"><img src="../../resources/img/user.jpg"/></a>
            <ul class="nav nav-collapse pull-right">
                <li><a href="/" class="active"><i class="icon-user"></i> Профиль</a></li>
                <li><a href="/settings"><i class="icon-trophy"></i> Наcтройки</a></li>
                <li><a href="/users"><i class="icon-picture"></i> Люди</a></li>
                <li>
                    <#if login??>
                        <a href="/logout"><i class="icon-doc-text"></i> Выйти</a>
                    <#else>
                        <a href="/login"><i class="icon-doc-text"></i> Войти</a>
                    </#if>
                </li>
            </ul>
            <!-- Everything you want hidden at 940px or less, place within here -->
            <div class="nav-collapse collapse">
                <!-- .nav, .navbar-search, .navbar-form, etc -->
            </div>
        </div>
    </div>
</div>