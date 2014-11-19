<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
</head>
<body>
<%-- Log error on server side --%>
	<%
		//When the page attribute "isErrorPage" is set to "true" the exception object is available
		System.err.println("Error :  " );
	
	%>
	<img src="https://s3-us-west-2.amazonaws.com/quiz-certifier/ninja_zpsa5dbe37a.jpg">
	<b>An error occurred  !. That's all we know at this moment. </b>
<!-- 	<pre> -->
<%-- 		<% exception.printStackTrace(response.getWriter()); %> --%>
<!-- 	</pre> -->
	<%-- Display generic error to client --%>
	
</body>
</html>


