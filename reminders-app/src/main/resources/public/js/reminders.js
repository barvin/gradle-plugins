// reminders

function displayReminders(reminders) {
    $( "#reminders-list" ).empty();
    for (var i = 0; i < reminders.length; i++) {
        var reminder = reminders[i];
        $( "#reminders-list" ).append(
        '<div class="input-group col-10 mb-3 reminder" rem-id="' + i + '" style="padding-left: 0;">' +
        '    <div class="input-group-prepend">' +
        '        <div class="input-group-text">' +
        '            <input type="checkbox" class="is-done">' +
        '        </div>' +
        '    </div>' +
        '    <input type="text" class="form-control reminder-text" value="' +
        reminder.text + '">' +
        '    <input type="text" class="form-control reminder-date col-2" value="' +
        moment(reminder.time).format("DD.MM.YYYY HH:mm") + '">' +
        '    <div class="input-group-append">' +
        '        <button class="btn btn-outline-secondary update" type="button">Update</button>' +
        '        <button class="btn btn-outline-secondary delete" type="button">Delete</button>' +
        '    </div>' +
        '</div>');

        if (reminder.done) {
            $( "div[rem-id='" + i + "'] .is-done" ).attr("checked", true);
            $( "div[rem-id='" + i + "'] .reminder-text" ).css("text-decoration", "line-through");
        }

        $( "div[rem-id='" + i + "'] button.update" ).click(function() {
            var remId = $(this).parent().parent().attr("rem-id");
            $.ajax({
                url: 'reminder',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(
                {
                    "id"  : remId,
                    "text": $( "div[rem-id='" + remId + "'] .reminder-text" ).val(),
                    "time": moment($( "div[rem-id='" + remId + "'] .reminder-date" ).val(), "DD.MM.YYYY HH:mm").toISOString(),
                    "done": $( "div[rem-id='" + remId + "'] .is-done" ).is(":checked")
                }),
                error: function(data){
                    alert(data);
                }
            });
        });

        $( "div[rem-id='" + i + "'] .is-done" ).click(function() {
            var remId = $(this).parent().parent().parent().attr("rem-id");
            $.ajax({
                url: 'reminder',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(
                {
                   "id"  : remId,
                   "text": $( "div[rem-id='" + remId + "'] .reminder-text" ).val(),
                   "time": moment($( "div[rem-id='" + remId + "'] .reminder-date" ).val(), "DD.MM.YYYY HH:mm").toISOString(),
                   "done": $( "div[rem-id='" + remId + "'] .is-done" ).is(":checked")
                }),
                success: function(data) {
                    if ($( "div[rem-id='" + remId + "'] .is-done" ).is(":checked")) {
                        $( "div[rem-id='" + remId + "'] .reminder-text" ).css("text-decoration", "line-through");
                    } else {
                        $( "div[rem-id='" + remId + "'] .reminder-text" ).css("text-decoration", "");
                    }
                },
                error: function(data){
                   alert(data);
                }
            });
        });

        $( "div[rem-id='" + i + "'] button.delete" ).click(function() {
            var remId = $(this).parent().parent().attr("rem-id");
            $.ajax({
                url: 'reminder?id=' + remId,
                type: 'DELETE',
                contentType: 'application/json',
                success: function() {
                    $( "div[rem-id='" + remId + "']" ).remove();
                    var existingItems = $( "div.reminder" );
                    for (var j = 0; j < existingItems.length; j++) {
                        $(existingItems.get(j)).attr("rem-id", j);
                    }
                },
                error: function(data){
                    alert(data);
                }
            });
        });
    }
}

$.ajax({
    url: 'reminder',
    type: 'GET',
    contentType: 'application/json',
    success: displayReminders,
    error: function(data){
        alert(data);
    }
});

$('#add-reminder-date-time').datetimepicker({
    format: 'DD.MM.YYYY HH:mm',
    sideBySide: true

});

$( "#btn-add-reminder" ).click(function() {
    $.ajax({
        url: 'reminder',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(
        {
            "text": $( "#add-reminder-text" ).val(),
            "time": moment($( "#add-reminder-date-time input" ).val(), "DD.MM.YYYY HH:mm").toISOString(),
            "done": false
        }),
        success: function(){
            $.ajax({
                url: 'reminder',
                type: 'GET',
                contentType: 'application/json',
                success: displayReminders,
                error: function(data){
                    alert(data);
                }
            });
        },
        error: function(data){
            alert(data);
        }
    });
});
