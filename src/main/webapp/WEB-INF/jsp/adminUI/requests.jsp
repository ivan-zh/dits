<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DB content editor</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>

</head>

<body>
<h4 align="center">View and edit tables</h4>

<hr class="small_centered">
<table class="centered">
    <tr>
        <td>
            <form method="get" action="/display_table/finduserbyid">
                <input name="id" type="text" placeholder="Get user by id"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/display_table/allusers">
                <input type="submit" value="Get all users"/>
            </form>
        </td>
    </tr>
</table>

<hr class="small_centered">

<table class="centered">
    <tr>
        <td>
            <form method="get" action="/display_table/findtopicbyid">
                <input name="id" type="text" placeholder="Get topic by id"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/display_table/alltopics">
                <input type="submit" value="Get all topics"/>
            </form>
        </td>
    </tr>
</table>
<table class="centered">
    <tr>
        <td>
            <form method="get" action="/display_table/findrolebyid">
                <input name="id" type="text" placeholder="Get role by id"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/display_table/allroles">
                <input type="submit" value="Get all roles"/>
            </form>
        </td>
    </tr>
</table>

<hr class="small_centered">

<table class="centered">
    <tr>
        <td>
            <form method="get" action="/display_table/findtestbyid">
                <input name="id" type="text" placeholder="Get test by id"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/display_table/findtestbytopicname">
                <input name="topicname" type="text" placeholder="Get test by topic name"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
    </tr>
    <tr class="align_to_right">
        <td>
            <form method="get" action="/display_table/alltests">
                <input type="submit" value="Get all tests"/>
            </form>
        </td>
    </tr>
</table>

<hr class="small_centered">

<table class="centered">
    <tr>
        <td>
            <form method="get" action="/display_table/findquestionbyid">
                <input name="id" type="text" placeholder="Get question by id"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/display_table/allquestions">
                <input type="submit" value="Get all questions"/>
            </form>
        </td>
    </tr>
</table>

<hr class="small_centered">

<table class="centered">
    <tr>
        <td>
            <form method="get" action="/display_table/findliteraturebyid">
                <input name="id" type="text" placeholder="Get literature by id"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/display_table/allliteratures">
                <input type="submit" value="Get all literatures"/>
            </form>
        </td>
    </tr>
</table>

<hr class="small_centered">

<table class="centered">
    <tr>
        <td>
            <form method="get" action="/display_table/findlinkbyid">
                <input name="id" type="text" placeholder="Get link by id"/>
                <input type="submit" value="Get"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form method="get" action="/display_table/alllinks">
                <input type="submit" value="Get all links"/>
            </form>
        </td>
    </tr>
</table>

</body>
</html>