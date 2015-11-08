<#include "main-template.ftl"/>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <@security.authentication property="principal" var="cur_user"/>
</@security.authorize>

<#macro m_body>

<div class="user-info" id="${user.id}">
    <h2>${user.login}</h2>
    <#if user.name??>
        <h3>${user.name}</h3>
    </#if>
    <#if user.surname??>
        <h3>${user.surname}</h3>
    </#if>
    <#if user.birthday??>
        <h3>${user.birthday}</h3>
    </#if>
    <#if user.city??>
        <h3>${user.city}</h3>
    </#if>
</div>

<#if cur_user??>
    <div class="col-lg-6 col-lg-offset-3">
        <textarea id="js-post-text" class="form-control" rows="3" title="post"></textarea>
        <input type="submit" id="js-sendpost">
    </div>

    <div id="js-posts" class="col-lg-6 col-lg-offset-3">

    </div>
</#if>

</#macro>

<@main title="Главная" customScripts=["resources/js/post.js"]/>