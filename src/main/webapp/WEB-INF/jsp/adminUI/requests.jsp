<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DB content editor</title>
    <link rel="stylesheet" href="<c:url value="/css/stat_table.css"/>" type="text/css"/>
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
            <form method="get" action="/display_table/finduserbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all users--%>
            <form method="get" action="/display_table/allusers">
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
            <form method="get" action="/display_table/findtopicbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all topics--%>
            <form method="get" action="/display_table/alltopics">
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
            <form method="get" action="/display_table/findrolebyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all roles--%>
            <form method="get" action="/display_table/allroles">
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
            <form method="get" action="/display_table/findtestbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            Get test by topic name
            <form method="get" action="/display_table/findtestbytopicname">
                <input name="topicname" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all tests--%>
            <form method="get" action="/display_table/alltests">
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
            <form method="get" action="/display_table/findquestionbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all questions--%>
            <form method="get" action="/display_table/allquestions">
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
            <form method="get" action="/display_table/findliteraturebyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all literatures--%>
            <form method="get" action="/display_table/allliteratures">
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
            <form method="get" action="/display_table/findlinkbyid">
                <input name="id" type="text"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
        <td>
            <%--Get all links--%>
            <form method="get" action="/display_table/alllinks">
                <input type="submit" value="Get all links"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
