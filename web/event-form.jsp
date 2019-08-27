<%--
  Created by IntelliJ IDEA.
  User: trinh
  Date: 8/24/2019
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
    <title> Create new Event</title>
    <style>
        .inline {
            display: inline;
        }

        .mr-2 {
            margin-right: 20px;
        }
    </style>
</head>
<body>
<s:form action="store" method="POST">
    <s:textfield label="When? " type="date" name="event.date"/>
    <s:textfield type="time" name="event.time"/>
    <s:textfield label="What are you planning? " name="event.plane" />
    <s:textfield label="Where? " name="event.location" />
    <s:textfield label="More info?" name="event.info" />
    <s:submit action="store"/>
</s:form>
</body>
</html>
