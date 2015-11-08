<#include "new-main.ftl"/>


<#macro body>

    <#list users as user>
        <h3><a href="/${user.login}">${user.name} ${user.surname}</a></h3>
        <p>@${user.login}</p>
        <hr>
    </#list>

</#macro>

<@content title="Люди"/>
