<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DITS</title>
</head>
<body>

<table align="center" border="0" style="width: 400px" cellspacing="2">
    <tbody>
    <tr>
        <td>
            <form action="login" method="post">
                <table>
                    <tr style="width: 50%">
                        <td><b>Login:</b></td>
                        <td><input name="loginname" value=${loginname} type="text"></td>
                    </tr>
                    <tr>
                        <td><b>Pass:</b></td>
                        <td><input name="password" value="" type="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;"><input type="submit" value="login"/></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
