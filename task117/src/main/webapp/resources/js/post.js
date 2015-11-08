$(document).ready(function () {
    updateUserPage();

    $("#js-sendpost").on("click", function () {
        sendPost()
    });
});

function sendPost() {
    $input = $("#js-post-text");
    var text = $input.val();
    if (text.length == 0) {
        return;
    }
    var user_id = $(".profile").attr('id');
    $.ajax({
        url: "/posts/add",
        type: "POST",
        data: {
            text: text,
            user_wall_id: user_id
        },
        success: function () {
            updateUserPage();
        }
    });
    $input.val('');
}

function updateUserPage() {
    if ($("#js-posts") == undefined) {
        return;
    }
    var user_id = $(".profile").attr('id');
    console.log("id = " + user_id);
    $.ajax({
        url: "/posts/wall" + user_id,
        type: "GET",
        dataType: "html",
        success: function (data) {
            $("#js-posts").html(data);
        }
    })
}
