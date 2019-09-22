<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
            <title>Book Info</title>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            google.charts.load('current', {'packages':['table']});
            google.charts.setOnLoadCallback(drawTable);
            function drawTable() {
            var data = new google.visualization.DataTable();
            data.addColumn('number', 'Book N');
            data.addColumn('number', 'Room N');
            data.addColumn('number', 'Total Price');
                             <#list books as book>
                               data.addRows([
                            [ {v:${book.book_no}},
                              {v: ${book.room.room_no}},
                              {v: ${book.bookPrice}, f: '$ ${book.bookPrice}'}]
                            ]);
                             </#list>
            var table = new google.visualization.Table(document.getElementById('table_div'));
            table.draw(data, {showRowNumber: true, width: '50%', height: '50%'});
        }
        </script>

        <div id="table_div"></div>
    </body>
</html>