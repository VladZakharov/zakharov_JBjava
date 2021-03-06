<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <@security.authentication property="principal.login" var="login"/>
</@security.authorize>

<header>
    <div class="col-lg-3 col-lg-offset-9 userside">
    <#if login??>
        <p>${login} <a href="/logout"> Выйти</a> </p>
    <#else>
        <p><a href="/registration">Зарегистрироваться</a> или <a href="/login">Войти</a></p>
    </#if>
    </div>
</header>