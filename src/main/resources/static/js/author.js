$(document).ready(function() {

    $('.table .btn-warning').on('click',function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(author, status){
            $('#idEdit').val(author.id);
            $('#nameEdit').val(author.name);
            $('#booksEdit').val(author.books);
            $('#descriptionEdit').val(author.description);
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

let addRow = function () {
    let listName = 'books'; //list name in Catalog.class
    let fieldsNames = ['name']; //field names from Movie.class
    let rowIndex = document.querySelectorAll('.item').length; //we can add mock class to each movie-row

    let row = document.createElement('div');
    row.classList.add('row', 'item');

    fieldsNames.forEach((fieldName) => {
        let col = document.createElement('div');
        col.classList.add('col', 'form-group');

        let input = document.createElement('input');
        input.type = 'text';
        input.classList.add('form-control');

        col.appendChild(input);
        row.appendChild(col);
    });
    document.getElementById('frm').appendChild(row);
};

let getTexts = function () {
    var newValue = "";
    var spacer = ", ";
    var elements = document.getElementById("frm").getElementsByTagName('input');
    for(i = 0; i < elements.length; i++) {
        newValue += elements[i].value;
        if (i !== elements.length - 1) {
            newValue += spacer;
        }
    }
    let input = document.getElementById('books-field');
    input.value = newValue;
};

$('#addForm').submit(function() {
    getTexts();
    return true;
});