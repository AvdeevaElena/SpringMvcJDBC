<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Available Booing list</title>
    <script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>

    <script language="javascript">
        function checkOnly(stayChecked)
        {
            with(document.myForm)
            {
                for(i = 0; i < elements.length; i++)
                {
                    if(elements[i].checked == true && elements[i].name != stayChecked.name)
                    {
                        elements[i].checked = false;
                    }

                    if(elements[i].name == stayChecked.name) {

                        elements[i+1].checked = true;
                    }




                }
            }
        }
    </script>

</head>
<body>
<h1>Available Booking list 3456  </h1>
<form name="room" action="/bookRoom" method="post">
    <textarea  title="checkIn" type="text" readonly name="checkIn"   value="${dateCheckIn}">   ${dateCheckIn} </textarea></p> <br>
    <textarea  title="checkOut" type="text" readonly name="checkOut"   value="${dateCheckOut}">   ${dateCheckOut} </textarea></p> <br>
    <h2> Pick the room </h2>
    <#list rooms as room>

        <input type="radio" name="roomNoAndPrice" onclick="checkOnly(this)" value="${room.room_no},${room.roomPrice}" >${room.category} ${room.roomPrice}<br>

    </#list>

    <h2>Fill in the form regisration<h2>
            <p>Name</p>
            <input title="Name" type="text" name="name">
            <p>Surname</p>
            <input title="Name" type="text" name="lastName">
            <p>Email</p>
            <input title="Email" type="text" name="email">
            <p>Age</p>
            <input title="Age" type="text" name="age">

            <input type="submit" value="BOOK NOW">
</form>
</body>
</html>