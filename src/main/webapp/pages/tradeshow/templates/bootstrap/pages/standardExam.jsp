<%
response.setCharacterEncoding("UTF-8");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
 
<div id="jbootquiz" data-toggle="jbootquiz" > </div>


<link href="<c:url value="/resources/css/bootstrap-table.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap-table.js" />"></script>
<script src="resources/js/jquery-bootstrap-quiz.js"></script>
			
		