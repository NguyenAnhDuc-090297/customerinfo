$(document).ready(function () {
    $("#btn-add-modal").on("click", function () {
        $("#modal-add-organization").modal("show");
    });

    $("#btn-add-cancel").on("click", function () {
        $("#modal-add-organization").modal("hide");
    });

    $("#btn-add-org").on("click", function () {

        let formData = {
            name: $("#nameOrg").val(),
            fullName: $("#fullNameOrg").val()
        }
        $.ajax({
            type: 'POST',
            url: '/organization/add-organization',
            data: formData,
            success: function () {
                console.log("Add organization successful");
            },
            error: function (e) {
                console.log(e.toString());
            }
        });
    });
});