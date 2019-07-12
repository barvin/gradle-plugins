// reminders
$('#add-reminder-date-time').datetimepicker({
    format: 'DD.MM.YYYY HH:mm',
    sideBySide: true

});

$( "#btn-save-file" ).click(function() {
    $.ajax({
        url: 'file/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ "text": $( "#text-to-save" ).val() }),
        success: function(data){
            $( "#save-confirm" ).addClass("text-success");
            $( "#save-confirm" ).val(data);
        },
        error: function(data){
            $( "#save-confirm" ).addClass("text-danger");
            $( "#save-confirm" ).val(data.message);
        }
    });
});

$( "#text-to-save" ).keypress(function() {
    $( "#save-confirm" ).removeClass("text-success text-danger");
    $( "#save-confirm" ).val("");
});

// read file
$( "#btn-read-file" ).click(function() {
    $.ajax({
        url: 'file/read',
        type: 'GET',
        success: function(data){
            $( "#read-confirm" ).val(data);
        },
        error: function(data){
            $( "#read-confirm" ).addClass("text-danger");
            $( "#read-confirm" ).val(data.message);
        }
    });
});

// get weather
$( "#btn-get-weather" ).click(function() {
    $.ajax({
        url: 'weather/' + $( "#weather-city" ).val(),
        type: 'GET',
        success: function(data){
            $( "#weather-result-temp" ).val(data.temperature);
            $( "#weather-result-descr" ).val(data.description);
        },
        error: function(data){
            $( "#weather-error" ).val(data.responseJSON.description);
        }
    });
});

$( "#weather-city" ).keypress(function() {
    $( "#weather-result-temp" ).val("");
    $( "#weather-result-descr" ).val("");
    $( "#weather-error" ).val("");
});

// send message
$( "#btn-msg-send" ).click(function() {
    $.ajax({
        url: 'message/send',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ "sender": $( "#msg-sender" ).val(), "text": $( "#msg-text" ).val() }),
        success: function(data) {
            $( "#msg-result" ).addClass("text-success");
            $( "#msg-result" ).val(data);
        },
        error: function(data){
            $( "#msg-result" ).addClass("text-danger");
            $( "#msg-result" ).val(data.message);
        }
    });
});

$( "#msg-sender" ).keypress(function() {
    $( "#msg-result" ).removeClass("text-success text-danger");
    $( "#msg-result" ).val("");
});

$( "#msg-text" ).keypress(function() {
    $( "#msg-result" ).removeClass("text-success text-danger");
    $( "#msg-result" ).val("");
});
