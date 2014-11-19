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
        <input type="hidden" class="form-control" name="command" value="forgot-password">
        <c:if test="${emailidnotfound != null}">
			<div class="alert alert-danger">Email ID not found !. Please try with different Email ID.</div>
		</c:if>
		<c:if test="${emailidfound != null}">
			<div class="alert alert-info">Password has been sent to the given email address.</div>
		</c:if>
        <input type="text" class="form-control" placeholder="Email address" required="required" name= emailid autofocus>
        <button type="button" class="btn btn-link" onClick="JavaScript:window.location='login.jsp'" >sign-in</button>
        <button type="button" class="btn btn-link" onClick="JavaScript:window.location='signup.jsp'" >sign-up</button>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Get Password</button>
      </form>
    </div> <!-- /container -->
    <div class="container">

</div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
