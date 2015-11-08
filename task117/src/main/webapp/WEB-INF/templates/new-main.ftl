<#macro content title="Hello!" customScripts=[] customStyles=[]>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <!-- styles -->
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
<#--<link href="/resources/css/bootstrap-responsive.css" rel="stylesheet">-->
    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/fonts/css/fontello.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
    <#list customStyles as style>
        <link rel="stylesheet" type="text/css" href="${style}"/>
    </#list>

<#--scripts-->
    <script src="/resources/js/jquery-2.1.3.min.js"></script>
    <#list customScripts as script>
        <script src="${script}"></script>
    </#list>

</head>
<body>
    <#include "new-header.ftl"/>

<div class="content">
    <@body/>
</div>

</body>
</html>
</#macro>