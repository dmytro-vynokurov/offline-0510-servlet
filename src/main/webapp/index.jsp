<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>

<%@include file="templates/header.jsp" %>


<h1>Welcome to the index page!</h1>


<form action="article" method="post">
    <input type="text" title="topic" name="topic"/>
    <button type="submit" >Submit topic</button>
</form>


</body>
</html>
