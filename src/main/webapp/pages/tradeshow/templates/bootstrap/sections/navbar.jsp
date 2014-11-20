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
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>


<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">

  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><img style="max-width:100px; margin-top: -7px;" src="<c:url value="/resources/image/logo.png"/>"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Exhibitors  <span class="caret"></span></a>
         <ul class="dropdown-menu" role="menu">
            <li><a href="<c:url value="/exhibitors"/>">List All </a></li>
            <li><a href="<c:url value="/exhibitors/import"/>">Import </a></li>
             <li><a href="<c:url value="/exhibitors/export"/>">Export </a></li>
              <li><a href="<c:url value="/exhibitors/uploadDropbox"/>"> Upload Files to Dropbox </a></li>
         </ul>
        </li>
      </ul>
      <form  class="navbar-form navbar-left" role="search">
        <div class="form-group" id="bloodhound">
          <input id="search" type="text" class="typeahead" placeholder="Vendors">
        </div>
            <div class="form-group">
        <button type="submit" class="btn btn-default">Search
                <span class="glyphicon glyphicon-search"></span>
        </button>
            </div>    
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="<c:url value="/notifications"/>">Alerts
            <span class="glyphicon glyphicon-bell"></span> </a>
        </li>
        <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
	         <li class="active"><a  href="<c:url value="/settings"/>">Settings
	            <span class="glyphicon glyphicon-cog"></span> </a>
	        </li>
        </sec:authorize>
             
              <li class="active"><a  href="<c:url value="/profile"/>">Profile
            <span class="glyphicon glyphicon-user"></span> </a>
        </li>
              <li class="active"><a  href="<c:url value="/logout"/>">Log Out
            <span class="glyphicon glyphicon-off"></span> </a>
        </li>
        </ul>
       
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>