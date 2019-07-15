<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DB content editor</title>
    <link rel="stylesheet" href="/css/requests.css" type="text/css"/>
</head>

<body>
<p>Hello, ${greetname}!</p>
<br>
<p>View and edit tables</p>
<hr>
<table>
    <tr>
        <td>
            Get user by id
            <form method="get" action="finduserbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all users--%>
            <form method="get" action="allusers">
                <input type="submit" value="Get all users"/>
            </form>
        </td>
    </tr>
</table>
<hr>
<table>
    <tr>
        <td>
            Get topic by id
            <form method="get" action="findtopicbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all topics--%>
            <form method="get" action="alltopics">
                <input type="submit" value="Get all topics"/>
            </form>
        </td>
    </tr>
</table>
<hr>
<table>
    <tr>
        <td>
            Get role by id
            <form method="get" action="findrolebyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all roles--%>
            <form method="get" action="allroles">
                <input type="submit" value="Get all roles"/>
            </form>
        </td>
    </tr>
</table>
<hr>
<table>
    <tr>
        <td>
            Get test by id
            <form method="get" action="findtestbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            Get test by topic name
            <form method="get" action="findtestbytopicname">
                <input name="topicname" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all tests--%>
            <form method="get" action="alltests">
                <input type="submit" value="Get all tests"/>
            </form>
        </td>
    </tr>
</table>
<hr>
<table>
    <tr>
        <td>
            Get question by id
            <form method="get" action="findquestionbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all questions--%>
            <form method="get" action="allquestions">
                <input type="submit" value="Get all questions"/>
            </form>
        </td>
    </tr>
</table>
<hr>
<table>
    <tr>
        <td>
            Get literature by id
            <form method="get" action="findliteraturebyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all literatures--%>
            <form method="get" action="allliteratures">
                <input type="submit" value="Get all literatures"/>
            </form>
        </td>
    </tr>
</table>
<hr>
<table>
    <tr>
        <td>
            Get link by id
            <form method="get" action="findlinkbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all links--%>
            <form method="get" action="alllinks">
                <input type="submit" value="Get all links"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
