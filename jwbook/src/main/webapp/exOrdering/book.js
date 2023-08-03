function validateBook() {
    if (!$('#title').val()) {
        throw 'nameRequired';
    }
}

function updateBook(event) {
    try {
        validateBook();

        $('#book_form_action').val('setBook');
        $('#book_form')[0].submit();
    } catch (e) {
        switch (e) {
            case 'nameRequired':
                alert('이름을 입력해 주십시오.');
                break;
        }
        event.preventDefault();
    }
}

function deleteBook() {
    $('#book_form_action').val('removeBook');
    $('#book_form')[0].submit();
}

$(function () {
    $('#update_button').click(updateBook);
    $('#delete_button').click(deleteBook);
});