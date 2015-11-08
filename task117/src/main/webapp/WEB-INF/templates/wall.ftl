<#list posts as post>
<div>
    <p>${post.text}</p>
    <p>${post.createdAt} by <a href="/${post.user.login}"> ${post.user.name} ${post.user.surname}</a></p>
    <hr>
</div>
</#list>