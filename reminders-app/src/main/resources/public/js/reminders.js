// reminders
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
                success: function(data){
                    $( "#reminders-list" ).empty();
                    data.forEach(function(reminder) {
                        $( "#reminders-list" ).append('' +
    '                    <div class="input-group col-10 mb-3 reminder" style="padding-left: 0;">' +
    '                        <div class="input-group-prepend">' +
    '                            <div class="input-group-text">' +
    '                                <input type="checkbox" class="is-done">' +
    '                            </div>' +
    '                        </div>' +
    '                        <input type="text" class="form-control reminder-text" value="'+reminder.text+'">' +
    '                        <input type="text" class="form-control reminder-date col-2" value="'+reminder.time+'">' +
    '                        <div class="input-group-append">' +
    '                            <button class="btn btn-outline-secondary update" type="button">Update</button>' +
    '                            <button class="btn btn-outline-secondary delete" type="button">Delete</button>' +
    '                        </div>' +
    '                    </div>' +
                        '');
                    });
                },
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
