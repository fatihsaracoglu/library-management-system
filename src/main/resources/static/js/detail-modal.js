$('document').ready(function() {

    $('.ui #book-btn').on('click',function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(book, status){
            $('#name').text(book.name);
            $('#author').text(book.author);
            $('#publisher').text(book.publisher);
            $('#isbn').text(book.isbn);
            $('#page').text(book.page);
            $('#date').text(book.date);
            $('#description').text(book.description);
        });

        $('#bookDetailModal').modal();
    });

    $('.ui #author-btn').on('click',function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(author, status){
            $('#author-name').text(author.name);
            $('#author-books').text(author.books);
            $('#author-desc').text(author.description);
        });

        $('#authorDetailModal').modal();
    });
});