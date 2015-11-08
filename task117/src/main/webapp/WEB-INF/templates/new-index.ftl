<#include "new-main.ftl"/>


<#macro body>
<!--Profile container-->
<div class="container profile" id="${user.id}">
    <div class="span3"><img src="../../resources/img/mini.png"></div>
    <div class="span5">
        <h1>
            <#if user.name??>
            ${user.name}
            <#else>
                NAME
            </#if>
            <#if user.surname??>
            ${user.surname}
            <#else>
                SURNAME
            </#if>
        </h1>

        <p>
            <#if user.city??>
                Город: ${user.city}<br>
            </#if>
            <#if user.birthday??>
                Дата рождения: ${user.birthday}<br>
            </#if>
        </p>
        <a href="#myModal" role="button" data-toggle="modal" class="hire-me"><i class="icon-paper-plane"></i> Написать </a></div>
</div>
<!--END: Profile container-->
<div id="js-posts" class="col-lg-6 col-lg-offset-3">

</div>
    <#include "social-icons.ftl"/>

<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel"><i class="icon-mail"></i> Написать на стене</h3>
    </div>
    <div class="modal-body">
        <form>
            <textarea id="js-post-text" rows="3" style="width:80%"></textarea>
            <br/>
            <button id="js-sendpost" type="submit" class="btn btn-large"><i class="icon-paper-plane"></i> Отправить</button>
        </form>
    </div>
</div>
<!-- Scripts -->
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script>$('#myModal').modal('hidden')</script>
</#macro>

<@content title="Моя страница" customScripts=["resources/js/post.js"]/>
