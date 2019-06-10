<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DITS</title>
</head>
<body>

<h1>Welcome to Dev Incubator Testing System!</h1>
<table border="0" cellspacing="2">
    <tr>
        <td><img src="../../resources/images/human1.png"></td>
        <td>
            <form action="login" method="post">
                <b>Login:</b> <input name="login" value=${login} type="text">
                <br>
                <b>Pass: </b> <input name="password" value="" type="password">
                <br>
                <input type="submit" value="login"/>
            </form>
        </td>
    </tr>

</table>

</body>
</html>
