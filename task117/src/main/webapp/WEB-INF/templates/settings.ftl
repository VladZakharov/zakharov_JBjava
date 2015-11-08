<div class="form-group">
    <label>Логин</label>
    <input type="text" <#if me.login??>value="${me.login}"</#if> id="login" class="form-control" rows="3" title="login"/>
</div>

<div>
    <label>Имя</label>
    <input type="text" <#if me.name??>value="${me.name}"</#if> id="name" class="form-control" rows="3" title="name"/></br>
</div>

<div>
    <label>Фамилия</label>
    <input type="text" <#if me.surname??>value="${me.surname}"</#if> id="surname" class="form-control" rows="3" title="surname"/></br>
</div>

<div>
    <label>Город</label>
    <input type="text" <#if me.city??>value="${me.city}"</#if> id="city" class="form-control" rows="3" title="city"/></br>
</div>

<div>
    <label>Дата рождения</label>
    <input type="date" <#if me.birthday??>value="${me.birthday}"</#if> id="birthday" class="form-control" rows="3" title="birthday"/>

</div>
