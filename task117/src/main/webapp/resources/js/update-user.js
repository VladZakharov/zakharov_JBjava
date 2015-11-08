$(document).ready(function () {
    getSettings();

    $("#save").on("click", function () {
        update()
    });
});

function update() {
    var login = $("#login").val();
    var name = $("#name").val();
    var surname = $("#surname").val();
    var showPostsAnon = $("#showPostsAnon").val();
    var city = $("#city").val();
    var birthday = $("#birthday").val();

    $.ajax({
        url: "/apply_settings",
        type: "POST",
        data: {
            login: login,
            name: name,
            surname: surname,
            city: city,
            birthday: birthday
        },
        success: success()
    });
}

function success() {
    //alert("Данные успешно обновлены!");
    window.location.replace('/')
}

function getSettings() {
    $.ajax({
        url: "/get_settings",
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#settings").html(data);
        }
    })
}
