<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>

<div class="col-md-4 col-md-offset-4">
<@sf.form action="/registration" method="post" modelAttribute="userform">
    <div class="form-group">
        <label for="login">Логин</label>
        <@sf.input path="login" id="login" cssClass="form-control" placeholder="Логин"/>
        <@sf.errors path="login"/>
    </div>
    <div class="form-group">
        <label for="name">Имя</label>
        <@sf.input path="name" id="name" cssClass="form-control" placeholder="Имя"/>
        <@sf.errors path="name"/>
    </div>
    <div class="form-group">
        <label for="surname">Фамилия</label>
        <@sf.input path="surname" id="surname" cssClass="form-control" placeholder="Фамилия"/>
        <@sf.errors path="surname"/>
    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <@sf.input path="password" id="password" cssClass="form-control" placeholder="Пароль"/>
        <@sf.errors path="password"/>
    </div>
    <div class="form-group">
        <label for="repassword">Повторите пароль</label>
        <@sf.input path="repassword" id="repassword" cssClass="form-control" placeholder="Повторите пароль"/>
        <@sf.errors path="repassword"/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <@sf.input path="email" id="email" cssClass="form-control" placeholder="Email"/>
        <@sf.errors path="email"/>
    </div>
    <div class="form-group">
        <label for="city">Город</label>
        <@sf.input path="city" id="city" cssClass="form-control" placeholder="Город"/>
        <@sf.errors path="city"/>
    </div>
    <#--<div class="form-group">-->
        <#--<label for="gender">Пол</label>-->
        <#--<#switch gender>-->
            <#--<#case "MALE">Male<#break>-->
            <#--<#case "FEMALE">Female<#break>-->
        <#--</#switch>-->
    <#--</div>-->
    <button type="submit" class="btn btn-default">Submit</button>
</@sf.form>
</div>

</#macro>
<@main title="Главная"/>