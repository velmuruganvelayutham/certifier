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
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
  

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/resources/templates/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
	<!-- Favicon icon -->
    <link href="<c:url value="/resources/image/blue-butterfly-152-181696.png" />" rel="shortcut icon">
    <!--     signin custom css  -->
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
    <title>Signin</title>
  </head>
  <body>
 <div class="container">
		
	 <a class="navbar-brand" href="#"><img align="middle"  class="" src="<c:url value="/resources/image/logo.png"/>"></a>
      <form class="form-signin" role="form" method="post" action="<c:url value="/j_spring_security_check"/>">
        <h2 class="form-signin-heading">sign in</h2>
         <c:if test="${not empty error}">
         <div class="alert alert-warning alert-dismissible" role="alert" align="center">
		  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		  <strong>  <c:out value="${error}"></c:out> </strong> 
		</div>
		 </c:if>
		 
		   <div class="form-group">
				    <label for="username">Username:</label>
				    <input name ="j_username" type="text" class="form-control" placeholder="Username" required autofocus>
		   </div>
		    <div class="form-group">
				    <label for="password">Password:</label>
				    <input name ="j_password" type="password" class="form-control" placeholder="Password" required>
		    </div>
		       
		     <div class="form-group">
		    		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		    </div>
		       
	 </form>
 </div>
<%--      <jsp:include page="/pages/tradeshow/templates/bootstrap/sections/jsLinks.jsp" /> --%>

     	<tiles:insertAttribute name="footer" ignore="true"/>
</body>
</html>    
