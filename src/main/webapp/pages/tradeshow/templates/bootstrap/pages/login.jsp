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
		<div id="loginbox">
			 <a class="navbar-brand" href="#"><img align="middle"  class="" src="<c:url value="/resources/image/logo.png"/>"></a>
      <form id="loginForm" class="form-signin" role="form" method="post" action="<c:url value="/j_spring_security_check"/>">
        <h2 class="form-signin-heading">sign in</h2>
         <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#" data-toggle="modal" data-target="#forgotPasswordModal">Forgot password?</a></div>
         <c:if test="${not empty error}">
         <div class="alert alert-warning alert-dismissible" role="alert" align="center">
		  <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		  <strong>  <c:out value="${error}"></c:out> </strong> 
		</div>
		 </c:if>
		 
		   <div  class="form-group">
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
		     <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Don't have an account! 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Sign Up Here
                                        </a>
                                        </div>
            </div>
            </div> 
		       
		 </form>
	   </div>
	   <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form" >
                                
                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>                                  
                                
                                  
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="email" placeholder="Email Address">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="password" placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="confirmPassword" class="col-md-3 control-label">Confirm Password</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password">
                                    </div>
                                </div>
                                                             
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                        <span style="margin-left:8px;">or</span>  
                                    </div>
                                </div>
                                
                                <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                    
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>
                                    </div>                                           
                                        
                                </div>
                                
                                
                                
                            </form>
                         </div>
                    </div>             
               
                
         </div> 
	 
 </div>
 
 <!-- <a href="#forgotPasswordModal" role="button" class="btn btn-default" data-toggle="modal">Launch </a> -->

			<div id="forgotPasswordModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel">Forgot Password </h3>
				</div>
				<div class="modal-body">
				<form id="forgotPasswordForm" class="form-inline">
			<div class="form-group">
        <label>Email address</label>
        <input type="text" class="form-control" name="email" />
    </div>
			<button type="submit" class="btn btn-default">Submit</button></form>
				</div>
				<div class="modal-footer">
				
			</div>
			</div>
			
			</div>
</div>
        <jsp:include page="/pages/tradeshow/templates/bootstrap/sections/jsLinks.jsp" />
        <script src="<c:url value="/resources/js/certifier-bootstrap-validator.js" />"></script>
     	<tiles:insertAttribute name="footer" ignore="true"/>
</body>
</html>    
