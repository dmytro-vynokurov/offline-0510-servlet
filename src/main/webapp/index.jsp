<%@ page import="ua.goit.service.TopicService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Index</title>

    <script type="application/javascript">
        function printHello(){
            var message = "Hello";
            console.log(message);
        }

        function printRandomNumbers(){
            var stringBuffer = "";
            for (i = 0; i < 100; i++) {
                var r = Math.floor(Math.random() * 20);
                stringBuffer += r + " ";
            }
            var randomNumbersDOMElement = document.getElementById("random-numbers");
            randomNumbersDOMElement.innerHTML = stringBuffer;
        }

        function loadTopics(){
            var xmlHttpRequest = new XMLHttpRequest();
            xmlHttpRequest.onreadystatechange = function(){
                if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200) {
                    document.getElementById("topics").innerHTML = xmlHttpRequest.responseText;
                }
            };
            xmlHttpRequest.open("GET", "topics", true);
            xmlHttpRequest.send();
        }

    </script>

</head>
<body>


<button onclick="printHello()">Say hello</button>


<%@include file="templates/header.jsp" %>


<h1>Welcome to the index page!</h1>

<%
    TopicService topicService = new TopicService();
    List<String> topics = topicService.getTopics();
    out.println(topics);
%>
<div id="topics"></div>

<br/>
<div id="random-numbers"></div>

<form action="article" method="post">
    <input type="text" title="topic" name="topic"/>
    <button type="submit" >Submit topic</button>
</form>

<form action="navigate" method="post">
    <input type="text" name="someImportantData"/>
    <input type="text" name="pageName"/>
    <button type="submit" >Submit data and navigate to different page</button>
</form>

<a href="page2.jsp">page2</a>


</body>

<script>
    printRandomNumbers();
    loadTopics();
</script>



</html>
