<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testing system</title>
    <link rel="stylesheet" href="/css/common_style.css" type="text/css"/>
</head>
<body>

<h4 align="center">Welcome to Dev Inc Testing system !</h4>

<table align="center" border="0" cellspacing="2">
    <tbody>
    <tr>
        <td rowspan="2">
            <img width="50%" height="50%" src="/resources/images/human1.png">
        </td>
    </tr>
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
