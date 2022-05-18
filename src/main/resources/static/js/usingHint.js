$(document).ready(() => {
    $("#hint").click(() => {
        $("#modal-confirm").show();
    });

    $("#quit").click(() => {
        $("#modal-confirm").hide();
    });

    $('#getHint').click( e => {
        e.preventDefault();
        $("#modal-confirm").hide();
        $("#modal-hint").show();

        $.ajax({
            type: "GET",
            url: "/usingHint",
            success: data => {
                const numHint = data.numHint
                $('#point').remove()
                $('#point-wrapper').html(`Points : <span id="point" class="text-red text-lg">${data.point}</span>`)

                if (parseInt(numHint) === 3) {
                    const hint = $('#hint')
                    hint.attr('disabled', true)
                    hint.addClass("cursor-not-allowed")
                }

                const element = $("#modal-title-hint")
                element.text(`Hint-${numHint}`)
                const hintPlace = $('#content-hint')
                hintPlace.empty()

                for (let i = 0; i < data.hintAnswer.length; i++) {
                    let div = `<span style="font-size:15px;">Hint number (${i + 1}) is ${data.hintAnswer[i]}</span><br>`
                    hintPlace.append(div)
                }

                $('#ok').click(() => {
                    $("#modal-hint").hide();
                })
            }
        })
    });
});