<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored ="false" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="header.jsp" %>
 <body>
 <jsp:include page="navigation.jsp">
 <jsp:param value="${pageContext.request.contextPath}" name="app_path"/>
 <jsp:param value="${user}" name="user_name"/>
  </jsp:include>

<jsp:include page="exam_menu.jsp"> 
  <jsp:param value="value" name="name"/>
 </jsp:include>



    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <img src="https://s3-us-west-2.amazonaws.com/quiz-certifier/blue_eyes_cute_baby-wide.jpg" height="300" width="300" />
        <h1>Hello, <c:out value="${sessionScope.user}"/> </h1> 
        <p>Welcome to certifier. You can take all these mock exams absolutely for free of cost... The questions are updated regularly.</p>
      </div>
     </div>

    <div class="container">
      <hr>
      <jsp:include page="contact-us.jsp"> 
     		 <jsp:param value="value" name="name"/>
      </jsp:include>
      <jsp:include page="about-us.jsp">
      		  <jsp:param value="value" name="name"/>
      </jsp:include>
      <footer>
         <p>All rights reserved to &copy; Certifier Inc. 2012-2013.Developed and maintained by Velmurugan Velayutham , Software Engineer at Sigma Infosolutions Pvt Ltd.</p>
      </footer>
    </div> <!-- /container -->

<%@ include file="javascript.jsp" %>

  </body>
</html>
