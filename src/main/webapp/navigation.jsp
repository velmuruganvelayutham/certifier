   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">CERTIFIER</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="${pageContext.request.contextPath}/home.jsp">Home</a></li>
            <li><a id="about-us" href="#about">About</a></li>
            <li><a id="contact-us" href="#contact">Contact</a></li>
            <li id="user_dropdown" class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		        <c:choose>
				      <c:when test="${empty user}">
				        <c:out value="Guest"/>
				      </c:when>
				      <c:otherwise>
 						 <c:out value="${user}"/>				    
				      </c:otherwise>
				</c:choose>
 					
               <b class="caret"></b></a>
              <ul class="dropdown-menu">
<%--            <li><a href="${pageContext.request.contextPath}/profile.jsp">Profile</a></li> --%>
 				<li><a href="${pageContext.request.contextPath}/ProfileController">Profile</a></li>
                <li><a href="#">Exam Statistics</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="LogoutController">Log Out</a> </li>
              </ul>
            </li>
          </ul>
        </div><!--/.navbar-collapse -->
      </div>
    </div>
    <jsp:include page="contact-us.jsp"> 
     		 <jsp:param value="value" name="name"/>
      </jsp:include>
      <jsp:include page="about-us.jsp">
      		  <jsp:param value="value" name="name"/>
      </jsp:include>