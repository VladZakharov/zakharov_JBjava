<#include "new-main.ftl"/>

<#macro body>

<div id="settings" class="content profile">

</div>
<div>
    <input type="submit" id="save">
</div>

</#macro>

<@content title="Настройки" customScripts=["resources/js/update-user.js"]/>