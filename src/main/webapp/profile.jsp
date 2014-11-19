<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored ="false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>
<body>

 <jsp:include page="navigation.jsp">
 <jsp:param value="${pageContext.request.contextPath}" name="app_path"/>
 <jsp:param value="${user}" name="user_name"/>
  </jsp:include>
<div class="container">
<div class="row">
<div class="col-md-8"> 

<form class="form-horizontal" action="ProfileController" method="post">
<c:if test="${profile_updated_success != null}">
	<div align="center" class="alert alert-success">"${profile_updated_success}"</div>
</c:if>
<c:if test="${password_not_match != null}">
	<div align="center" class="alert alert-danger">"${password_not_match}"</div>
</c:if>
<c:if test="${password_changed_success != null}">
	<div align="center" class="alert alert-success">"${password_changed_success}"</div>
</c:if>
<input type="hidden" name="command" value="update-profile"> 
<fieldset>

<!-- Form Name -->
<legend>Edit Profile</legend>

<img src="https://s3-us-west-2.amazonaws.com/quiz-certifier/ninja_zpsa5dbe37a.jpg" alt="profile image" class="img-thumbnail" height="140" width="140"> <input type="file" value="Add Value" >
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="firstName">First Name</label>
  <div class="controls">
    <input id="firstName" name="firstName" type="text" placeholder="First Name" class="input-large" required="" value="${profile.firstName}">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="lastName">Last Name</label>
  <div class="controls">
    <input id="lastName" name="lastName" type="text" placeholder="Last Name" class="input-large"  value="${profile.lastName}">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="email">Email ID </label>
  <div class="controls">
    <input id="email_id" name="emailid" type="text" placeholder="Email ID" class="input-large" required="" value="${profile.emailId}">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="email">Skype ID </label>
  <div class="controls">
    <input id="skypeid" name="skypeid" type="text" placeholder="Skype ID " class="input-large" value="${profile.skypeId}" >
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="city">City</label>
  <div class="controls">
    <input id="city" name="city" type="text" placeholder="city" class="input-large"  value="${profile.city}" >
    
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="country">Country</label>
  <div class="controls">
     <input id="country" name="country" type="text" placeholder="country" class="input-large"  value="${profile.country}">
    
  </div>
</div>

<!-- Select text -->
<div class="control-group">
  <label class="control-label" for="phone no ">Phone No </label>
  <div class="controls">
     <input id="phoneno" name="phoneno" type="text" placeholder="Phone No" class="input-large"  value="${profile.phoneNo}">
    
  </div>
</div> 

<!-- Textarea -->
<div class="control-group">
  <label class="control-label" for="description">Description</label>
  <div class="controls">                     
    <textarea id="description" name="description"> "${profile.description}"</textarea>
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="generalSave"></label>
  <div class="controls">
    <input type="submit" id="generalSave" name="generalSave" class="btn btn-primary" value="save">
  </div>
</div>
<br>
</form>

<form  class="form-horizontal"  action="ProfileController" method="post">
<input type="hidden" name="command" value="change-password"> 
<legend>Change Password</legend>


<!-- Password input-->
<div class="control-group">
  <label class="control-label" for="oldPassword">Old Password</label>
  <div class="controls">
    <input id="oldPassword" name="oldPassword" type="password" placeholder="Old Password" class="input-large" required="">
    
  </div>
</div>

<!-- Password input-->
<div class="control-group">
  <label class="control-label" for="newPassword">New Password</label>
  <div class="controls">
    <input id="newPassword" name="newPassword" type="password" placeholder="New Password" class="input-large" required="">
    
  </div>
</div>

<!-- Password input-->
<div class="control-group">
  <label class="control-label" for="confirmPassword">Confirm Password</label>
  <div class="controls">
    <input id="confirmPassword" name="confirmPassword" type="password" placeholder="Confirm Password" class="input-large" required="">
    
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="changePassword"></label>
  <div class="controls">
    <input type="submit" id="changePassword" name="changePassword" class="btn btn-primary" value="change">
  </div>
</div>

</fieldset>
</form>
</div>
</div>

</div>
<%@ include file="javascript.jsp" %>
</body>
</html>