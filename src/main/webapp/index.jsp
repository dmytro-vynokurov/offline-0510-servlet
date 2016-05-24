<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Index</title>
</head>
<body>

<%@include file="templates/header.jsp" %>


<h1>Welcome to the index page!</h1>

<c:forEach items="${topics}" var="topic">
    ${topic},
</c:forEach>



<br/>
<br/>
${topics}
<br/>
<br/>

<br/>
<%=request.getAttribute("topics")%>


<form action="article" method="post">
    <input type="text" title="topic" name="topic"/>
    <button type="submit" >Submit topic</button>
</form>


</body>
</html>
