<%--
  Created by IntelliJ IDEA.
  User: trinh
  Date: 8/24/2019
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>List Event</title>
</head>
<body>
List event
<div>
   <s:iterator value="eventList">
       <s:property value="location"/>
       <s:url var="editURL" action="event-edit">
           <s:param name="idEventEdit" value="%{id}"></s:param>
       </s:url>
       <s:a href="%{editURL}">Edit</s:a>  <span style="margin-right: 10px"></span>
       <s:url var="deleteURL" action="event-delete">
           <s:param name="idEventDelete" value="%{id}"></s:param>
       </s:url>
       <s:a href="%{deleteURL}">Delete</s:a>
       <br>
   </s:iterator>
</div>
</body>
</html>
