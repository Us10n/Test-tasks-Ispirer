$(document).ready(function () {
    console.log("ready")

    $('select#langSelect').on('change', function () {
        $.ajax({
            url: "http://localhost:8080/main",
            method: "POST",
            success: changeButtonText,
            headers: {
                'Accept-Language': this.value
            }
        })
    });

    $('button#pressButton').click(function () {
        $.ajax({
            url: "http://localhost:8080/main",
            method: "GET",
            success: printLabel,
            headers: {
                'Accept-Language':$('select#langSelect').val()
            }
        })
    })
});

function printLabel(data) {
    $('p#textLabel').text(data)
}

function changeButtonText(data) {
    $('button#pressButton').text(data)
}