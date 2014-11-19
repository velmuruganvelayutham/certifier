<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="media/bootstrap/assets/ico/favicon.png">

    <title>Signin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="media/bootstrap/dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="media/bootstrap/signin.css" rel="stylesheet">

   </head>

  <body>

    <div class="container">
      <form class="form-signin" action=LoginController method="post">
        <h2 class="form-signin-heading">Certifier</h2>
         <input type="hidden" class="form-control" name="command" value="sign-up">
        <c:if test="${error != null}">
			<div class="alert alert-danger">password does not match !.</div>
		</c:if>
		<c:if test="${userexists != null}">
			<div class="alert alert-danger">Email ID already Exists !. Please try with different Email ID.</div>
		</c:if>
        <input type="text" class="form-control" placeholder="Email address" required="required" name= emailid autofocus>
        <input type="password" class="form-control" placeholder="Password" required="required" name=password>
        <input type="password" class="form-control" placeholder="confirm password" required="required" name=confirmpassword>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
       Already a member ?<button type="button" class="btn btn-lg btn-primary btn-block" onClick="JavaScript:window.location='login.jsp'">Sign In</button>
      </form>
    </div> <!-- /container -->
    <div class="container">

</div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
