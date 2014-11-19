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
        <input type="hidden" class="form-control" name="command" value="forgot-password">
        <c:if test="${logout_success != null}">
			<div class="alert alert-success">Successfully logged out.</div>
		</c:if>
        <button type="button" class="btn btn-link" onClick="JavaScript:window.location='login.jsp'" >sign-in again</button>
      </form>
    </div> <!-- /container -->
    <div class="container">

</div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
