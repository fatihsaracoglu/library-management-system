$('document').ready(function() {

    $('.table .btn-warning').on('click',function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(book, status){
            $('#idEdit').val(book.id);
            $('#nameEdit').val(book.name);
            $('#authorEdit').val(book.author);
            $('#publisherEdit').val(book.publisher);
            $('#isbnEdit').val(book.isbn);
            $('#pageEdit').val(book.page);
            $('#dateEdit').val(book.date);
            $('#descEdit').val(book.description);
        });

        $('#editModal').modal();
    });

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();

    });

});