<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>


</head>
<body>
h1>Available Bokking list</h1>
h1>Users list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>

    </tr>
    <#list room as room>
        <tr>

            <td>${room.room_no}</td>
            <td>${room.room_type}</td>


        </tr>
    </#list>
</table>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
    </tr>
    <#list rooms as room>
        <tr>

            <td>${room.room_no}</td>
            <td>${room.room_type}</td>


        </tr>
    </#list>
    </table>


</body>
</html>