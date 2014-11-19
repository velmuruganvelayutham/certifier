<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <%@ include file="header.jsp" %>
  <body>
    <div class="container">
      <form class="form-signin" action=LoginController method="post">
        <h2 class="form-signin-heading">Certifier</h2>
<!--         <div class="alert alert-danger">Invalid Username/Password</div> -->
        <c:if test="${error != null}">
		<div class="alert alert-danger">Invalid Username/Password</div>
		</c:if>
        <input type="hidden" class="form-control" name="command" value="sign-in">
        <input type="text" class="form-control" placeholder="Email address" required="required" name= emailid autofocus>
        <input type="password" class="form-control" placeholder="Password" required="required" name=password>
      <button type="button" class="btn btn-link" onClick="JavaScript:window.location='forgot_password.jsp'" >forgot password ?</button>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
       Not a member yet !<button type="button" class="btn btn-lg btn-primary btn-block" onClick="JavaScript:window.location='signup.jsp'">Sign Up</button>
     <button type="button" class="btn btn-link" onClick="JavaScript:window.location='home.jsp'" >Continue as Guest.</button>
      </form>
    </div> <!-- /container --> 
    <div class="container">

</div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
